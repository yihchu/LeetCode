public class LT1221 {

    public int balancedStringSplit(String s) {
        int len = s.length();
        int l = 0, r = 0, count = 0;
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == 'L') {
                ++l;
            } else {
                ++r;
            }
            if (l == r) {
                ++count;
                l = r = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LT1221 lt1221 = new LT1221();
        System.out.println(lt1221.balancedStringSplit("RLRRLLRLRL")); // 4
        System.out.println(lt1221.balancedStringSplit("RLLLLRRRLR")); // 3
        System.out.println(lt1221.balancedStringSplit("LLLLRRRR")); // 1
        System.out.println(lt1221.balancedStringSplit("RLRRRLLRLL")); // 2
    }

}

/*

在一个平衡字符串中，'L'和'R'字符的数量是相同的。
给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
注意：分割得到的每个字符串都必须是平衡字符串。
返回可以通过分割得到的平衡字符串的最大数量 。

示例 1：
输入：s = "RLRRLLRLRL"
输出：4
解释：s可以分割为"RL"、"RRLL"、"RL"、"RL"，每个子字符串中都包含相同数量的'L'和'R'。

示例 2：
输入：s = "RLLLLRRRLR"
输出：3
解释：s可以分割为"RL"、"LLLRRR"、"LR"，每个子字符串中都包含相同数量的'L'和'R'。

示例 3：
输入：s = "LLLLRRRR"
输出：1
解释：s只能保持原样"LLLLRRRR".

示例 4：
输入：s = "RLRRRLLRLL"
输出：2
解释：s可以分割为"RL"、"RRRLLRLL"，每个子字符串中都包含相同数量的'L'和'R'。

提示：
1 <= s.length <= 1000
s[i] = 'L' 或 'R'
s是一个平衡字符串

*/