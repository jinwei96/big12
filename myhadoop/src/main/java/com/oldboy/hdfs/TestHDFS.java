package com.oldboy.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestHDFS {

    @Test
    public void testRead() throws IOException {
        //初始化配置文件
        Configuration conf = new Configuration();
        //初始化文件系统
        FileSystem fs = FileSystem.get(conf);

        //初始化路径
        Path p = new Path("/for99.sh");

        //通过文件系统获取输入流
        //FSDataInputStream是inputStream的装饰流，可以通过普通流方式操纵fis
        FSDataInputStream fis = fs.open(p);

        int len = 0;
        byte[] buf = new byte[1024];

        while( (len = fis.read(buf)) != -1){
            System.out.print(new String(buf,0,len));
        }
        fis.close();

    }

    @Test
    public void testRead2() throws IOException {

        //初始化配置文件
        Configuration conf = new Configuration();
        //初始化文件系统
        FileSystem fs = FileSystem.get(conf);

        //初始化路径
        Path p = new Path("/for99.sh");

        //通过文件系统获得输入流
        //FSDataInputStream是inputstream的装饰流，可以通过普通流方式操纵fis
        FSDataInputStream fis = fs.open(p);

        //创建输出流
        FileOutputStream fos = new FileOutputStream("f:/2.txt");

        //通过IOUtiles拷贝文件
        IOUtils.copyBytes(fis,fos,1024);

        //释放资源
        fis.close();
        fos.close();
        System.out.println("拷贝成功");
    }
    
    @Test
    public void testWrite() throws IOException {
        System.setProperty("HADOOP_USER_NAME","centos");
        //初始化配置文件
        Configuration conf = new Configuration();
        
        //初始化文件系统
        FileSystem fs = FileSystem.get(conf);
        
        //初始化路径
        Path p = new Path("/2.txt");
        
        //通过文件系统获得输出流
        FSDataOutputStream fos = fs.create(p);

        FileInputStream fis = new FileInputStream("f:/2.txt");
        
        //通过IOUtiles拷贝文件
        IOUtils.copyBytes(fis,fos,1024);
        
        //释放资源
        fis.close();
        fos.close();
        System.out.println("上传成功");
    }

    //通过递归列出指定文件夹下的文件或文件夹信息

    @Test
    public void testList() throws IOException {

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);

        FileStatus[] statuses = fs.listStatus(new Path("/"));

        recu(statuses);
    }
    public void recu(FileStatus[] statuses) throws IOException {
        for(FileStatus status : statuses){
            if (status.isDirectory()){
                Configuration conf = new Configuration();
                FileSystem fs = FileSystem.get(conf);
                FileStatus[] ss = fs.listStatus(status.getPath());
                System.out.println(status.getPath().getName());
                recu(ss);
            }else {
                System.out.println(status.getPath().getName());
            }
        }
    }
}
