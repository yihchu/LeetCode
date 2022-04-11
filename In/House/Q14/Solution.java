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


