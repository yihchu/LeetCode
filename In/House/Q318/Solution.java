package In.House.Q318;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxProduct(String[] words) {
        Map<String, Map<Character, Boolean>> map = new HashMap<>();
        for (String word: words) {
            Map<Character, Boolean> tmp = new HashMap<>();
            for (int i = 0; i < word.length(); ++i) {
                tmp.put(word.charAt(i), true);
            }
            map.put(word, tmp);
        }
        int result = 0, len = words.length;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                boolean flag = true;
                for (char c = 'a'; c <= 'z'; ++c) {
                    Map<Character, Boolean> m1 = map.get(words[i]);
                    Map<Character, Boolean> m2 = map.get(words[j]);
                    if (m1.containsKey(c) && m2.containsKey(c)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    int tmp = words[i].length() * words[j].length();
                    result = result < tmp ? tmp : result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"})); // 16
        System.out.println(slt.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"})); // 4
        System.out.println(slt.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"})); // 0
    }

}

