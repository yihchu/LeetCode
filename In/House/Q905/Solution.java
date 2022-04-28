package In.House.Q905;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[] sortArrayByParity(int[] nums) {
        return Arrays.stream(nums).boxed()
                .sorted(Comparator.comparingInt(a -> a % 2))
                .mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.sortArrayByParity(new int[] {3, 1, 2, 4})).forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.sortArrayByParity(new int[] {0})).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}
