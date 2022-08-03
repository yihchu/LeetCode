<h1>数据流的中位数</h1>

中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。</br>
例如，</br>
[2, 3, 4]的中位数是3</br>
[2, 3]的中位数是(2 + 3) / 2 = 2.5</br>

设计一个支持以下两种操作的数据结构：</br>
void addNum(int num) - 从数据流中添加一个整数到数据结构中。</br>
double findMedian() - 返回目前所有元素的中位数。</br>
示例：</br>
addNum(1)</br>
addNum(2)</br>
findMedian() -> 1.5</br>
addNum(3)</br>
findMedian() -> 2</br>

进阶:
- 如果数据流中所有整数都在0到100范围内，你将如何优化你的算法？
- 如果数据流中99%的整数都在0到100范围内，你将如何优化你的算法？

[Link](https://leetcode-cn.com/problems/find-median-from-data-stream/)