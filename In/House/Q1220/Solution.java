package In.House.Q1220;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countVowelPermutation(int n) {
        final int THRESHOLD = 1000000007;
        Map<Character, Integer> map = new HashMap<>() {{
            put('a', 1);
            put('e', 1);
            put('i', 1);
            put('o', 1);
            put('u', 1);
        }};
        for (int i = 1; i < n; ++i) {
            int countA = (map.get('e') + map.get('i')) % THRESHOLD + map.get('u');
            int countE = map.get('a') + map.get('i');
            int countI = map.get('e') + map.get('o');
            int countO = map.get('i');
            int countU = map.get('i') + map.get('o');
            map.put('a', countA % THRESHOLD);
            map.put('e', countE % THRESHOLD);
            map.put('i', countI % THRESHOLD);
            map.put('o', countO % THRESHOLD);
            map.put('u', countU % THRESHOLD);
        }
        int sum = 0;
        for (Integer s: map.values()) {
            sum += s;
            sum %= THRESHOLD;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.countVowelPermutation(1)); // 5
        System.out.println(slt.countVowelPermutation(2)); // 10
        System.out.println(slt.countVowelPermutation(5)); // 68
        System.out.println(slt.countVowelPermutation(144)); // 18208803
    }

}

/**
Link: https://leetcode-cn.com/problems/count-vowels-permutation/

给你一个整数n，请你帮忙统计一下我们可以按下述规则形成多少个长度为n的字符串：
字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
每个元音'a'后面都只能跟着'e'
每个元音'e'后面只能跟着'a'或者是'i'
每个元音'i'后面不能再跟着另一个'i'
每个元音'o'后面只能跟着'i'或者是'u'
每个元音'u'后面只能跟着'a'
由于答案可能会很大，所以请你返回模10^9 + 7之后的结果。

示例1：
输入：n = 1
输出：5
解释：所有可能的字符串分别是："a", "e", "i" , "o"和"u"。

示例2：
输入：n = 2
输出：10
解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou"和"ua"。

示例3：
输入：n = 5
输出：68

提示：
1 <= n <= 2 * 10^4

*/