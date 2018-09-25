package com.oldboy.hdfs.sequencefile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;


//测试文件块压缩
public class TestSeqFile {
    @Test
    public void testWriteSeq() throws Exception{
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","file:///");
        FileSystem fs = FileSystem.get(conf);

        Path p = new Path("h:/practice/seq/block.seq");

    }
}
