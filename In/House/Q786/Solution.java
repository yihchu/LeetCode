package In.House.Q786;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Map<Double, int[]> map = new HashMap<>();
        PriorityQueue<Double> queue = new PriorityQueue<>((d1, d2) -> Double.compare(d2, d1));
        int len = arr.length;
        Double maxKey = Double.MIN_VALUE;
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                Double key = (double)arr[i] / arr[j];
                if (map.keySet().size() < k) {
                    map.put(key, new int[] {arr[i], arr[j]});
                    queue.add(key);
                    maxKey = maxKey < key ? key : maxKey;
                    continue;
                }
                if (key >= maxKey) {
                    continue;
                }
                map.remove(maxKey);
                queue.remove(maxKey);
                map.put(key, new int[] {arr[i], arr[j]});
                queue.add(key);
                maxKey = queue.peek();
            }
        }
        return map.get(maxKey);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.kthSmallestPrimeFraction(new int[] {1, 2, 3, 5}, 3)) // [2, 5]
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.kthSmallestPrimeFraction(new int[] {1, 7}, 1)) // [1, 7]
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.kthSmallestPrimeFraction(new int[] {1, 29, 47}, 1)) // [1, 47]
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.kthSmallestPrimeFraction(new int[] {1, 2, 11, 37, 83, 89}, 11)) // [11, 37]
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}

