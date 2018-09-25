package com.oldboy.hdfs.sequencefile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Log2seq {
    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();

        conf.set("fs.defaultFS","file:///");

        FileSystem fs = FileSystem.get(conf);

        Path p = new Path("h:/practice/seq/access.seqN");

        SequenceFile.Writer writer = SequenceFile.createWriter(fs, conf, p, NullWritable.class, Text.class,SequenceFile.CompressionType.NONE);

        BufferedReader br = new BufferedReader(new FileReader("h:/practice/seq/access.log1"));

        String line = null;
        while((line = br.readLine()) != null){
            NullWritable key = NullWritable.get();
            Text val = new Text(line);
            writer.append(key,val);
        }
        br.close();
        writer.close();
    }

    @Test
    public void testReadSeq() throws Exception {
        Configuration conf = new Configuration();

        conf.set("fs.defaultFS","file:///");

        FileSystem fs = FileSystem.get(conf);

        Path p = new Path("h:/practice/seq/access.seq");

        SequenceFile.Reader reader = new SequenceFile.Reader(fs,p,conf);

        //初始化两个writable对象
        NullWritable key = NullWritable.get();
        Text value = new Text();

        while(reader.next(key, value)){
            System.out.println("key:" + key.get() + "," + "val:" + value.toString());
        }

    }
}
