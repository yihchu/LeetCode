package In.House.Q953;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isAlienSorted(String[] words, String order) {
        int len = words.length;
        if (len == 1) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; ++i) {
            if (compare(words[i], words[i - 1], map) < 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String s1, String s2, Map<Character, Integer> map) {
        int len1 = s1.length(), len2 = s2.length();
        int idx = 0;
        while (idx < len1 && idx < len2) {
            int idx1 = map.get(s1.charAt(idx)), idx2 = map.get(s2.charAt(idx));
            if (idx1 == idx2) {
                ++ idx;
                continue;
            }
            return idx1 > idx2 ? 1 : -1;
        }
        return len1 == len2 ? 0 : (len1 > len2 ? 1 : -1);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.isAlienSorted(new String[] {"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(slt.isAlienSorted(new String[] {"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(slt.isAlienSorted(new String[] {"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

}
