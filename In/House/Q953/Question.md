<h1>验证外星语词典</h1>

某种外星语也使用英文小写字母，但可能顺序order不同。字母表的顺序（order）是一些小写字母的排列。</br>
给定一组用外星语书写的单词words，以及其字母表的顺序order，只有当给定的单词在这种外星语中按字典序排列时，返回true；否则，返回false。</br>

示例1：</br>
输入：words = ["hello", "leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"</br>
输出：true</br>
解释：在该语言的字母表中，'h'位于'l'之前，所以单词序列是按字典序排列的。</br>

示例2：</br>
输入：words = ["word", "world", "row"], order = "worldabcefghijkmnpqstuvxyz"</br>
输出：false</br>
解释：在该语言的字母表中，'d'位于'l'之后，那么words[0] > words[1]，因此单词序列不是按字典序排列的。</br>

示例3：</br>
输入：words = ["apple", "app"], order = "abcdefghijklmnopqrstuvwxyz"</br>
输出：false</br>
解释：当前三个字符"app"匹配时，第二个字符串相对短一些，然后根据词典编纂规则"apple" > "app"，因为'l' > '∅'，其中'∅'是空白字符，定义为比任何其他字符都小（更多信息）。</br>

提示：</br>
1 <= words.length <= 100</br>
1 <= words[i].length <= 20</br>
order.length == 26</br>
在words[i]和order中的所有字符都是英文小写字母。</br>

[Link](https://leetcode.cn/problems/verifying-an-alien-dictionary/)