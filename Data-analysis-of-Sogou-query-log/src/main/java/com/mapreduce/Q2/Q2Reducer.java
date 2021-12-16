package com.mapreduce.Q2;

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

public class Q2Reducer extends Reducer<Text,sortBean,Text,Text>{
	
	// reduce 方法作用： 将新的 k2和v2 转为 k3和v3，将 k3和v3 写入上下文中


	protected void reduce(Text k3, Iterable<sortBean> v3, Context context) throws IOException, InterruptedException {

		ArrayList<String> userList = new ArrayList<String>();
		
		int comCount = 0;
		int cnCount = 0;
		
		Text text = new Text();
		
		
		// 遍历集合，将集合中的数字相加，得到v3
		for(sortBean v:v3) {
			if(userList == null || !userList.contains(v.user)) {
				userList.add(v.user);
			}
			if(v.url.substring(v.url.length()-3).equals("com")) {
				comCount++;
			}
			if(v.url.substring(v.url.length()-3).equals(".cn")) {
				cnCount++;
			}
		}
		
		
		// 将 k3和v3 写入上下文中
		String num = String.valueOf(userList.size());
	
		String out = num+" "+String.valueOf(comCount)+" "+String.valueOf(cnCount);
		
		text.set(out);
		
		context.write(k3, text);
		
		
	}
}
