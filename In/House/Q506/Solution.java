package In.House.Q506;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Integer, String> dict = new HashMap<>() {{
        put(1, "Gold Medal");
        put(2, "Silver Medal");
        put(3, "Bronze Medal");
    }};

    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        Map<Integer, Integer> map = new HashMap<>() {{
           for (int i = 0; i < len; ++i) {
               put(score[i], i);
           }
        }};
        Arrays.sort(score);
        String[] result = new String[len];
        for (int i = 0; i < len; ++i) {
            result[map.get(score[i])] = dict.getOrDefault(len - i, String.valueOf(len - i));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.findRelativeRanks(new int[] {5, 4, 3, 2, 1})).forEach(s -> System.out.print(s + " "));
        System.out.println();
        Arrays.stream(slt.findRelativeRanks(new int[] {10, 3, 8, 9, 4})).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }


}
