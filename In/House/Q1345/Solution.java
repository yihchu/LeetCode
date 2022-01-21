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

/**
Ques: 跳跃游戏IV
Link: https://leetcode-cn.com/problems/jump-game-iv/

给你一个整数数组arr，你一开始在数组的第一个元素处（下标为0）。
每一步，你可以从下标i跳到下标：
i + 1 满足：i + 1 < arr.length
i - 1 满足：i - 1 >= 0
j 满足：arr[i] == arr[j]且i != j

请你返回到达数组最后一个元素的下标处所需的最少操作次数。
注意：任何时候你都不能跳到数组外面。

示例1：
输入：arr = [100, -23, -23, 404, 100, 23, 23, 23, 3, 404]
输出：3
解释：那你需要跳跃3次，下标依次为 0 --> 4 --> 3 --> 9 。下标9为数组的最后一个元素的下标。

示例2：
输入：arr = [7]
输出：0
解释：一开始就在最后一个元素处，所以你不需要跳跃。

示例3：
输入：arr = [7, 6, 9, 6, 9, 6, 9, 7]
输出：1
解释：你可以直接从下标0处跳到下标7处，也就是数组的最后一个元素处。

示例4：
输入：arr = [6, 1, 9]
输出：2

示例5：
输入：arr = [11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13]
输出：3

提示：
1 <= arr.length <= 5 * 10^4
-10^8 <= arr[i] <= 10^8

*/