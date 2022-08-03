<h1>山羊拉丁文</h1>

给你一个由若干单词组成的句子sentence，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。</br>

请你将句子转换为“山羊拉丁文（Goat Latin）”（一种类似于猪拉丁文 - Pig Latin的虚构语言）。山羊拉丁文的规则如下：</br>
如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。</br>
例如，单词"apple"变为"applema"。</br>
如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。</br>
例如，单词"goat"变为"oatgma"。</br>
根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。</br>
例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。</br>
返回将 sentence 转换为山羊拉丁文后的句子。</br>

示例1：</br>
输入：sentence = "I speak Goat Latin"</br>
输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"</br>

示例2：</br>
输入：sentence = "The quick brown fox jumped over the lazy dog"</br>
输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"</br>

提示：
- 1 <= sentence.length <= 150
- sentence由英文字母和空格组成
- sentence不含前导或尾随空格
- sentence中的所有单词由单个空格分隔

[Link](https://leetcode-cn.com/problems/goat-latin/)