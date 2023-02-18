package com.lhj.shixun1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootTest
class Shixun1ApplicationTests {
    @Test
    public void test() throws FileNotFoundException {
        String path = ResourceUtils.getURL("classpath:").getPath()+"static/upload";
        String realPath = path.replace('/', '\\').substring(1,path.length());
        //用于查看路径是否正确
        System.out.println(realPath);
    }
}
