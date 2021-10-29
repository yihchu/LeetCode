package In.House.Q1893;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public boolean isCovered(int[][] ranges, int left, int right) {
        List<int[]> list = Arrays.stream(ranges).collect(Collectors.toList());
        int count = 0;
        for(int v = left; v <= right; ) {
            if (list.size() == 0 || count > list.size()) {
                return false;
            }
            int[] current = list.get(0);
            if (current[0] > v) {
                list.remove(0);
                list.add(current);
                ++count;
                continue;
            } else if (current[1] < v || current[0] > right) {
                list.remove(0);
            } else {
                v = (current[1] <= right ? current[1] : right) + 1;
                list.remove(0);
            }
            count = 0;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.isCovered(new int[][]{{1, 2}, {3, 4}, {5,6}}, 2, 5));
        System.out.println(slt.isCovered(new int[][]{{1, 10}, {10, 20}}, 21, 21));
        System.out.println(slt.isCovered(new int[][]{{50, 50}}, 1, 50));
        System.out.println(slt.isCovered(new int[][]{{37, 49}, {5, 17}, {8, 32}}, 29, 49));
        System.out.println(slt.isCovered(new int[][]{{2, 49}}, 1, 50));
    }

}


/**
Link: https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/

给你一个二维整数数组ranges和两个整数left和right。每个ranges[i] = [start[i], end[i]]表示一个从start[i]到end[i]的闭区间。
如果闭区间[left, right]内每个整数都被ranges中至少一个区间覆盖，那么请你返回true，否则返回false。
已知区间ranges[i] = [start[i], end[i]] ，如果整数x满足start[i] <= x <= end[i]，那么我们称整数x被覆盖了。

示例1：
输入：ranges = [[1, 2], [3, 4], [5, 6]], left = 2, right = 5
输出：true
解释：2到5的每个整数都被覆盖了：
- 2被第一个区间覆盖。
- 3和4被第二个区间覆盖。
- 5被第三个区间覆盖。

示例2：
输入：ranges = [[1, 10], [10, 20]], left = 21, right = 21
输出：false
解释：21没有被任何一个区间覆盖。
提示：
1 <= ranges.length <= 50
1 <= start[i] <= end[i] <= 50
1 <= left <= right <= 50

*/
