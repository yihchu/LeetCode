package In.House.Q539;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int findMinDifference(List<String> timePoints) {
        int[] minutes = timePoints.stream().map(t -> calc(t)).mapToInt(m -> m).toArray();
        Arrays.sort(minutes);
        int min = Integer.MAX_VALUE, len = minutes.length;
        for (int i = 0; i < len; ++i) {
            if (i == 0) {
                min = minutes[0] + 1440 - minutes[len - 1];
                continue;
            }
            min = Math.min(min, minutes[i] - minutes[i - 1]);
            if (min == 0) {
                return 0;
            }
        }
        return min;
    }

    private int calc(String time) {
        String[] arr = time.split(":");
        return Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
    }

    private static List<String> toList(String[] array) {
        List<String> list = new ArrayList<>();
        for (String str: array) {
            list.add(str);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findMinDifference(toList(new String[] {"23:59", "00:01"}))); // 2
        System.out.println(slt.findMinDifference(toList(new String[] {"23:59", "00:00"}))); // 1
        System.out.println(slt.findMinDifference(toList(new String[] {"00:00","23:59","00:00"}))); // 0
    }

}

/**
Ques: 最小时间差
Link: https://leetcode-cn.com/problems/minimum-time-difference/

给定一个24小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

示例1：
输入：timePoints = ["23:59", "00:00"]
输出：1

示例2：
输入：timePoints = ["00:00", "23:59", "00:00"]
输出：0

提示：
2 <= timePoints <= 2 * 10*4
timePoints[i]格式为"HH:MM"

*/
