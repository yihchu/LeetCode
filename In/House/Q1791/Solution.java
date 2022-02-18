package In.House.Q1791;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findCenter(int[][] edges) {
        int len = edges.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; len > 2 && i < 3 || i < 2; ++i) {
            map.put(edges[i][0], map.getOrDefault(edges[i][0], 0) + 1);
            map.put(edges[i][1], map.getOrDefault(edges[i][1], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 3 || len == 2 && entry.getValue() == 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findCenter(new int[][] {{1, 2}, {2, 3}, {4, 2}})); // 2
        System.out.println(slt.findCenter(new int[][] {{1, 2}, {5, 1}, {1, 3}, {1, 4}})); // 1
    }

}

/**
Ques: 找出星型图的中心节点
Link: https://leetcode-cn.com/problems/find-center-of-star-graph/

有一个无向的星型图，由n个编号从1到n的节点组成。星型图有一个中心节点，并且恰有n - 1条边将中心节点与其他每个节点连接起来。
给你一个二维整数数组edges，其中edges[i] = [u[i], v[i]]表示在节点u[i]和v[i]之间存在一条边。请你找出并返回edges所表示星型图的中心节点。

示例1(图1.png)：
输入：edges = [[1, 2], [2, 3], [4, 2]]
输出：2
解释：如上图所示，节点2与其他每个节点都相连，所以节点2是中心节点。

示例2：
输入：edges = [[1, 2], [5, 1], [1, 3], [1, 4]]
输出：1

提示：
3 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
1 <= u[i], v[i] <= n
u[i] != v[i]
题目数据给出的edges表示一个有效的星型图
*/