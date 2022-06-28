package In.House.Q324;

import java.util.Arrays;

public class Solution {

    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        int[] arr1 = new int[] {1, 5, 1, 1, 6, 4};
        slt.wiggleSort(arr1);
        Arrays.stream(arr1).forEach(a -> System.out.print(a + " "));
        System.out.println();
        int[] arr2 = new int[] {1, 3, 2, 2, 3, 1};
        slt.wiggleSort(arr2);
        Arrays.stream(arr2).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}
