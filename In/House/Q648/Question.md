<h1>单词替换</h1>

在英语中，我们有一个叫做词根(root)的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为继承词(successor)。例如，词根an，跟随着单词other(其他)，可以形成新的单词another(另一个)。</br>
现在，给定一个由许多词根组成的词典dictionary和一个用空格分隔单词形成的句子sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。</br>
你需要输出替换之后的句子。</br>

示例1：</br>
输入：dictionary = ["cat", "bat", "rat"], sentence = "the cattle was rattled by the battery"</br>
输出："the cat was rat by the bat"</br>

示例2：</br>
输入：dictionary = ["a", "b", "c"], sentence = "aadsfasf absbs bbab cadsfafs"</br>
输出："a a b c"</br>

提示：</br>
1 <= dictionary.length <= 1000</br>
1 <= dictionary[i].length <= 100</br>
dictionary[i]仅由小写字母组成。</br>
1 <= sentence.length <= 10^6</br>
sentence仅由小写字母和空格组成。</br>
sentence中单词的总量在范围[1, 1000]内。</br>
sentence中每个单词的长度在范围[1, 1000]内。</br>
sentence中单词之间由一个空格隔开。</br>
sentence没有前导或尾随空格。</br>

[Link](https://leetcode.cn/problems/replace-words/)