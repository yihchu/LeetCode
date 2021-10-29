package In.House.Q517;

public class Solution {

//    // 思路1
//    public int findMinMoves(int[] machines) {
//        int sum = Arrays.stream(machines).sum();
//        int len = machines.length;
//        if (sum % len != 0) {
//            return -1;
//        }
//        int avg = sum / len;
//        machines[0] -= avg;
//        int result = Math.abs(machines[0]);
//        for (int i = 1; i < len; ++i) {
//            machines[i] -= avg;
//            result = Math.max(result, machines[i] >= 0 ? machines[i] : -machines[i] / 2 + 1);
//            machines[i] += machines[i - 1];
//            result = Math.max(result, Math.abs(machines[i]));
//        }
//        return result;
//    }

    // 思路2
    public int findMinMoves(int[] machines) {
        int len = machines.length;
        int[] sums = new int[len + 1];
        for (int i = 0; i < len; ++i) {
            sums[i + 1] = sums[i] + machines[i];
        }
        if (sums[len] % len != 0) {
            return -1;
        }
        int avg = sums[len] / len;
        int result = 0;
        for (int i = 0; i < len; ++i) {
            int l = i * avg - sums[i], r = (len - i - 1) * avg - (sums[len] - sums[i] - machines[i]);
            if (l > 0 && r > 0) {
                result = Math.max(result, l + r);
            } else {
                result = Math.max(result, Math.max(Math.abs(l), Math.abs(r)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findMinMoves(new int[] {1, 0, 5})); // 3
        System.out.println(slt.findMinMoves(new int[] {0, 3, 0})); // 2
        System.out.println(slt.findMinMoves(new int[] {0, 2, 0})); // -1
        System.out.println(slt.findMinMoves(new int[] {9, 1, 8, 8, 9})); // 4
    }

}

/**
 * 思路1 (Link: https://blog.csdn.net/qq_32805671/article/details/102610391)
 *
 * 数学题：有四个洗衣机，装的衣服数为[0, 0, 11, 5]，最终的状态会变为[4, 4, 4, 4]，那么我们将二者做差，得到[-4, -4, 7, 1]。
 * 这里负数表示当前洗衣机还需要的衣服数，正数表示当前洗衣机多余的衣服数。
 * 我们要做的是要将这个差值数组每一项都变为0，对于第一个洗衣机来说，需要四件衣服可以从第二个洗衣机获得，那么就可以把-4移给二号洗衣机。
 * 那么差值数组变为[0, -8, 7, 1]，此时二号洗衣机需要八件衣服，那么至少需要移动8次。
 * 然后二号洗衣机把这八件衣服从三号洗衣机处获得，那么差值数组变为[0, 0, -1, 1]。
 * 此时三号洗衣机还缺1件，就从四号洗衣机处获得，此时差值数组成功变为了[0, 0, 0, 0]，成功。
 * 那么移动的最大次数就是差值数组中出现的绝对值最大的数字，8次
 *
 * 理解：
 * a. 对于减去avg得到的新数组，如果是正的，假设为k，那么他需要一个一个的向左/右移动，只能一个一个进行，所以至少需要k步；
 * 而如果是负的，如-k,可以由两边的洗衣机同时把衣服送过来（我也不知道这么想对不对），所以可能只需要-k步就可以完成。
 * 所以对于这个数组，不需要经过Math.abs()处理。
 * b. 对于从左往右的转移过程得到的新数组，因为左侧已经达到了平衡状态，所以不论正负，都只能从右侧一个一个的进行移动。所以，正负的步骤是一样的，需要取绝对值。
 *
 */

/**
 * 思路2 (Link: https://www.136.la/nginx/show-23225.html)
 *
 * 由于每一步可以任选某些数字对它们进行转移，所以实际上是在求最优解中的最复杂转移数。
 * 那么我们考虑，到底哪一个位置要经过的流量最大呢？
 * 枚举每个位置，考虑它左边的整体需求和右边的整体需求，如果两边都需要流入，则流量相加；
 * 如果一边需要流入，一边需要流出，则取绝对值的最大值。
 *
 * 这个思路似乎更容易理解点
 */

/**
Link: https://leetcode-cn.com/problems/super-washing-machines/

假设有n台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
在每一步操作中，你可以选择任意m(1 <= m <= n)台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
给定一个整数数组machines代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的最少的操作步数。如果不能使每台洗衣机中衣物的数量相等，则返回-1。

示例1：
输入：machines = [1, 0, 5]
输出：3
解释：
第一步:    1     0 <-- 5    =>    1     1     4
第二步:    1 <-- 1 <-- 4    =>    2     1     3
第三步:    2     1 <-- 3    =>    2     2     2

示例2：
输入：machines = [0, 3, 0]
输出：2
解释：
第一步:    0 <-- 3     0    =>    1     2     0
第二步:    1     2 --> 0    =>    1     1     1

示例3：
输入：machines = [0, 2, 0]
输出：-1
解释：
不可能让所有三个洗衣机同时剩下相同数量的衣物。

提示：
n == machines.length
1 <= n <= 10^4
0 <= machines[i] <= 10^5
*/