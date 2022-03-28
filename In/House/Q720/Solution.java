package In.House.Q720;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String longestWord(String[] words) {
        Arrays.sort(words, (s1, s2) -> s1.length() != s2.length() ? s1.length() - s2.length() : s2.compareTo(s1));
        Set<String> set = new HashSet<>() {{ add(""); }};
        String result = "";
        for (String word: words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                result = word;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.longestWord(new String[] {"w", "wo", "wor", "worl", "world"}));
        System.out.println(slt.longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

}

