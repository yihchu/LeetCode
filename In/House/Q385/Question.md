<h1>迷你语法分析器</h1>

给定一个字符串s表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果NestedInteger。</br>
列表中的每个元素只可能是整数或整数嵌套列表</br>

示例1：</br>
输入：s = "324",</br>
输出：324</br>
解释：你应该返回一个NestedInteger对象，其中只包含整数值324。</br>

示例2：</br>
输入：s = "[123,[456,[789]]]",</br>
输出：[123, [456, [789]]]</br>
解释：返回一个NestedInteger对象包含一个有两个元素的嵌套列表：</br>
1. 一个integer包含值123</br>
2. 一个包含两个元素的嵌套列表： </br>
   i.  一个integer包含值 456</br>
   ii. 一个包含一个元素的嵌套列表</br>
   &nbsp;&nbsp;a. 一个integer包含值789

提示：
- 1 <= s.length <= 5 * 10^4
- s由数字、方括号"[]"、负号'-'、逗号','组成
- 用例保证s是可解析的NestedInteger
- 输入中的所有值的范围是 [-10^6, 10^6]

[Link](https://leetcode-cn.com/problems/mini-parser/)