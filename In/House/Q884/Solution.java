package In.House.Q884;

import java.util.*;

public class Solution {

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String str: arr1) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str: arr2) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return map.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).toArray(String[]::new);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.uncommonFromSentences("this apple is sweet", "this apple is sour"))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        Arrays.stream(slt.uncommonFromSentences("apple apple", "banana"))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

}
