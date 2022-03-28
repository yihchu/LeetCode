package In.House.Q1846;

import java.util.Arrays;

public class Solution {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return len == 1 ? 1 : 0;
        }
        Arrays.sort(arr);
        if (arr[0] != 1) {
            arr[0] = 1;
        }
        for (int i = 1; i < len; ++i) {
            if (arr[i] - arr[i - 1] <= 1) {
                continue;
            }
            arr[i] = arr[i - 1] + 1;
        }
        return arr[len - 1];
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1})); // 2
        System.out.println(slt.maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000})); // 3
        System.out.println(slt.maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5})); // 5
        System.out.println(slt.maximumElementAfterDecrementingAndRearranging(new int[]{73, 98, 9})); // 3
        System.out.println(slt.maximumElementAfterDecrementingAndRearranging(new int[]{
                209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209, 209
                , 209, 209, 209, 209, 209, 209, 209, 209, 209}));
    }

}
