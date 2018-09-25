package com.oldboy.java.jvm;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestJVM {
    public static void main(String[] args) {
        int n = 1024 * 1024 * 6;
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            byte[] bytes = new byte[n];
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void copyFile() throws Exception{
        File f = new File("h:/practice/1.exe");
        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = new FileOutputStream("h:/2.exe");
        byte[] buf = new byte[1024];
        int len = 0;
        long start = System.currentTimeMillis();
        while ((len = fis.read(buf)) != -1){
            fos.write(buf,0,len);
        }
        System.out.println(System.currentTimeMillis() - start);
        fis.close();
        fos.close();

    }

    @Test
    public void copyFile2() throws Exception{
        File f = new File("h:/practice/1.exe");
        FileInputStream fis = new FileInputStream(f);
        FileChannel src = fis.getChannel();
        FileOutputStream fos = new FileOutputStream(f);
        FileChannel dest = fos.getChannel();
        


    }
}
