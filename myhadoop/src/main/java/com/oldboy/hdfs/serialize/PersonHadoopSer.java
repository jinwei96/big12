package com.oldboy.hdfs.serialize;

import org.junit.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class PersonHadoopSer {

    //测试person 用 Hadoop序列化
    @Test
    public void personSer() throws Exception{
        Person p = new Person("tom", 20);
        PersonWritable pw = new PersonWritable();

        //在pw中将person对象传入
        pw.setPerson(p);

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("h:/practice/serial/person.h"));

        pw.write(dos);
        dos.close();
    }


    //反序列化
    @Test
    public void personDes() throws Exception{

        DataInputStream dis = new DataInputStream(new FileInputStream("h:/practice/serial/person.h"));

        PersonWritable pw = new PersonWritable();

        pw.readFields(dis);

        String name = pw.getPerson().getName();
        int age = pw.getPerson().getAge();

        System.out.println(name+"--"+age);

        dis.close();





    }
}
