package In.House.Q1220;

public class Solution {

    // 哇，刷Hard，一下就想到了正解，真开心
    public int countVowelPermutation(int n) {
        final int THRESHOLD = 1000000007;
        int[] arr = new int[] {1, 1, 1, 1, 1};
        for (int i = 1; i < n; ++i) {
            int[] tmp = new int[5];
            tmp[0] = ((arr[1] + arr[2]) % THRESHOLD + arr[4]) % THRESHOLD;
            tmp[1] = (arr[0] + arr[2]) % THRESHOLD;
            tmp[2] = (arr[1] + arr[3]) % THRESHOLD;
            tmp[3] = arr[2];
            tmp[4] = (arr[2] + arr[3]) % THRESHOLD;
            arr = tmp;
        }
        int sum = 0;
        for (int s: arr) {
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
Ques: 统计元音字母序列的数目
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