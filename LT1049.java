import java.util.Arrays;

public class LT1049 {

    public int lastStoneWeightII(int[] stones) {
        int len = stones.length;
        int sum = Arrays.stream(stones).sum();
        int weight = sum / 2;
        int[] m = new int[weight + 1];
        int[] n = new int[weight + 1];
        m[0] = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j <= weight; ++j) {
                if (j < stones[i]) {
                    n[j] = i > 0 ? m[j] : 0;
                } else {
                    n[j] = i > 0 ? Math.max(m[j], m[j - stones[i]] + stones[i]) : stones[i];
                }
            }
            int[] t = m;
            m = n;
            n = t;
        }
        return sum - 2 * m[weight];
    }

    public static void main(String[] args) {
        LT1049 lt1049 = new LT1049();
        System.out.println(lt1049.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1})); // 1
        System.out.println(lt1049.lastStoneWeightII(new int[]{31, 26, 33, 21, 40})); // 5
        System.out.println(lt1049.lastStoneWeightII(new int[]{1, 2})); // 1
    }
}


/*

有一堆石头，用整数数组stones表示。其中stones[i]表示第i块石头的重量。

每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x和y，且x <= y。那么粉碎的可能结果如下：

如果x == y，那么两块石头都会被完全粉碎；
如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。

示例 1：
输入：stones = [2,7,4,1,8,1]
输出：1
解释：
组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。

示例 2：
输入：stones = [31,26,33,21,40]
输出：5

示例 3：
输入：stones = [1,2]
输出：1

提示：
1 <= stones.length <= 30
1 <= stones[i] <= 100

*/