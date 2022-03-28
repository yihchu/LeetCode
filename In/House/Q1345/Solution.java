package In.House.Q1345;

import java.util.*;

public class Solution {

    // 广度优先搜索，把相同节点统一处理。
    public int minJumps(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return 0;
        }
        Map<Integer, List<Integer>> sames = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            sames.putIfAbsent(arr[i], new ArrayList<>());
            sames.get(arr[i]).add(i);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited.add(0);
        while (!queue.isEmpty()) {
            int[] idxes = queue.poll();
            int idx = idxes[0], step = idxes[1];
            if (idx == arr.length - 1) {
                return step;
            }
            int v = arr[idx];
            ++step;
            if (sames.containsKey(v)) {
                for ( int i : sames.get(v)) {
                    if (visited.add(i)) {
                        queue.add(new int[] {i, step});
                    }
                }
                sames.remove(v);
            }
            if (idx + 1 < arr.length && visited.add(idx + 1)) {
                queue.add(new int[] {idx + 1, step});
            }
            if (idx - 1 >= 0 && visited.add(idx - 1)) {
                queue.offer(new int[] {idx - 1, step});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.minJumps(new int[] {100, -23, -23, 404, 100, 23, 23, 23, 3, 404})); // 3
        System.out.println(slt.minJumps(new int[] {7})); // 0
        System.out.println(slt.minJumps(new int[] {7, 6, 9, 6, 9, 6, 9, 7})); // 1
        System.out.println(slt.minJumps(new int[] {6, 1, 9})); // 2
        System.out.println(slt.minJumps(new int[] {11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13})); // 3
    }

}
