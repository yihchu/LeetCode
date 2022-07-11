<h1>实现一个魔法字典</h1>

设计一个使用单词列表进行初始化的数据结构，单词列表中的单词互不相同。如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。</br>
实现MagicDictionary类：</br>
- MagicDictionary()初始化对象
- void buildDict(String[] dictionary)使用字符串数组dictionary设定该数据结构，dictionary中的字符串互不相同
- bool search(String searchWord)给定一个字符串searchWord，判定能否只将字符串中一个字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回true；否则，返回false。

示例：</br>
输入</br>
["MagicDictionary", "buildDict", "search", "search", "search", "search"]</br>
[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]</br>
输出</br>
[null, null, false, true, false, false]</br>

解释</br>
MagicDictionary magicDictionary = new MagicDictionary();</br>
magicDictionary.buildDict(["hello", "leetcode"]);</br>
magicDictionary.search("hello"); // 返回False</br>
magicDictionary.search("hhllo"); // 将第二个'h'替换为'e'可以匹配"hello"，所以返回True</br>
magicDictionary.search("hell"); // 返回False</br>
magicDictionary.search("leetcoded"); // 返回False</br>

提示：</br>
- 1 <= dictionary.length <= 100
- 1 <= dictionary[i].length <= 100
- dictionary[i]仅由小写英文字母组成
- dictionary中的所有字符串 互不相同
- 1 <= searchWord.length <= 100
- searchWord仅由小写英文字母组成
- buildDict仅在search之前调用一次
- 最多调用100次search

[Link](https://leetcode.cn/problems/implement-magic-dictionary/)