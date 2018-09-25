package com.oldboy.hdfs.codec;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.*;
import org.apache.hadoop.util.ReflectionUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Testcodec {
    /**
     * 测试Gzip压缩
     */
    @Test
    public void testCompress() throws Exception{
        Configuration conf = new Configuration();

        //通过反射获取CompressionCodec对象
        CompressionCodec codec = (CompressionCodec)ReflectionUtils.newInstance(GzipCodec.class, conf);

        //通过codec获取输出流，将文件进行压缩
        CompressionOutputStream cos = codec.createOutputStream(new FileOutputStream("h:/practice/compress/aoshi.txt.gz"));

        //获取输入流
        FileInputStream fis = new FileInputStream("f:/aoshi.txt");

        IOUtils.copyBytes(fis,cos,1024);

        fis.close();
        cos.close();

    }


    /**
     * 测试解压缩
     */
    @Test
    public void testDecompress() throws Exception{
        Configuration conf = new Configuration();

        //通过反射获取CompressionCodec对象
        CompressionCodec codec = (CompressionCodec)ReflectionUtils.newInstance(GzipCodec.class, conf);

        //通过codec获取输入流
        CompressionInputStream cis = codec.createInputStream(new FileInputStream("h:/practice/compress/aoshi.txt.gz"));

        //获取输出流
        FileOutputStream fos = new FileOutputStream("h:/practice/compress/aoshi.txt");

        IOUtils.copyBytes(cis,fos,1024);

        IOUtils.closeStream(fos);
    }

    /**
     * 测试Deflate压缩
     */
    @Test
    public void testCompress2() throws Exception{
        Configuration conf = new Configuration();

        //通过反射获取CompressionCodec对象
        CompressionCodec codec = (CompressionCodec) ReflectionUtils.newInstance(DeflateCodec.class, conf);

        //通过codec获取输出流，将文件进行压缩
        CompressionOutputStream cos = codec.createOutputStream(new FileOutputStream("h:/practice/compress/aoshi.txt.de"));

        //获取输入流
        FileInputStream fis = new FileInputStream("f:/aoshi.txt");

        IOUtils.copyBytes(fis,cos,1024);

        fis.close();
        cos.close();

    }

    /**
     * 测试BZip2压缩
     */
    @Test
    public void testCompress3() throws Exception{
        Configuration conf = new Configuration();

        //通过反射获取CompressionCodec对象
        CompressionCodec codec = (CompressionCodec)ReflectionUtils.newInstance(BZip2Codec.class, conf);

        //通过codec获取输出流，将文件进行压缩
        CompressionOutputStream cos = codec.createOutputStream(new FileOutputStream("h:/practice/compress/aoshi.txt.bz2"));

        //获取输入流
        FileInputStream fis = new FileInputStream("f:/aoshi.txt");

        IOUtils.copyBytes(fis,cos,1024);

        fis.close();
        cos.close();

    }

    /**
     * 测试Lz4压缩
     */
    @Test
    public void testCompress4() throws Exception{
        Configuration conf = new Configuration();

        //通过反射获取CompressionCodec对象
        CompressionCodec codec = (CompressionCodec)ReflectionUtils.newInstance(Lz4Codec.class, conf);

        //通过codec获取输出流，将文件进行压缩
        CompressionOutputStream cos = codec.createOutputStream(new FileOutputStream("h:/practice/compress/aoshi.txt.lz4"));

        //获取输入流
        FileInputStream fis = new FileInputStream("f:/aoshi.txt");

        IOUtils.copyBytes(fis,cos,1024);

        fis.close();
        cos.close();

    }

    /**
     * 测试Snappy压缩
     */
    @Test
    public void testCompress5() throws Exception{
        Configuration conf = new Configuration();

        //通过反射获取CompressionCodec对象
        CompressionCodec codec = (CompressionCodec)ReflectionUtils.newInstance(SnappyCodec.class, conf);

        //通过codec获取输出流，将文件进行压缩
        CompressionOutputStream cos = codec.createOutputStream(new FileOutputStream("h:/practice/compress/aoshi.txt.sna"));

        //获取输入流
        FileInputStream fis = new FileInputStream("f:/aoshi.txt");

        IOUtils.copyBytes(fis,cos,1024);

        fis.close();
        cos.close();

    }

}
