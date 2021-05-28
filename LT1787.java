import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LT1787 {

    public int minChanges(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[1024];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for (int i = 0; i < k; ++i) {
            int[] tmp = new int[1024];
            int size = 0;
            Map<Integer, Integer> h = new HashMap<>();
            for (int j = i; j < len; j += k) {
                ++size;
                h.compute(nums[j], (key, val) -> Objects.isNull(val) ? 1 : ++val);
            }

            Arrays.fill(tmp, Arrays.stream(result).min().getAsInt());
            for (int j = 0; j < 1024; ++j) {
                for (Map.Entry<Integer, Integer> entry: h.entrySet()) {
                    int x = entry.getKey(), count = entry.getValue();
                    int t = result[j ^ x] - count;
                    tmp[j] = tmp[j] > t ? t : tmp[j];
                }
            }

            for (int j = 0; j < 1024; ++j) {
                tmp[j] += size;
            }
            result = tmp;
        }
        return result[0];
    }

    public static void main(String[] args) {
        /*
        1 <= k <= nums.length <= 2000
        0 <= nums[i] < 2^10
        */
        LT1787 lt1787 = new LT1787();
        System.out.println(lt1787.minChanges(new int[]{1, 2, 0, 3, 0}, 1)); // 3 [0,0,0,0,0]
        System.out.println(lt1787.minChanges(new int[]{3, 4, 5, 2, 1, 7, 3, 4, 7}, 3)); // 3 [3,4,7,3,4,7,3,4,7]
        System.out.println(lt1787.minChanges(new int[]{1, 2, 4, 1, 2, 5, 1, 2, 6}, 3)); // 3 [1,2,3,1,2,3,1,2,3]
        System.out.println(lt1787.minChanges(new int[]{26, 19, 19, 28, 13, 14, 6, 25, 28, 19, 0, 15, 25, 11}, 3)); // 11

        int[] arr = new int[2000];
        Arrays.fill(arr, 1);
        System.out.println(lt1787.minChanges(arr, 1)); // 2000

    }

}


/*
给你一个整数数组 nums 和一个整数 k 。区间 [left, right]（left <= right）的 异或结果 是对下标位于left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。

返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。

f(i, j) = size + min(f(i - 1, j), f(i - 1, j^x) - countx)

示例 1：

输入：nums = [1,2,0,3,0], k = 1
输出：3
解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
示例 2：

输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
输出：3
解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
示例 3：

输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
输出：3
解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]

提示：

1 <= k <= nums.length <= 2000
0 <= nums[i] < 2^10
 */