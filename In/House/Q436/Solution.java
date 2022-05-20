package In.House.Q436;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[] result = new int[len];
        int[][] starts = new int[len][2];
        for (int i = 0; i < len; ++i) {
            starts[i][0] = intervals[i][0];
            starts[i][1] = i;
        }
        Arrays.sort(starts, Comparator.comparingInt(start -> start[0]));
        for (int i = 0; i < len; ++i) {
            int left = 0, right = len - 1;
            int tmp = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (starts[mid][0] >= intervals[i][1]) {
                    tmp = starts[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        Arrays.stream(slt.findRightInterval(new int[][] {{1, 2}})).forEach(a -> System.out.print(a + " "));
//        System.out.println(); // [-1]
//        Arrays.stream(slt.findRightInterval(new int[][] {{3, 4}, {2, 3}, {1, 2}})).forEach(a -> System.out.print(a + " "));
//        System.out.println(); // [-1, 0, 1]
//        Arrays.stream(slt.findRightInterval(new int[][] {{1, 4}, {2, 3}, {3, 4}})).forEach(a -> System.out.print(a + " "));
//        System.out.println(); // [-1, 2, -1]
        Arrays.stream(slt.findRightInterval(new int[][] {{1, 1}, {3, 4}})).forEach(a -> System.out.print(a + " "));
        System.out.println(); // [0, -1] // 自己可以使自己的右侧区间呗？
    }

}
