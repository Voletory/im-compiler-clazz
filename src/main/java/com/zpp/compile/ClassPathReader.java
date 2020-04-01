package com.zpp.compile;

/**
 * @author steven.zhu 2020/4/1 12:39.
 * @类描述：
 */
public class ClassPathReader {

    private Resource resource;

    public ClassPathReader(Resource resource) {
        this.resource = resource;
    }

    public ClassPathReader(String path) {
        this(new ClassPathResource(path));
    }

    public void imCompile() {

    }
}
