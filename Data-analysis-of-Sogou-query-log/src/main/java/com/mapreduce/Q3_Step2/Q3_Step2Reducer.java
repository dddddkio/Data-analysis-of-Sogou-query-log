package com.mapreduce.Q3_Step2;

import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

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

public class Q3_Step2Reducer extends Reducer<Text,Text,Text,Text>{
	
    public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();
        Map.Entry<String, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }
	// reduce 方法作用： 将新的 k2和v2 转为 k3和v3，将 k3和v3 写入上下文中

	protected void reduce(Text k3, Iterable<Text> v3, Context context) throws IOException, InterruptedException {

		Text text = new Text();
		
//		StringBuffer buffer = new StringBuffer();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		// 遍历集合
		for(Text v:v3) {
			String[] words = v.toString().split(" ");
			
			// 计算数组中出现最多的搜索词
		    for (String str : words) {
		        Integer num = map.get(str);
		        map.put(str, num == null ? 1 : num + 1);
		     }
			
		}
		Map <String, Integer> sortedMap = sortMapByValue(map);
		
		StringBuffer buffer = new StringBuffer();
		Integer count=0;
		for(String key:sortedMap.keySet()) {
			if(count<2) {
				buffer.append(key+"="+sortedMap.get(key)+" ");
				count++;
			}
			else {
				break;
			}
			
		}
		text.set(buffer.toString());
		
		context.write(k3, text);
	}
}
