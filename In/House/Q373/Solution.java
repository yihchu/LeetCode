package In.House.Q373;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(o -> (o.get(0) + o.get(1))));
        for (int i = 0; i < len1 && i < k; ++i) {
            for (int j = 0; j < len2 && j < k; ++j) {
                int l = nums1[i], r = nums2[j];
                queue.add(new ArrayList<>() {{
                    add(l);
                    add(r);
                }});
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k && !queue.isEmpty(); ++i) {
            result.add(queue.poll());
        }
        return result;
    }

    private static void print(List<List<Integer>> ll) {
        for (List<Integer> l: ll) {
            System.out.print("<" + l.get(0) + ", " + l.get(1) + "> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        print(slt.kSmallestPairs(new int[] {1, 7, 11}, new int[] {2, 4, 6}, 3));
        print(slt.kSmallestPairs(new int[] {1, 1, 2}, new int[] {1, 2, 3}, 2));
        print(slt.kSmallestPairs(new int[] {1, 2}, new int[] {3}, 3));
    }

}


