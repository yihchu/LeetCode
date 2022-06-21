<h1>Range模块</h1>

Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为半开区间的范围并查询它们。</br>
半开区间[left, right)表示所有left <= x < right的实数x。</br>
实现RangeModule类:
- RangeModule()初始化数据结构的对象。</br>
- void addRange(int left, int right)添加半开区间[left, right)，跟踪该区间中的每个实数。添加与当前跟踪的数字部分重叠的区间时，应当添加在区间[left, right)中尚未跟踪的任何数字到该区间中。</br>
- boolean queryRange(int left, int right)只有在当前正在跟踪区间[left, right)中的每一个实数时，才返回true，否则返回false。</br>
- void removeRange(int left, int right)停止跟踪半开区间[left, right)中当前正在跟踪的每个实数。</br>

示例1：</br>
输入</br>
["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", "queryRange"]</br>
[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]</br>
输出</br>
[null, null, null, true, false, true]</br>

解释</br>
RangeModule rangeModule = new RangeModule();</br>
rangeModule.addRange(10, 20);</br>
rangeModule.removeRange(14, 16);</br>
rangeModule.queryRange(10, 14); 返回true（区间[10, 14)中的每个数都正在被跟踪）</br>
rangeModule.queryRange(13, 15); 返回false（未跟踪区间[13, 15)中像14, 14.03, 14.17这样的数字）</br>
rangeModule.queryRange(16, 17); 返回true（尽管执行了删除操作，区间[16, 17)中的数字16仍然会被跟踪）</br>

提示：</br>
1 <= left < right <= 10^9</br>
在单个测试用例中，对addRange、queryRange和removeRange的调用总数不超过10^4次</br>

[Link](https://leetcode.cn/problems/range-module/)