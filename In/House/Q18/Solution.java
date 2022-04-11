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

