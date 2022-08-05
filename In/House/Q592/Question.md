<h1>分数加减运算</h1>

给定一个表示分数加减运算的字符串expression，你需要返回一个字符串形式的计算结果。</br>
这个结果应该是不可约分的分数，即最简分数。如果最终结果是一个整数，例如2，你需要将它转换成分数形式，其分母为1。所以在上述例子中, 2应该被转换为2/1。</br>

示例1:</br>
输入: expression = "-1/2+1/2"</br>
输出: "0/1"</br>

示例2:</br>
输入: expression = "-1/2+1/2+1/3"</br>
输出: "1/3"</br>

示例3:</br>
输入: expression = "1/3-1/2"</br>
输出: "-1/6"</br>

提示:
- 输入和输出字符串只包含'0'到'9'的数字，以及'/', '+'和'-'。
- 输入和输出分数格式均为±分子/分母。如果输入的第一个分数或者输出的分数是正数，则'+'会被省略掉。
- 输入只包含合法的最简分数，每个分数的分子与分母的范围是[1, 10]。如果分母是1，意味着这个分数实际上是一个整数。
- 输入的分数个数范围是[1, 10]。
- 最终结果的分子与分母保证是32位整数范围内的有效整数。

[Link](https://leetcode.cn/problems/fraction-addition-and-subtraction/)