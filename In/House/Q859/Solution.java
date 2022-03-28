package In.House.Q859;

import java.util.*;

public class Solution {

    public boolean buddyStrings(String s, String goal) {
        int len = s.length();
        if (len != goal.length()) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        boolean repeated = false;
        Character c1 = null, c2 = null;
        int count = 0;
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (!repeated) {
                if (set.contains(c)) {
                    repeated = true;
                } else {
                    set.add(c);
                }
            }
            if(c == goal.charAt(i)) {
                continue;
            }
            ++count;
            if (Objects.isNull(c1)) {
                c1 = c;
                c2 = goal.charAt(i);
            } else if (c2 != c || c1 != goal.charAt(i)) {
                return false;
            }
        }
        return count == 2 || (count == 0 && repeated);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.buddyStrings("ab", "ba")); // true
        System.out.println(slt.buddyStrings("ab", "ab")); // false
        System.out.println(slt.buddyStrings("aa", "aa")); // true
        System.out.println(slt.buddyStrings("aaaaaaabc", "aaaaaaacb")); // true
        System.out.println(slt.buddyStrings("abac", "abad")); // false
    }

}

