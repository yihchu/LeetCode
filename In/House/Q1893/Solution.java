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
