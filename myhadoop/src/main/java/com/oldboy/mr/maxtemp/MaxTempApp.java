package com.oldboy.mr.maxtemp;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MaxTempApp {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "file:///");

        FileSystem fs = FileSystem.get(conf);
        //通过配置文件初始化job
        Job job = Job.getInstance(conf);

        //设置job名称
        job.setJobName("maxtemp");

        //job入口函数类
        job.setJarByClass(MaxTempApp.class);

        //设置mapper类
        job.setMapperClass(MaxTempMapper.class);

        //设置reducer类
        job.setReducerClass(MaxTempReducer.class);

        //设置map的输出k-v类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        //设置reduce的输出k-v类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

        //FileInputFormat.setMaxInputSplitSize(job,10);
        //FileInputFormat.setMinInputSplitSize(job,10);

        Path pin = new Path("h:/practice/temp/");
        Path pout = new Path("h:/practice/temp/out");

        //设置输入路径
        FileInputFormat.addInputPath(job, pin);

        //设置输出路径
        FileOutputFormat.setOutputPath(job, pout);
        if(fs.exists(pout)){
            fs.delete(pout,true);
        }

        //执行job
        job.waitForCompletion(true);
    }
}


