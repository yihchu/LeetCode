package In.House.Q218;

import java.util.*;


// 太难了，勉强才看懂答案
// 然后重新写了一遍
public class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int len = buildings.length, idx = 0;
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((b1, b2) -> b2[1] - b1[1]);
        List<Integer> positions = new ArrayList<>(){{
            for (int[] building: buildings) {
                add(building[0]);
                add(building[1]);
            }
        }};
        Collections.sort(positions);
        for (int pos: positions) {
            while (idx < len && buildings[idx][0] <= pos) {
                q.add(new int[]{buildings[idx][1], buildings[idx][2]});
                ++idx;
            }
            while (!q.isEmpty() && q.peek()[0] <= pos) {
                q.poll();
            }
            int max = q.isEmpty() ? 0 : q.peek()[1];
            if (result.isEmpty() || result.get(result.size() - 1).get(1) != max) {
                result.add(new ArrayList<>(){{add(pos); add(max);}});
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        print(slt.getSkyline(new int[][] {
                new int[]{2, 9, 10}, new int[]{3, 7, 15}, new int[]{5, 12, 12}, new int[]{15, 20, 10}, new int[]{19, 24, 8}
        })); // [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
        print(slt.getSkyline(new int[][] {
                new int[]{0, 2, 3}, new int[]{2, 5, 3}
        })); // [[0,3],[5,0]]
        print(slt.getSkyline(new int[][] {
                new int[]{1, 2, 1}, new int[]{1, 2, 2}, new int[]{1, 2, 3}
        })); // [[1,3],[2,0]]
    }

    private static void print(List<List<Integer>> ll) {
        System.out.print("[");
        for (int i = 0; i < ll.size(); ++i) {
            List<Integer> l = ll.get(i);
            System.out.print("[");
            System.out.print(l.get(0) + ", " + l.get(1));
            System.out.print("]");
            if (i != ll.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}

