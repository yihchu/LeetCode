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

/**
Link: https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/

有一棵特殊的苹果树，一连n天，每天都可以长出若干个苹果。在第i天，树上会长出apples[i]个苹果，这些苹果将会在days[i]天后（也就是说，第i + days[i]天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用apples[i] == 0且days[i] == 0表示。
你打算每天最多吃一个苹果来保证营养均衡。注意，你可以在这n天之后继续吃苹果。
给你两个长度为n的整数数组days和apples，返回你可以吃掉的苹果的最大数目。

示例1：
输入：apples = [1, 2, 3, 5, 2], days = [3, 2, 1, 4, 2]
输出：7
解释：你可以吃掉7个苹果：
- 第一天，你吃掉第一天长出来的苹果。
- 第二天，你吃掉一个第二天长出来的苹果。
- 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
- 第四天到第七天，你吃的都是第四天长出来的苹果。

示例2：
输入：apples = [3, 0, 0, 0, 0, 2], days = [3, 0, 0, 0, 0, 2]
输出：5
解释：你可以吃掉5个苹果：
- 第一天到第三天，你吃的都是第一天长出来的苹果。
- 第四天和第五天不吃苹果。
- 第六天和第七天，你吃的都是第六天长出来的苹果。

提示：
apples.length == n
days.length == n
1 <= n <= 2 * 10^4
0 <= apples[i], days[i] <= 2 * 10^4
只有在apples[i] = 0时，days[i] = 0才成立
*/