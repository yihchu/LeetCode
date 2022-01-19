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

/**
Ques: 天际线问题
Link: https://leetcode-cn.com/problems/the-skyline-problem/

城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的天际线 。
每个建筑物的几何信息由数组buildings表示，其中三元组buildings[i] = [left[i], right[i], height[i]]表示：
left[i]是第i座建筑物左边缘的x坐标。
right[i]是第i座建筑物右边缘的x坐标。
height[i]是第i座建筑物的高度。
天际线应该表示为由“关键点”组成的列表，格式[[x[1], y[1]], [x[2], y[2]], ...]，并按x坐标进行排序。关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y坐标始终为0，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
注意：输出天际线中不得有连续的相同高度的水平线。例如[...[2 3], [4 5], [7 5], [11 5], [12 7]...]是不正确的答案；三条高度为5的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]

示例1：
输入：buildings = [[2, 9, 10], [3, 7, 15], [5, 12, 12], [15, 20, 10], [19, 24, 8]]
输出：[[2, 10], [3, 15], [7, 12], [12, 0], [15, 10], [20, 8], [24, 0]]
解释：
图1.jpeg的A部分显示输入的所有建筑物的位置和高度，
图1.jpeg的B部分显示由这些建筑物形成的天际线，红点表示输出列表中的关键点。

示例2：
输入：buildings = [[0, 2, 3], [2, 5, 3]]
输出：[[0, 3], [5, 0]]

提示：
1 <= buildings.length <= 10^4
0 <= left[i] < right[i] <= 2^31 - 1
1 <= height[i] <= 2^31 - 1
buildings按left[i]非递减排序

*/