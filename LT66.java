import java.util.Arrays;
import java.util.Stack;

public class LT66 {

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
        LT66 lt66 = new LT66();
        Arrays.stream(lt66.plusOne(new int[] {1, 2, 3})).forEach(a -> System.out.print(a + " ")); // 1, 2, 4
        System.out.println();
        Arrays.stream(lt66.plusOne(new int[] {4, 3, 2, 1})).forEach(a -> System.out.print(a + " ")); // 4, 3, 2, 2
        System.out.println();
        Arrays.stream(lt66.plusOne(new int[] {0})).forEach(a -> System.out.print(a + " ")); // 1
        System.out.println();
    }

}

/**
Link: https://leetcode-cn.com/problems/plus-one/

给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位，数组中每个元素只存储单个数字。
你可以假设除了整数0之外，这个整数不会以零开头。

示例1：
输入：digits = [1, 2, 3]
输出：[1, 2, 4]
解释：输入数组表示数字123。

示例2：
输入：digits = [4, 3, 2, 1]
输出：[4, 3, 2, 2]
解释：输入数组表示数字4321。

示例3：
输入：digits = [0]
输出：[1]

提示：
1 <= digits.length <= 100
0 <= digits[i] <= 9

*/