package In.House.Q66;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int len = digits.length;
        boolean flag = true;
        for (int i = len - 1; i >= 0; --i) {
            if (flag) {
                if (digits[i] == 9) {
                    stack.add(0);
                } else {
                    stack.add(digits[i] + 1);
                    flag = false;
                }
            } else {
                stack.add(digits[i]);
            }
        }
        if (flag) {
            stack.add(1);
        }
        int[] result = new int[stack.size()];
        int idx = 0;
        while (!stack.isEmpty()) {
            result[idx ++] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.plusOne(new int[] {1, 2, 3})).forEach(a -> System.out.print(a + " ")); // 1, 2, 4
        System.out.println();
        Arrays.stream(slt.plusOne(new int[] {4, 3, 2, 1})).forEach(a -> System.out.print(a + " ")); // 4, 3, 2, 2
        System.out.println();
        Arrays.stream(slt.plusOne(new int[] {0})).forEach(a -> System.out.print(a + " ")); // 1
        System.out.println();
    }

}

