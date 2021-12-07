package com.mapreduce.javahdfs;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text,IntWritable,Text,IntWritable>{

	protected void reduce(Text k3, Iterable<IntWritable> v3, Context context) throws IOException, InterruptedException {

		int total = 0;
		for(IntWritable v:v3) {
			total += v.get();
		}
	
		context.write(k3, new IntWritable(total));
		
		
	}
}
