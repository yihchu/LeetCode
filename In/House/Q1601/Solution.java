package In.House.Q1601;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

//    // 差8个用例没通过呢~
//    public int maximumRequests(int n, int[][] requests) {
//        int len = requests.length;
//        boolean[] marks = new boolean[len];
////        for (int i = 0; i < len; ++i) {
//        for (int i = len - 1; i > -1; --i) {
//            if (marks[i]) {
//                continue;
//            }
//            marks[i] = true;
//            if (requests[i][0] == requests[i][1]) {
//                continue;
//            }
//            if (!dfs(requests[i][0], requests[i][1], requests, marks)) {
//                marks[i] = false;
//            }
//        }
//        int sum = 0;
//        for (boolean mark: marks) {
//            sum += mark ? 1: 0;
//        }
//        return sum;
//    }
//
//    private boolean dfs(int start, int end, int[][] requests, boolean[] marks) {
//        int len = requests.length;
//        for (int i = 0; i < len; ++i) {
//            if (marks[i]) {
//                continue;
//            }
//            if (end != requests[i][0]) {
//                continue;
//            }
//            marks[i] = true;
//            if (requests[i][1] == start) {
//                return true;
//            }
//            if (dfs(start, requests[i][1], requests, marks)) {
//                return true;
//            }
//            marks[i] = false;
//        }
//        return false;
//    }

    public int maximumRequests(int n, int[][] requests) {
        int[] delta = new int[n];
        int result = 0, len = requests.length;
        for (int mask = 0; mask < (1 << len); ++mask) {
            int count = Integer.bitCount(mask);
            if (count <= result) {
                continue;
            }
            Arrays.fill(delta, 0);
            for (int i = 0; i < len; ++i) {
                if ((mask & (1 << i)) != 0) {
                    ++ delta[requests[i][0]];
                    -- delta[requests[i][1]];
                }
            }
            boolean flag = true;
            for (int x: delta) {
                if (x != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result = count;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maximumRequests(5, new int[][] {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}})); // 5
        System.out.println(slt.maximumRequests(3, new int[][] {{0, 0}, {1, 2}, {2, 1}})); // 3
        System.out.println(slt.maximumRequests(4, new int[][] {{0, 3}, {3, 3}, {3, 1}, {0, 1}, {3, 2}, {2, 2}, {2, 0}, {1, 0}, {1, 0}, {1, 2}, {2, 0}, {1, 3}, {3, 0}})); // 10
    }

}

/**
Ques: 最多可达成的换楼请求数目
Link: https://leetcode-cn.com/problems/maximum-number-of-achievable-transfer-requests/

我们有n栋楼，编号从0到n - 1。每栋楼有若干员工。由于现在是换楼的季节，部分员工想要换一栋楼居住。
给你一个数组requests，其中requests[i] = [from[i], to[i]]，表示一个员工请求从编号为from[i]的楼搬到编号为to[i]的楼。
一开始所有楼都是满的，所以从请求列表中选出的若干个请求是可行的需要满足每栋楼员工净变化为0。意思是每栋楼离开的员工数目等于该楼搬入的员工数数目。比方说n = 3且两个员工要离开楼0，一个员工要离开楼1，一个员工要离开楼2，如果该请求列表可行，应该要有两个员工搬入楼0，一个员工搬入楼1，一个员工搬入楼2。
请你从原请求列表中选出若干个请求，使得它们是一个可行的请求列表，并返回所有可行列表中最大请求数目。

示例1(图1.jpeg)：
输入：n = 5, requests = [[0, 1], [1, 0], [0, 1], [1, 2], [2, 0], [3, 4]]
输出：5
解释：请求列表如下：
从楼0离开的员工为x和y，且他们都想要搬到楼1。
从楼1离开的员工为a和b，且他们分别想要搬到楼2和0。
从楼2离开的员工为z，且他想要搬到楼0。
从楼3离开的员工为c，且他想要搬到楼4。
没有员工从楼4离开。
我们可以让x和b交换他们的楼，以满足他们的请求。
我们可以让y，a和z三人在三栋楼间交换位置，满足他们的要求。
所以最多可以满足5个请求。

示例2(图2.jpeg)：
输入：n = 3, requests = [[0, 0], [1, 2], [2, 1]]
输出：3
解释：请求列表如下：
从楼0离开的员工为x，且他想要回到原来的楼0。
从楼1离开的员工为y，且他想要搬到楼2。
从楼2离开的员工为z，且他想要搬到楼1。
我们可以满足所有的请求。

示例3：
输入：n = 4, requests = [[0, 3], [3, 1], [1, 2], [2, 0]]
输出：4

提示：
1 <= n <= 20
1 <= requests.length <= 16
requests[i].length == 2
0 <= from[i], to[i] < n

*/