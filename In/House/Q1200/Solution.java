package In.House.Q1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length, diff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len - 1; ++i) {
            int tmp = Math.abs(arr[i + 1] - arr[i]);
            if (tmp > diff) {
                continue;
            }
            if (tmp < diff) {
                diff = tmp;
                result.clear();
            }
            result.add(List.of(arr[i], arr[i + 1]));
        }
        return result;
    }

//    private static void print(List<List<Integer>> lists) {
//        System.out.print('[');
//        int len = lists.size();
//        for (int i = 0; i < len - 1; ++i) {
//            System.out.print('[' + lists.get(i).get(0) + ',' + ' ' + lists.get(i).get(1) + ']' + ',' + ' ');
//        }
//        System.out.print('[' + lists.get(len - 1).get(0) + ',' + ' ' + lists.get(len - 1).get(1) + ']');
//        System.out.println(']');
//    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.minimumAbsDifference(new int[] {4, 2, 1, 3});
        slt.minimumAbsDifference(new int[] {1, 3, 6, 10, 15});
        slt.minimumAbsDifference(new int[] {3, 8, -10, 23, 19, -4, -14, 27});
    }

}
