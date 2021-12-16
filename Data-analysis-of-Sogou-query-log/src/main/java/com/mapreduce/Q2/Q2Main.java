package com.mapreduce.Q2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Q2Main {

	public static void main(String[] args) throws Exception{
		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(Q2Main.class);
		
		job.setPartitionerClass(Q2Partitioner.class);
		job.setNumReduceTasks(2);
		
		job.setMapperClass(Q2Mapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(sortBean.class);
		
		job.setReducerClass(Q2Reducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(sortBean.class);

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);
	}
}

