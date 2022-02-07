package In.House.Q15;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

//    // 超时
//    public List<List<Integer>> threeSum(int[] nums) {
//        int len = nums.length;
//        Set<List<Integer>> set = new HashSet<>();
//        for (int i = 0; i < len - 2; ++i) {
//            for (int j = i + 1; j < len - 1; ++j) {
//                for (int k = j + 1; k < len; ++k) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> tmp = new ArrayList<>();
//                        tmp.add(nums[i]);
//                        tmp.add(nums[j]);
//                        tmp.add(nums[k]);
//                        Collections.sort(tmp);
//                        set.add(tmp);
//                    }
//                }
//            }
//        }
//        return set.stream().collect(Collectors.toList());
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < len - 2; ++i) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = len - 1;
            while (l < r) {
                int s = nums[l] + nums[r] + nums[i];
                if (s == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    list.add(tmp);
                    ++l;
                    --r;
                    while (l < r && nums[l] == nums[l - 1]) {
                        ++l;
                    }
                    while (l < r && nums[r] == nums[r + 1]) {
                        --r;
                    }
                    continue;
                }
                if (s < 0) {
                    ++l;
                } else {
                    --r;
                }
            }
        }
        return list;
    }

    private static void print(List<List<Integer>> list) {
        System.out.println(">>>>>>>>>> START");
        for (List<Integer> l: list) {
            for(int k: l) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
        System.out.println(">>>>>>>>>> END");
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        print(slt.threeSum(new int[] {-1, 0, 1, 2, -1, -4})); // [[-1, -1, 2], [-1, 0, 1]]
//        print(slt.threeSum(new int[] { })); // []
//        print(slt.threeSum(new int[] {0})); // []
    }

}


/**
Ques: 三数之和
Link: https://leetcode-cn.com/problems/3sum/

给你一个包含n个整数的数组nums，判断nums中是否存在三个元素a，b，c，使得a + b + c = 0 ？请你找出所有和为 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例1：
输入：nums = [-1, 0, 1, 2, -1, -4]
输出：[[-1, -1, 2], [-1, 0, 1]]

示例2：
输入：nums = []
输出：[]

示例3：
输入：nums = [0]
输出：[]

提示：
0 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5

*/
