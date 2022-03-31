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


