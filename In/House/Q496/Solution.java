package In.House.Q496;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums2.length;
//        // 原解法
//        for (int i = 0; i < len - 1; ++i) {
//            for (int j = i + 1; j < len; ++j) {
//                if (nums2[i] < nums2[j]) {
//                    map.put(nums2[i], nums2[j]);
//                    break;
//                }
//            }
//        }
        // 官方题解中，是使用了"单调栈"来处理nums2，负责度O(nums2.length)
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i > -1; --i) {
            if (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                    stack.pop();
                }
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.add(nums2[i]);
        }
        //
        len = nums1.length;
        int[] result = new int[len];
        for (int i = 0; i < len; ++i) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2}))
                .forEach(a -> System.out.print(a + " ")); // [-1, 3, -1]
        System.out.println();
        Arrays.stream(slt.nextGreaterElement(new int[] {2, 4}, new int[] {1, 2, 3, 4}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(slt.nextGreaterElement(new int[] {2, 1, 3}, new int[] {2, 3, 1}))
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}

