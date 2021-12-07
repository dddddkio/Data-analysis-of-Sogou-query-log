package com.mapreduce.javahdfs;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	/*
	 * 四个泛型解释
	 * KEYIN: k1的类型
	 * VALUEIN: v1的类型
	 * 
	 * KEYOUT: k2的类型
	 * VALUEOUT: v2的类型
	 */
	
	@Override
	
	// map 方法就是将 k1和v1 转为 k2和v2
	
	// key     :  k1    行偏移量
	// value   :  v1    每一行的文本数据
	// context :  表示上下文对象
 	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		
		Text text = new Text();
		IntWritable intwritable = new IntWritable();
		
		// 将一行的文本数据拆分
		String data = value.toString();
		
		String[] words = data.split("\t");
		
		String name = words[1];
		
		// 避免多次new一个对象
		text.set(name);
		intwritable.set(1);
		
		// 将k2和v2写入上下文
		
		context.write(text, intwritable);
		
	}
}

