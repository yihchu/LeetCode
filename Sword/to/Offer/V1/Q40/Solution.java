package Sword.to.Offer.V1.Q40;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; ++i) {
            if (q.size() < k) {
                q.add(arr[i]);
            } else if (q.size() == k && q.peek() > arr[i]) {
                q.poll();
                q.add(arr[i]);
            }
        }
        return q.stream().mapToInt(a -> a).toArray();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        Arrays.stream(slt.getLeastNumbers(new int[]{3, 2, 1}, 2)).forEach(a -> System.out.print(a + " ")); // [1, 2]
//        System.out.println();
//        Arrays.stream(slt.getLeastNumbers(new int[]{0, 1, 2, 1}, 1)).forEach(a -> System.out.print(a)); // [0]
//        System.out.println();
        Arrays.stream(slt.getLeastNumbers(new int[]{0, 0, 0, 2, 0, 5}, 0)).forEach(a -> System.out.print(a)); // [0]
        System.out.println();
    }
}
