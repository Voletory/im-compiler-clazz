package com.zpp.compile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @author steven.zhu 2020/3/31 12:48.
 * @类描述：
 */
public abstract class AbstractResource implements Resource {
    @Override
    public boolean exists() {
        try {
            return getFile().exists();
        } catch (IOException io) {
            try {
                getInputStream().close();
                return true;
            } catch (Throwable alx) {
                return false;
            }
        }
    }

    /**
     * This implementation always returns {@code true}.
     */
    @Override
    public boolean isReadable() {
        return true;
    }

    /**
     * This implementation always returns {@code false}.
     */
    @Override
    public boolean isOpen() {
        return false;
    }

    /**
     * This implementation always returns {@code false}.
     */
    @Override
    public boolean isFile() {
        return false;
    }

    /**
     * This implementation throws a FileNotFoundException, assuming
     * that the resource cannot be resolved to a URL.
     */
    @Override
    public URL getURL() throws IOException {
        throw new FileNotFoundException(getDescription() + " cannot be resolved to URL");
    }

    /**
     * This implementation builds a URI based on the URL returned
     * by {@link #getURL()}.
     */
    @Override
    public URI getURI() throws IOException {
        URL url = getURL();
        try {
            return new URI(url.toString().replace("", "%20"));
        } catch (URISyntaxException ex) {
            throw new IOException("Invalid URI [" + url + "]", ex);
        }
    }

    /**
     * This implementation throws a FileNotFoundException, assuming
     * that the resource cannot be resolved to an absolute file path.
     */
    @Override
    public File getFile() throws IOException {
        throw new FileNotFoundException(getDescription() + " cannot be resolved to absolute file path");
    }

    /**
     * This implementation returns {@link Channels#newChannel(InputStream)}
     * with the result of {@link #getInputStream()}.
     * <p>This is the same as in {@link Resource}'s corresponding default method
     * but mirrored here for efficient JVM-level dispatching in a class hierarchy.
     */
    @Override
    public ReadableByteChannel readableChannel() throws IOException {
        return Channels.newChannel(getInputStream());
    }

    @Override
    public long contentLength() throws IOException {
        try (InputStream inputStream = getInputStream()) {
            long size = 0;
            byte[] buf = new byte[256];
            int read;
            while ((read = inputStream.read(buf)) != -1) {
                size += read;
            }
            return size;
        }
    }

    /**
     * This implementation checks the timestamp of the underlying File,
     * if available.
     * @see #getFileForLastModifiedCheck()
     */
    @Override
    public long lastModified() throws IOException {
        File fileToCheck = getFileForLastModifiedCheck();
        long lastModified = fileToCheck.lastModified();
        if (lastModified == 0L && !fileToCheck.exists()) {
            throw new FileNotFoundException(getDescription() +
                    " cannot be resolved in the file system for checking its last-modified timestamp");
        }
        return lastModified;
    }

    protected  File getFileForLastModifiedCheck() throws IOException {
        return getFile();
    }

    /**
     * This implementation throws a FileNotFoundException, assuming
     * that relative resources cannot be created for this resource.
     */
    @Override
    public Resource createRelative(String relativePath) throws IOException {
        throw new FileNotFoundException("Cannot create a relative resource for " + getDescription());
    }

    /**
     * This implementation always returns {@code null},
     * assuming that this resource type does not have a filename.
     */
    @Override
    public String getFilename() {
        return null;
    }

    /**
     * This implementation compares description strings.
     * @see #getDescription()
     */
    @Override
    public boolean equals(Object other) {
        return (this == other || (other instanceof Resource &&
                ((Resource) other).getDescription().equals(getDescription())));
    }

    /**
     * This implementation returns the description's hash code.
     * @see #getDescription()
     */
    @Override
    public int hashCode() {
        return getDescription().hashCode();
    }

    /**
     * This implementation returns the description of this resource.
     * @see #getDescription()
     */
    @Override
    public String toString() {
        return getDescription();
    }
}
