<h1>原子的数量</h1>

给定一个化学式formula（作为字符串），返回每种原子的数量。</br>
原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。</br>
如果数量大于1，原子后会跟着数字表示原子的数量。如果数量等于1则不会跟数字。例如，H2O和H2O2是可行的，但H1O2这个表达是不可行的。</br>
两个化学式连在一起是新的化学式。例如H2O2He3Mg4也是化学式。</br>
一个括号中的化学式和数字（可选择性添加）也是化学式。例如(H2O2)和(H2O2)3是化学式。</br>
给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于1），以此类推。</br>

示例1:</br>
输入:</br>
formula = "H2O"</br>
输出: "H2O"</br>
解释:</br>
原子的数量是 {'H': 2, 'O': 1}。</br>

示例2:</br>
输入:</br>
formula = "Mg(OH)2"</br>
输出: "H2MgO2"</br>
解释:</br>
原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。</br>

示例3:</br>
输入:</br>
formula = "K4(ON(SO3)2)2"</br>
输出: "K4N2O14S4"</br>
解释:</br>
原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。</br>

注意:
- 所有原子的第一个字母为大写，剩余字母都是小写。
- formula的长度在[1, 1000]之间。
- formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。

[Link](https://leetcode-cn.com/problems/number-of-atoms/)