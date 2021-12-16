package com.mapreduce.Q3_Step1;

import java.io.IOException;
import java.util.ArrayList;
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

public class Q3_Step1Reducer extends Reducer<Text,Text,Text,Text>{
	
	// reduce 方法作用： 将新的 k2和v2 转为 k3和v3，将 k3和v3 写入上下文中


	protected void reduce(Text k3, Iterable<Text> v3, Context context) throws IOException, InterruptedException {

		Text text = new Text();
		
		StringBuffer buffer = new StringBuffer();
		
		// 遍历集合，将搜索词集转成字符
		for(Text v:v3) {
			if(buffer.indexOf(v.toString()+" ")==-1){
				buffer.append(v.toString()).append(" ");
			}
		}
		
		text.set(buffer.toString().trim());
		
		context.write(text, k3);
	}
}
