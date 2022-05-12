<h1>删列造序</h1>

给你由n个小写字母字符串组成的数组strs，其中每个字符串长度相等。</br>
这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"]可以排列为：</br>
abc</br>
bce</br>
cae</br>
你需要找出并删除不是按字典序升序排列的列。在上面的例子（下标从0开始）中，列0（'a', 'b', 'c'）和列2（'c', 'e', 'e'）都是按升序排列的，而列1（'b', 'c', 'a'）不是，所以要删除列1。</br>
返回你需要删除的列数。</br>

示例1：</br>
输入：strs = ["cba", "daf", "ghi"]</br>
输出：1</br>
解释：网格示意如下：</br>
cba</br>
daf</br>
ghi</br>
列0和列2按升序排列，但列1不是，所以只需要删除列1。</br>

示例2：</br>
输入：strs = ["a", "b"]</br>
输出：0</br>
解释：网格示意如下：</br>
a</br>
b</br>
只有列0这一列，且已经按升序排列，所以不用删除任何列。</br>

示例3：</br>
输入：strs = ["zyx", "wvu", "tsr"]</br>
输出：3</br>
解释：网格示意如下：</br>
zyx</br>
wvu</br>
tsr</br>
所有3列都是非升序排列的，所以都要删除。</br>


提示：
n == strs.length</br>
1 <= n <= 100</br>
1 <= strs[i].length <= 1000</br>
strs[i] 由小写英文字母组成</br>

[Link](https://leetcode.cn/problems/delete-columns-to-make-sorted/)