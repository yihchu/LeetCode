package In.House.Q748;

import java.util.*;

public class Solution {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); ++i) {
            char c = licensePlate.charAt(i);
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                continue;
            }
            c = c >= 'a' ? c : (char)(c + 32);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        Arrays.sort(words, Comparator.comparingInt(String::length));
        String result = null;
        for (String word: words) {
            Map<Character, Integer> current = (HashMap<Character, Integer>) target.clone();
            for (int i = 0 ; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (!current.containsKey(c)) {
                    continue;
                }
                int v = current.get(c);
                if (v == 1) {
                    current.remove(c);
                } else {
                    current.put(c, v - 1);
                }
            }
            if (current.size() == 0) {
                result = word;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.shortestCompletingWord("1s3 PSt", new String[] {"step", "steps", "stripe", "stepple"})); // "steps"
        System.out.println(slt.shortestCompletingWord("1s3 456", new String[] {"looks", "pest", "stew", "show"})); // "pest"
        System.out.println(slt.shortestCompletingWord("Ah71752", new String[] {"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"})); // "husband"
        System.out.println(slt.shortestCompletingWord("OgEu755", new String[] {"enough","these","play","wide","wonder","box","arrive","money","tax","thus"})); // "enough"
        System.out.println(slt.shortestCompletingWord("iMSlpe4", new String[] {"claim","consumer","student","camera","public","never","wonder","simple","thought","use"})); // "simple"
    }

}

/**
Ques: 最短补全词
Link: https://leetcode-cn.com/problems/shortest-completing-word/

给你一个字符串licensePlate和一个字符串数组words，请你找出并返回words中的最短补全词。
补全词是一个包含licensePlate中所有的字母的单词。在所有补全词中，最短的那个就是最短补全词。
在匹配licensePlate中的字母时：
忽略licensePlate中的数字和空格。
不区分大小写。
如果某个字母在licensePlate中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母'a'、'b'（忽略大写）和两个'c'。可能的补全词有"abccdef"、"caaacab"以及"cbca"。
请你找出并返回words中的最短补全词。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取words中最靠前的那个。

示例1：
输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
输出："steps"
解释：最短补全词应该包括"s"、"p"、"s"（忽略大小写）以及"t"。
"step"包含"t"、"p"，但只包含一个"s"，所以它不符合条件。
"steps"包含"t"、"p"和两个"s"。
"stripe"缺一个"s"。
"stepple"缺一个"s"。
因此，"steps"是唯一一个包含所有字母的单词，也是本例的答案。

示例2：
输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
输出："pest"
解释：licensePlate只包含字母"s"。所有的单词都包含字母"s"，其中"pest"、"stew"、和"show"三者最短。答案是"pest"，因为它是三个单词中在words里最靠前的那个。

示例3：
输入：licensePlate = "Ah71752", words = ["suggest", "letter", "of", "husband", "easy", "education", "drug", "prevent", "writer", "old"]
输出："husband"

示例4：
输入：licensePlate = "OgEu755", words = ["enough", "these", "play", "wide", "wonder", "box", "arrive", "money", "tax", "thus"]
输出："enough"

示例5：
输入：licensePlate = "iMSlpe4", words = ["claim", "consumer", "student", "camera", "public", "never", "wonder", "simple", "thought", "use"]
输出："simple"

提示：
1 <= licensePlate.length <= 7
licensePlate由数字、大小写字母或空格' '组成
1 <= words.length <= 1000
1 <= words[i].length <= 15
words[i]由小写英文字母组成

*/