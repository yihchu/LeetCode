package In.House.Q292;

public class Solution {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.canWinNim(4)); // false
        System.out.println(slt.canWinNim(1)); // true
        System.out.println(slt.canWinNim(2)); // true

    }

}
/*
a 1 2 3 5 6 7
b 4 8
 */

/**
Link: https://leetcode-cn.com/problems/nim-game

你和你的朋友，两个人一起玩Nim游戏：
桌子上有一堆石头。
你们轮流进行自己的回合，你作为先手。
每一回合，轮到的人拿掉1 - 3块石头。
拿掉最后一块石头的人就是获胜者。
假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为n的情况下赢得游戏。如果可以赢，返回true；否则，返回false 。

示例1：
输入：n = 4
输出：false
解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
因为无论你拿走1块、2块还是3块石头，最后一块石头总是会被你的朋友拿走。

示例2：
输入：n = 1
输出：true

示例3：
输入：n = 2
输出：true

提示：
1 <= n <= 2^31 - 1

*/