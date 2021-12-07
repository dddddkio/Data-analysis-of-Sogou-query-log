package com.mapreduce.javahdfs;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class partitioner extends Partitioner<Text,DoubleWritable>{

	@Override
	public int getPartition(Text k2, DoubleWritable v2, int num) {
		String cls = k2.toString();
		if(cls.equals("201901")) {
			return 0;
		}else {
			return 1;
		}
	}
	
}
