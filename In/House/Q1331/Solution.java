package In.House.Q1331;

import java.util.*;

public class Solution {

    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        Arrays.sort(arr);
        int[] result = new int[arr.length];
        int order = 1;
        for (int a: arr) {
            if (!map.containsKey(a)) {
                continue;
            }
            for (int k: map.get(a)) {
                result[k] = order;
            }
//            order += map.get(a).size();
            ++ order;
            map.remove(a);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.arrayRankTransform(new int[] {40, 10, 20, 30})).forEach(a -> System.out.print(a +" "));
        System.out.println(); // [4, 1, 2, 3]
        Arrays.stream(slt.arrayRankTransform(new int[] {100, 100, 100})).forEach(a -> System.out.print(a +" "));
        System.out.println(); // [1, 1, 1]
        Arrays.stream(slt.arrayRankTransform(new int[] {37, 12, 28, 9, 100, 56, 80, 5, 12})).forEach(a -> System.out.print(a +" "));
        System.out.println(); // [5, 3, 4, 2, 8, 6, 7, 1, 3]
    }

}
