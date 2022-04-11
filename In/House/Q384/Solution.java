package In.House.Q384;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    private int[] origin;

    public Solution(int[] nums) {
        this.origin = nums;
    }

    public int[] reset() {
        return this.origin;
    }

//    // 咱不知道这个为啥过不去第六个用例。
//    // 咱也不知道leetcode对于随机有什么偏好
//    public int[] shuffle() {
//        int len = this.origin.length;
//        int[] tmp = new int[len];
//        for (int i = 0; i < len; ++i) {
//            tmp[i] = this.origin[i];
//        }
//        Random random = new Random();
//        for (int i = 0; i < len / 2; ++i) {
//            int x = random.nextInt(len);
//            int y = random.nextInt(len);
//            int t = tmp[x];
//            tmp[x] = tmp[y];
//            tmp[y] = t;
//        }
//        return tmp;
//    }

    public int[] shuffle() {
        int len = this.origin.length;
        int[] tmp = Arrays.copyOf(this.origin, len);
        Random random = new Random();
        for (int i = 0; i < len; ++i) {
            int j = random.nextInt(len);
            int t = tmp[i];
            tmp[i] = tmp[j];
            tmp[j] = t;
        }
        return tmp;
    }

    private static void print(int[] array) {
        for (int a: array) {
            System.out.print(a + "");
        }
        System.out.println();
    }

    private static void test1() {
        Solution solution = new Solution(new int[] {1, 2, 3});
        print(solution.shuffle());    // 打乱数组[1, 2, 3]并返回结果。任何[1, 2, 3]的排列返回的概率应该相同。例如，返回[3, 1, 2]
        print(solution.reset());      // 重设数组到它的初始状态[1, 2, 3]。返回[1, 2, 3]
        print(solution.shuffle());    // 随机返回数组[1, 2, 3]打乱后的结果。例如，返回[1, 3, 2]
    }

    private static void test2() {
        Solution solution = new Solution(new int[] {});
        print(solution.shuffle());    // 打乱数组[1, 2, 3]并返回结果。任何[1, 2, 3]的排列返回的概率应该相同。例如，返回[3, 1, 2]
        print(solution.reset());      // 重设数组到它的初始状态[1, 2, 3]。返回[1, 2, 3]
        print(solution.shuffle());    // 随机返回数组[1, 2, 3]打乱后的结果。例如，返回[1, 3, 2]
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

