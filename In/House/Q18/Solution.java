package In.House.Q18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                int l = j + 1, r = len - 1;
                int sum = nums[i] + nums[j];
                while (l < r) {
                    int tmp = sum + nums[l] + nums[r];
                    if (tmp < target) {
                        ++l;
                    } else if (tmp > target) {
                        --r;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            ++l;
                        }
                        ++l;
                        while (l < r && nums[r] == nums[r - 1]) {
                            --r;
                        }
                        --r;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0)); // [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
        System.out.println(slt.fourSum(new int[] {2, 2, 2, 2, 2}, 8)); // [[2, 2, 2, 2]]
    }

}

/**
Ques: 四数之和
Link: https://leetcode-cn.com/problems/4sum/

给你一个由n个整数组成的数组nums，和一个目标值target。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）：
0 <= a, b, c, d < n
a、b、c和d互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按任意顺序返回答案。

示例1：
输入：nums = [1, 0, -1, 0, -2, 2], target = 0
输出：[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, s, 1]]

示例2：
输入：nums = [2, 2, 2, 2, 2], target = 8
输出：[[2, 2, 2, 2]]

提示：
1 <= nums.length <= 200
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
*/