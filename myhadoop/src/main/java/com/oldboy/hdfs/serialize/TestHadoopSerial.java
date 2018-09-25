package com.oldboy.hdfs.serialize;

import org.apache.hadoop.io.IntWritable;
import org.junit.Test;

import java.io.*;

public class TestHadoopSerial {

    /**
     * 测hadoop序列化
     * @throws Exception
     */
    @Test
    public void testSerial() throws Exception{

        IntWritable iw = new IntWritable(100);

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("h:/practice/serial/serial.h"));

        iw.write(dos);

        dos.close();

    }
    @Test
    public void testDeserial() throws Exception {

        DataInputStream dis = new DataInputStream(new FileInputStream("h:/practice/serial/serial.h"));
        IntWritable iw = new IntWritable();
        iw.readFields(dis);

        int i = iw.get();
        dis.close();
        System.out.println(i);
    }
}
