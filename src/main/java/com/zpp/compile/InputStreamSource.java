package com.zpp.compile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author steven.zhu 2020/3/31 12:45.
 * @类描述： getInputStream
 */
public interface InputStreamSource {

    /**
     * to get inputStream
     * @return
     */
    InputStream getInputStream() throws IOException;
}
