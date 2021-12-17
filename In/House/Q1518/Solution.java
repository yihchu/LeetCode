package In.House.Q1518;

public class Solution {

    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles, left = numBottles;
        while (left >= numExchange) {
            int tmp = left / numExchange;
            result += tmp;
            left = left % numExchange + tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numWaterBottles(9, 3)); // 13
        System.out.println(slt.numWaterBottles(15, 4)); // 19
        System.out.println(slt.numWaterBottles(5, 5)); // 6
        System.out.println(slt.numWaterBottles(2, 3)); // 2
    }
}

/**
Link: https://leetcode-cn.com/problems/water-bottles/

小区便利店正在促销，用numExchange个空酒瓶可以兑换一瓶新酒。你购入了numBottles瓶酒。
如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
请你计算最多能喝到多少瓶酒。

示例1(图1.png)：
输入：numBottles = 9, numExchange = 3
输出：13
解释：你可以用3个空酒瓶兑换1瓶酒。
所以最多能喝到9 + 3 + 1 = 13瓶酒。

示例2(图2.png)：
输入：numBottles = 15, numExchange = 4
输出：19
解释：你可以用4个空酒瓶兑换1瓶酒。
所以最多能喝到15 + 3 + 1 = 19瓶酒。

示例3：
输入：numBottles = 5, numExchange = 5
输出：6

示例4：
输入：numBottles = 2, numExchange = 3
输出：2

提示：
1 <=numBottles <= 100
2 <=numExchange <= 100

*/
