<h1>比较版本号</h1>

给你两个版本号version1和version2，请你比较它们。</br>
版本号由一个或多个修订号组成，各修订号由一个'.'连接。每个修订号由多位数字组成，可能包含前导零。每个版本号至少包含一个字符。修订号从左到右编号，下标从0开始，最左边的修订号下标为0，下一个修订号下标为1，以此类推。例如，2.5.33和0.1都是有效的版本号。</br>
比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较忽略任何前导零后的整数值。也就是说，修订号1和修订号001相等。如果版本号没有指定某个下标处的修订号，则该修订号视为0。例如，版本1.0小于版本1.1，因为它们下标为0的修订号相同，而下标为1的修订号分别为0和1，0 < 1。</br>

返回规则如下：</br>
如果version1 > version2返回1，</br>
如果version1 < version2返回-1，</br>
除此之外返回0。</br>

示例1：</br>
输入：version1 = "1.01", version2 = "1.001"</br>
输出：0</br>
解释：忽略前导零，"01"和"001"都表示相同的整数"1"</br>

示例2：</br>
输入：version1 = "1.0", version2 = "1.0.0"</br>
输出：0</br>
解释：version1没有指定下标为2的修订号，即视为"0"</br>

示例3：</br>
输入：version1 = "0.1", version2 = "1.1"</br>
输出：-1</br>
解释：version1中下标为0的修订号是"0"，version2中下标为0的修订号是"1"。0 < 1，所以version1 < version2</br>

示例4：</br>
输入：version1 = "1.0.1", version2 = "1"</br>
输出：1</br>

示例5：</br>
输入：version1 = "7.5.2.4", version2 = "7.5.3"</br>
输出：-1</br>

提示：
- 1 <= version1.length, version2.length <= 500
- version1和version2仅包含数字和'.'
- version1和version2都是有效版本号
- version1和version2的所有修订号都可以存储在32位整数中

[Link](https://leetcode-cn.com/problems/compare-version-numbers/)