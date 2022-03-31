<h1>学生出勤记录I</h1>

给你一个字符串s表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：</br>
'A'：Absent，缺勤</br>
'L'：Late，迟到</br>
'P'：Present，到场</br>
如果学生能够同时满足下面两个条件，则可以获得出勤奖励：</br>
按总出勤计，学生缺勤（'A'）严格少于两天。</br>
学生不会存在连续3天或3天以上的迟到（'L'）记录。</br>
如果学生可以获得出勤奖励，返回true；否则，返回false。</br>

示例1：</br>
输入：s = "PPALLP"</br>
输出：true</br>
解释：学生缺勤次数少于2次，且不存在3天或以上的连续迟到记录。</br>

示例2：</br>
输入：s = "PPALLL"</br>
输出：false</br>
解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。</br>

提示：</br>
1 <= s.length <= 1000</br>
s[i]为'A'、'L'或'P'</br>

[Link](https://leetcode-cn.com/problems/student-attendance-record-i/)