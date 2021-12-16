# base2008搜狗查询日志的数据分析



## 1. 描述

使用 Hadoop 的 MapReduce / Hive 对搜狗日志数据进行分析并输出分析结果



## 2. 数据详情

### 2.1 数据来源

http://www.sogou.com/labs/resource/q.php

### 2.2 介绍

​        搜索引擎查询日志库设计为包括约1个月(2008年6月)Sogou搜索引擎部分网页查询需求及用户点击情况的网页查询日志数据集合。为进行中文搜索引擎用户行为分析的研究者提供基准研究语料。

### 2.3 格式说明

数据格式为

**用户ID\t[查询词]\t该URL在返回结果中的排名\t用户点击的顺序号\t用户点击的URL**

其中，用户ID是根据用户使用浏览器访问搜索引擎时的Cookie信息自动赋值，即同一次使用浏览器输入的不同查询对应同一个用户ID



## 3. 需求清单（PRD）

1. 使用MapReduce完成搜索词的词频统计
2. ①使用MapReduce统计每个词被多少个不同的用户搜索②这个词用户所点击的URL中.com和.cn的比例③使用分区功能，将搜索词长度大于等于4的和小于4的结果分开存储
3. 使用MapReduce统计搜索关键词 [A] 的所有用户集setA，再找出该用户集的所有搜索词setB，再统计setB词频，打印排名 前2名 的词。
4. 使用MapReduce对需求2的结果进行排序，不同用户的个数高的排在前面。
5. 将用户搜索词进行分词后，再次词频统计，统计排名靠前的 100个 搜索词。
6. 使用 hive 完成题目1的内容。（只截取300行数据进行统计，避免OOM）



## 4. 实现效果

### 4.1 Q1

![Q1](https://github.com/dddddkio/Data-analysis-of-Sogou-query-log/blob/main/img/Q1.png?raw=true)

### 4.2 Q2

![Q2](https://github.com/dddddkio/Data-analysis-of-Sogou-query-log/blob/main/img/Q2.png?raw=true)

### 4.3 Q3

![Q3](https://github.com/dddddkio/Data-analysis-of-Sogou-query-log/blob/main/img/Q3.png?raw=true)



## 5. 注意事项

### 5.1 主类修改位置

![pom](https://github.com/dddddkio/Data-analysis-of-Sogou-query-log/blob/main/img/pom.png?raw=true)

