package In.House.Q524;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String str: dictionary) {
            if (!isSubString(s, str)) {
                continue;
            }
            result = result.length() < str.length() || (result.length() == str.length() && str.compareTo(result) < 0) ? str : result;
        }
        return result;
    }

    private boolean isSubString(String str, String s) {
        int l = 0, r = 0;
        while (l < str.length() && r < s.length()) {
            if (str.charAt(l) == s.charAt(r)) {
                ++l;
                ++r;
            } else {
                ++l;
            }
        }
        return r == s.length();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"))); // apple
        System.out.println(slt.findLongestWord("abpcplea", Arrays.asList("a", "b", "c"))); // a
    }

}

