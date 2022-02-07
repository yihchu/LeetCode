package In.House.Q1405;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder builder = new StringBuilder();
        Pair[] pairs = {
            new Pair(a, 'a'),
            new Pair(b, 'b'),
            new Pair(c, 'c')
        };
        while (true) {
            Arrays.sort(pairs, Comparator.comparingInt(p -> - p.count));
            boolean hasNext = false;
            for (Pair pair: pairs) {
                if (pair.count <= 0) {
                    break;
                }
                int l = builder.length();
                if (l >= 2 && builder.charAt(l - 2) == pair.c && builder.charAt(l - 1) == pair.c) {
                    continue;
                }
                hasNext = true;
                builder.append(pair.c);
                -- pair.count;
                break;
            }
            if (!hasNext) {
                break;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.longestDiverseString(1, 1, 7)); // "ccaccbcc" / "ccbccacc"
        System.out.println(slt.longestDiverseString(2, 2, 1)); // "aabbc"
        System.out.println(slt.longestDiverseString(7, 1, 0)); // "aabaa"
    }

}

class Pair {
    int count;
    char c;

    public Pair(int count, char c) {
        this.count = count;
        this.c = c;
    }
}

/**
Ques: 最长快乐字符串
Link: https://leetcode-cn.com/problems/longest-happy-string/

如果字符串中不含有任何'aaa'，'bbb'或'ccc'这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
给你三个整数a，b，c请你返回任意一个满足下列全部条件的字符串s：
s是一个尽可能长的快乐字符串。
s中最多有a个字母'a'、b个字母'b'、c个字母'c'。
s中只含有'a'、'b' 、'c'三种字母。
如果不存在这样的字符串s，请返回一个空字符串""。

示例1：
输入：a = 1, b = 1, c = 7
输出："ccaccbcc"
解释："ccbccacc"也是一种正确答案。

示例2：
输入：a = 2, b = 2, c = 1
输出："aabbc"

示例3：
输入：a = 7, b = 1, c = 0
输出："aabaa"
解释：这是该测试用例的唯一正确答案。

提示：
0 <= a, b, c <= 100
a + b + c > 0
*/