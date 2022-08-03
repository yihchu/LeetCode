<h1>最短补全词</h1>

给你一个字符串licensePlate和一个字符串数组words，请你找出并返回words中的最短补全词。</br>
补全词是一个包含licensePlate中所有的字母的单词。在所有补全词中，最短的那个就是最短补全词。</br>
在匹配licensePlate中的字母时：</br>
忽略licensePlate中的数字和空格。</br>
不区分大小写。</br>
如果某个字母在licensePlate中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。</br>
例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母'a'、'b'（忽略大写）和两个'c'。可能的补全词有"abccdef"、"caaacab"以及"cbca"。</br>
请你找出并返回words中的最短补全词。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取words中最靠前的那个。</br>

示例1：</br>
输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]</br>
输出："steps"</br>
解释：最短补全词应该包括"s"、"p"、"s"（忽略大小写）以及"t"。</br>
"step"包含"t"、"p"，但只包含一个"s"，所以它不符合条件。</br>
"steps"包含"t"、"p"和两个"s"。</br>
"stripe"缺一个"s"。</br>
"stepple"缺一个"s"。</br>
因此，"steps"是唯一一个包含所有字母的单词，也是本例的答案。</br>

示例2：</br>
输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]</br>
输出："pest"</br>
解释：licensePlate只包含字母"s"。所有的单词都包含字母"s"，其中"pest"、"stew"、和"show"三者最短。答案是"pest"，因为它是三个单词中在words里最靠前的那个。</br>

示例3：</br>
输入：licensePlate = "Ah71752", words = ["suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"]</br>
输出："husband"</br>

示例4：</br>
输入：licensePlate = "OgEu755", words = ["enough", "these", "play", "wide", "wonder", "box", "arrive", "money", "tax", "thus"]</br>
输出："enough"</br>

示例5：</br>
输入：licensePlate = "iMSlpe4", words = ["claim", "consumer", "student", "camera", "public", "never", "wonder", "simple", "thought", "use"]</br>
输出："simple"</br>

提示：
- 1 <= licensePlate.length <= 7
- licensePlate由数字、大小写字母或空格' '组成
- 1 <= words.length <= 1000
- 1 <= words[i].length <= 15
- words[i]由小写英文字母组成

[Link](https://leetcode-cn.com/problems/shortest-completing-word/)