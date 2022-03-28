package In.House.Q1705;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int eatenApples(int[] apples, int[] days) {
        Map<Integer, Integer> map = new HashMap();
        int len = apples.length;
        Queue<Integer> q = new PriorityQueue();
        int count = 0;
        for (int i = 0; i < len || (i >= 0 && !q.isEmpty()); ++i) {
            if (i < len) {
                int lastDay = i + days[i] - 1;
                if (lastDay > 0) {
                    q.add(lastDay);
                    map.put(lastDay, map.getOrDefault(lastDay, 0) + apples[i]);
                }
            }
            while (!q.isEmpty()) {
                int curDay = q.peek();
                if (curDay < i) {
                    map.remove(curDay);
                    q.poll();
                    continue;
                }
                ++ count;
                if (map.get(curDay) == 1) {
                    map.remove(curDay);
                    q.poll();
                } else {
                    map.put(curDay, map.get(curDay) - 1);
                }
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        System.out.println(slt.eatenApples(new int[] {1, 2, 3, 5, 2}, new int[] {3, 2, 1, 4, 2})); // 7
//        System.out.println(slt.eatenApples(new int[] {3, 0, 0, 0, 0, 2}, new int[] {3, 0, 0, 0, 0, 2})); // 5
        System.out.println(slt.eatenApples(new int[] {1}, new int[] {2})); // 1
    }

}
