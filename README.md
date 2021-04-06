## 视图
### ClassPaper
查询一个老师，在一个班级里创建的试卷的id。
示例：
~~~sql
SELECT paper_id 
FROM ClassPaper 
WHERE teacher_id = 2 AND class_id = 1;
~~~
数据字典：
|列名|类型|含义|
|:----:|:----:|:----: |
|class_id|int|班级id|
|teacher_id|int|老师id|
|paper_id|int|试卷id|
### StuClass
查询一个学生的所有班级的详细信息。
示例：
~~~sql
SELECT * 
FROM StuClass 
WHERE stu_id = 3;
~~~
数据字典：
|列名|类型|含义|
|:----:|:----:|:----: |
|stu_id|int|学生id|
|class_id|int|班级id|
|class_name|varchar|班级名称|
|num_students|int|班级人数|
|teacher_name|varchar|班主任真名|
### StuPaper
查询一个学生，在一张试卷上的答题情况。
示例：
~~~sql
SELECT * 
FROM StuPaper 
WHERE stu_id = 3 AND paper_id = 1;
~~~
数据字典：
|列名|类型|含义|
|:----:|:----:|:----: |
|stu_id|int|学生id|
|paper_id|int|试卷id|
|q_id|int|题目id|
|q_desc|varchar|题目描述|
|std_ans|varchar|标准答案|
|stu_ans|varchar|学生的答案|
|q_score|int|题目分值|
|stu_score|double|学生该题得分|
### TeacherClass
查询一个老师的所有班级
示例：
~~~sql
SELECT * 
FROM TeacherClass 
WHERE teacher_id = 2;
~~~
数据字典：
|列名|类型|含义|
|:----:|:----:|:----: |
|teacher_id|int|老师id|
|class_id|int|班级id|
|class_name|varchar|班级名称|
|num_students|int|班级人数|
