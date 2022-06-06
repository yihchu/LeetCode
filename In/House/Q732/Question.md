<h1>我的日程安排表III</h1>

当k个日程安排有一些时间上的交叉时（例如k个日程安排都在同一时间内），就会产生k次预订。</br>
给你一些日程安排[start, end)，请你在每个日程安排添加后，返回一个整数k，表示所有先前日程安排会产生的最大k次预订。</br>
实现一个MyCalendarThree类来存放你的日程安排，你可以一直添加新的日程安排。</br>
- MyCalendarThree()初始化对象。
- int book(int start, int end)返回一个整数k，表示日历中存在的k次预订的最大值。

示例：</br>
输入：</br>
["MyCalendarThree", "book", "book", "book", "book", "book", "book"]</br>
[[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]</br>
输出：</br>
[null, 1, 1, 2, 3, 3, 3]</br>

解释：
MyCalendarThree myCalendarThree = new MyCalendarThree();</br>
myCalendarThree.book(10, 20); // 返回1，第一个日程安排可以预订并且不存在相交，所以最大k次预订是1次预订。</br>
myCalendarThree.book(50, 60); // 返回1，第二个日程安排可以预订并且不存在相交，所以最大次预订是1次预订。</br>
myCalendarThree.book(10, 40); // 返回2，第三个日程安排[10, 40) 与第一个日程安排相交，所以最大k次预订是2次预订。</br>
myCalendarThree.book(5, 15); // 返回3，剩下的日程安排的最大k次预订是3次预订。</br>
myCalendarThree.book(5, 10); // 返回3</br>
myCalendarThree.book(25, 55); // 返回3</br>

提示：</br>
0 <= start < end <= 10^9</br>
每个测试用例，调用book函数最多不超过400次</br>

[Link](https://leetcode.cn/problems/my-calendar-iii/)