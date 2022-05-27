package Interview.N17.Q11;

import java.util.*;

public class Solution {

    public int findClosest(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        int len = words.length;
        for (int i = 0; i < len; ++i) {
            String word = words[i];
            int idx = i;
            if (map.containsKey(word)) {
                map.get(word).add(idx);
            } else {
                map.put(word, new ArrayList<>() {{add(idx);}});
            }
        }
        if (!map.containsKey(word1) || !map.containsKey(word2)) {
            return -1;
        }
        List<Integer> list1 = map.get(word1), list2 = map.get(word2);
        Collections.sort(list1);
        Collections.sort(list2);
        int result = Integer.MAX_VALUE;
        for (int idx1: list1) {
            for (int idx2: list2) {
                int tmp = Math.abs(idx1 - idx2);
                result = result > tmp ? tmp : result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findClosest(
                new String[] { "I", "am", "a", "student", "from", "a", "university", "in", "a", "city" }, "a", "student"));
    }

}
