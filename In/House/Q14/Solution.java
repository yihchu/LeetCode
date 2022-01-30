package In.House.Q14;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 1) {
            return strs[0];
        }
        String result = findPrefix(strs[0], strs[1]);
        for (int i = 2; i < len; ++i) {
            result = findPrefix(result, strs[i]);
        }
        return result;
    }

    private String findPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            if (str1.charAt(i) == str2.charAt(i)) {
                builder.append(str1.charAt(i));
                continue;
            }
            break;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.longestCommonPrefix(new String[] {"flower", "flow", "flight"})); // "fl"
        System.out.println(slt.longestCommonPrefix(new String[] {"dog", "racecar", "car"})); // ""
    }

}

/**
Link: https://leetcode-cn.com/problems/longest-common-prefix/
Ques: 最长公共前缀

编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串""。

示例1：
输入：strs = ["flower", "flow", "flight"]
输出："fl"

示例2：
输入：strs = ["dog", "racecar", "car"]
输出：""
解释：输入不存在公共前缀。

提示：
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i]仅由小写英文字母组成

*/
