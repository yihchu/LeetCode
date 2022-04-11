<h1>添加与搜索单词-数据结构设计</h1>

请你设计一个数据结构，支持添加新单词和查找字符串是否与任何先前添加的字符串匹配。</br>
实现词典类WordDictionary：</br>
WordDictionary()初始化词典对象</br>
void addWord(word)将word添加到数据结构中，之后可以对它进行匹配</br>
bool search(word)如果数据结构中存在字符串与word匹配，则返回true；否则，返回false。word中可能包含一些'.'，每个. 都可以表示任何一个字母。</br>

示例：<br>
输入：<br>
["WordDictionary", "addWord", "addWord", "addWord", "search", "search", "search", "search"]<br>
[[], ["bad"], ["dad"], ["mad"], ["pad"], ["bad"], [".ad"], ["b.."]]<br>
输出：<br>
[null, null, null, null, false, true, true, true]<br>
解释：<br>
WordDictionary wordDictionary = new WordDictionary();<br>
wordDictionary.addWord("bad");<br>
wordDictionary.addWord("dad");<br>
wordDictionary.addWord("mad");<br>
wordDictionary.search("pad"); // return False<br>
wordDictionary.search("bad"); // return True<br>
wordDictionary.search(".ad"); // return True<br>
wordDictionary.search("b.."); // return True<br>

提示：<br>
1 <= word.length <= 500<br>
addWord中的word由小写英文字母组成<br>
search中的word由'.'或小写英文字母组成<br>
最多调用50000次addWord和search<br>

[Link](https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/)