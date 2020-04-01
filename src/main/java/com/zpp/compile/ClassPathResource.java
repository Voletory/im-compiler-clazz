package com.zpp.compile;

import com.zpp.compile.common.Assert;
import com.zpp.compile.common.ClassUtils;
import com.zpp.compile.common.ObjectUtils;
import com.zpp.compile.common.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author steven.zhu 2020/3/31 12:57.
 * @类描述：
 */
public class ClassPathResource extends AbstractResource {

    private Class<?> clazz;

    private ClassLoader classLoader;

    private String path;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, Class<?> clazz) {
        Assert.notNull(path, "Path must not be null");
        this.path = StringUtils.cleanPath(path);
        this.clazz = clazz;
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        String pathToUse = StringUtils.cleanPath(path);
        if (pathToUse.startsWith("/")) {
            pathToUse = pathToUse.substring(1);
        }
        this.path = pathToUse;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }


    @Override
    public String getDescription() {
        StringBuilder builder = new StringBuilder("class path resource [");
        String pathToUse = path;
        if (this.clazz != null && !pathToUse.startsWith("/")) {
            builder.append(ClassUtils.classPackageAsResourcePath(this.clazz));
            builder.append('/');
        }
        if (pathToUse.startsWith("/")) {
            pathToUse = pathToUse.substring(1);
        }
        builder.append(pathToUse);
        builder.append(']');
        return builder.toString();
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        InputStream is = null;
        if (this.clazz != null) {
            is = this.clazz.getResourceAsStream(path);
        } else if (classLoader != null) {
            is = this.classLoader.getResourceAsStream(path);
        } else {
            is = ClassLoader.getSystemResourceAsStream(path);
        }
        if (is == null) {
            throw new FileNotFoundException(this.getDescription() + " cannot be opened because it does not exist");
        } else {
            return is;
        }
    }

    @Override
    public URL getURL() throws IOException {
        URL url = resolveURL();
        if (url == null) {
            throw new FileNotFoundException(getDescription() + " cannot be resolved to URL because it does not exist");
        }
        return url;
    }

    protected URL resolveURL() {
        if (this.clazz != null) {
            return this.clazz.getResource(path);
        } else if (this.classLoader != null) {
            return this.classLoader.getResource(path);
        } else {
            return ClassLoader.getSystemResource(path);
        }
    }

    @Override
    public boolean exists() {
        return resolveURL() != null;
    }

    /**
     * This implementation compares the underlying class path locations.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClassPathResource)) {
            return false;
        }
        ClassPathResource otherRes = (ClassPathResource) other;
        return (this.path.equals(otherRes.path) &&
                ObjectUtils.nullSafeEquals(this.classLoader, otherRes.classLoader) &&
                ObjectUtils.nullSafeEquals(this.clazz, otherRes.clazz));
    }

    /**
     * This implementation returns the hash code of the underlying
     * class path location.
     */
    @Override
    public int hashCode() {
        return this.path.hashCode();
    }
}
