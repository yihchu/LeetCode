package In.House.Q1089;

import java.util.Arrays;

public class Solution {

    public void duplicateZeros(int[] arr) {
        int len = arr.length, idx = 0;
        int[] tmp = Arrays.copyOf(arr, arr.length);
        for (int i = 0; idx < len; ++i) {
             arr[idx ++] = tmp[i];
             if (tmp[i] == 0 && idx < len) {
                 arr[idx ++] = tmp[i];
             }
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        int[] arr1 = new int[] {1, 0, 2, 3, 0, 4, 5, 0};
        slt.duplicateZeros(arr1);
        Arrays.stream(arr1).forEach(a -> System.out.print(a + " "));
        System.out.println();
        int[] arr2 = new int[] {1, 2, 3};
        slt.duplicateZeros(arr2);
        Arrays.stream(arr2).forEach(a -> System.out.print(a + " "));
        System.out.println();
        int[] arr3 = new int[] {0, 0, 0, 0, 0, 0, 0};
        slt.duplicateZeros(arr3);
        Arrays.stream(arr3).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}
