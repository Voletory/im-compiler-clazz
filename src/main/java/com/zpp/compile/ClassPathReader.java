package com.zpp.compile;

import com.sun.tools.javac.util.Assert;
import com.zpp.compile.core.ClassStruct;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.ReadableByteChannel;

/**
 * @author steven.zhu 2020/4/1 12:39.
 * @类描述：
 */
public class ClassPathReader {

    private Resource resource;

    private ClassStruct classStruct;

    private ByteBuffer byteBuffer;

    private ReadableByteChannel readableByteChannel;

    public ClassPathReader(Resource resource) {
        this.resource = resource;
    }

    public ClassPathReader(String path) {
        this(new ClassPathResource(path));
    }

    public void imCompile() throws IOException {
        if (this.classStruct == null) {
            this.classStruct = new ClassStruct();
        }
        ClassStruct clazzStruct = classStruct;
        doCompile();
    }

    protected void doCompile() throws IOException {
        ClassDecodeResolves classDecodeResolves = createClazzDecodeResolves();
        while (classDecodeResolves.hasNextResolve()) {
            DecodeResolve resolve = classDecodeResolves.getResolve();
            resolve.decodeClazz(this,classStruct);
        }
    }


    protected ClassDecodeResolves createClazzDecodeResolves() {
        return new ClassDecodeResolves();
    }

    /**
     * @param i allocDate length 位为单位
     * @return
     */
    public byte[] allocByteResource(int i)  {
        try {
            ReadableByteChannel readChannel = loadChannel();
            byte[] result = new byte[i];
            for (int x = 0; x < i; x++) {
                if (byteBuffer == null || !byteBuffer.hasRemaining()) {
                    if (byteBuffer == null) {
                        byteBuffer = ByteBuffer.allocate(1024);
                    }
                    byteBuffer.clear();
                    int read = readChannel.read(byteBuffer);
                    Assert.check(read != -1, "stream end");
                    byteBuffer.flip();
                }
                result[x] = byteBuffer.get();
            }
            return result;
        }catch (IOException io) {
            return null;
        }
    }

    private ReadableByteChannel loadChannel() {
        if (readableByteChannel == null)
            return createReadChannel();
        return readableByteChannel;
    }

    private ReadableByteChannel createReadChannel() {
        try {
            if (readableByteChannel == null) {
                readableByteChannel = resource.readableChannel();
            }
        } catch (IOException e) {
        }
        return readableByteChannel;
    }
}
