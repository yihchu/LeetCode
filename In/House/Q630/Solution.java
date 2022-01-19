package In.House.Q630;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    // CV大法
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparing(c -> c[1]));
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparing(c -> -c));
        int sum = 0;
        for (int[] arr: courses) {
            sum += arr[0];
            q.add(arr[0]);
            if (sum > arr[1]) {
                sum -= q.poll();
            }
        }
        return q.size();
    }

//    // 尝试使用类01背包问题来求解
//    // 但是似乎不行，加入背包的条件没有找到方法准确描述
//    public int scheduleCourse(int[][] courses) {
//        int len = courses.length;
//        Arrays.sort(courses, Comparator.comparingInt(c -> c[0]));
//        int max = Arrays.stream(courses).max(Comparator.comparing(c -> c[1])).get()[1];
//        int limit = 0;
//        int[][] map = new int[len][max + 1];
//        for (int j = 0; j <= max; ++j) {
//            map[0][j] = courses[0][0] <= j && courses[0][0] <= courses[0][1] ? 1 : 0;
//            limit = courses[0][1] > limit ? courses[0][1] : limit;
//        }
//        for (int i = 1; i < len; ++i) {
//            limit = courses[i][1] > limit ? courses[i][1] : limit;
//            for (int j = 0; j <= max; ++j) {
//                int c = Math.min(j, limit);
//                if (c - courses[i][0] < 0) {
//                    map[i][j] = map[i - 1][j];
//                    continue;
//                }
//                map[i][j] = Math.max(1 + map[i - 1][c - courses[i][0]], map[i - 1][j]);
//            }
//        }
//        return map[len - 1][max];
//    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        System.out.println(slt.scheduleCourse(new int[][] { {100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200} } )); // 3
//        System.out.println(slt.scheduleCourse(new int[][] { {1, 2} } )); // 1
//        System.out.println(slt.scheduleCourse(new int[][] { {3, 2}, {4, 3} } )); // 0
        System.out.println(slt.scheduleCourse(new int[][] { {5, 6}, {4, 1}, {1, 1} } )); // 0
//        System.out.println(slt.scheduleCourse(new int[][] { {1, 2}, {2, 3} } )); // 2
//        System.out.println(slt.scheduleCourse(new int[][] { {7, 16}, {2, 3}, {3, 12}, {3, 14}, {10, 19}, {10, 16}, {6, 8}, {6, 11}, {3, 13}, {6, 16} } )); // 4
//        System.out.println(slt.scheduleCourse(new int[][] { {5, 5}, {4, 6}, {2, 6} } )); // 2
//        System.out.println(slt.scheduleCourse(new int[][] { {5, 15}, {3, 19}, {6, 7}, {2, 10}, {5, 16}, {8, 14}, {10, 11}, {2, 19} } )); // 5
//        System.out.println(slt.scheduleCourse(new int[][] { {7, 11}, {1, 11}, {1, 3}, {2, 6}, {5, 6}, {7, 7}, {4, 8}, {2, 20}, {1, 17}, {8, 11} } )); // 6
    }

}

/**
Ques: https://leetcode-cn.com/problems/course-schedule-iii/
Link: https://leetcode-cn.com/problems/course-schedule-iii/

这里有n门不同的在线课程，按从1到n编号。给你一个数组courses，其中courses[i] = [duration[i], lastDay[i]]表示第i门课将会持续上duration[i]天课，并且必须在不晚于lastDay[i]的时候完成。
你的学期从第1天开始。且不能同时修读两门及两门以上的课程。
返回你最多可以修读的课程数目。

示例1：
输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
输出：3
解释：
这里一共有4门课程，但是你最多可以修3门：
首先，修第1门课，耗费100天，在第100天完成，在第101天开始下门课。
第二，修第3门课，耗费1000天，在第1100天完成，在第1101天开始下门课程。
第三，修第2门课，耗时200天，在第1300天完成。
第4门课现在不能修，因为将会在第3300天完成它，这已经超出了关闭日期。

示例2：
输入：courses = [[1, 2]]
输出：1

示例3：
输入：courses = [[3, 2], [4, 3]]
输出：0

提示:
1 <= courses.length <= 10^4
1 <= duration[i], lastDay[i] <= 10^4

*/