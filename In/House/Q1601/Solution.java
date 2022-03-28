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
