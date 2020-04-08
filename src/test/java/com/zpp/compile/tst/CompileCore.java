package com.zpp.compile.tst;

import com.zpp.compile.ClassPathFactory;
import com.zpp.compile.ClassPathReader;
import com.zpp.compile.ClassPathResource;

import java.io.IOException;


/**
 * @author steven.zhu 2020/3/25 13:28.
 * @类描述：
 */
public class CompileCore {

    static int magic = 0xcafebabe;  //202
    // 000000 00000000 11001010
    public static void main(String[] args) throws IOException {
      ClassPathFactory s = new ClassPathFactory(new ClassPathReader("AbstractResource.class"));
    }

}
