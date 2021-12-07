package com.mapreduce.javahdfs;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

	/*
	 * 四个泛型解释
	 * KEYIN: k2的类型
	 * VALUEIN: v2的类型
	 * 
	 * KEYOUT: k3的类型
	 * VALUEOUT: v3的类型
	 */

public class MyReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
	
	// reduce 方法作用： 将新的 k2和v2 转为 k3和v3，将 k3和v3 写入上下文中


	protected void reduce(Text k3, Iterable<IntWritable> v3, Context context) throws IOException, InterruptedException {

		int total = 0;
		IntWritable intwritable = new IntWritable();
		
		// 遍历集合，将集合中的数字相加，得到v3
		for(IntWritable v:v3) {
			total += v.get();
		}
		
		intwritable.set(total);
		
		// 将 k3和v3 写入上下文中
	
		context.write(k3, intwritable);
		
		
	}
}
