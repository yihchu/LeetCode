package In.House.Q3;

import java.util.*;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }
        Set<Character> set = new HashSet<>();
        int max = 0, start = 0;
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                continue;
            }
            max = max < set.size() ? set.size(): max;
            while (true) {
                char cc = s.charAt(start ++);
                if (cc != c) {
                    set.remove(cc);
                    continue;
                }
                break;
            }
        }
        max = max < set.size() ? set.size(): max;
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(slt.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(slt.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(slt.lengthOfLongestSubstring("")); // 0
    }

}


