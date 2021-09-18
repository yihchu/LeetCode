import java.util.Arrays;

public class LT881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        int l = 0, r = len - 1, count = len;
        while (r > l) {
            if (people[l] + people[r] > limit) {
                --r;
                continue;
            }
            --count;
            ++l;
            --r;
        }
        return count;
    }

    public static void main(String[] args) {
        LT881 lt881 = new LT881();
        System.out.println(lt881.numRescueBoats(new int[]{1, 2}, 3)); // 1
        System.out.println(lt881.numRescueBoats(new int[]{3, 2, 2, 1}, 3)); // 3
        System.out.println(lt881.numRescueBoats(new int[]{3, 5, 3, 4}, 5)); // 4
    }

}

/**
Link: https://leetcode-cn.com/problems/boats-to-save-people/

第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
返回载到每一个人所需的最小船数。(保证每个人都能被船载)。

示例1：
输入：people = [1, 2], limit = 3
输出：1
解释：1艘船载(1, 2)

示例2：
输入：people = [3, 2, 2, 1], limit = 3
输出：3
解释：3艘船分别载(1, 2), (2)和(3)

示例3：
输入：people = [3, 5, 3, 4], limit = 5
输出：4
解释：4艘船分别载(3), (3), (4), (5)

提示：
1 <= people.length <= 50000
1 <= people[i] <= limit <= 30000

*/