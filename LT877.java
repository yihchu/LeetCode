

public class LT877 {

    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] m = new int[len][len];
        for (int i = len - 1; i > -1; --i) {
            for (int j = i ; j < len; ++j) {
                m[i][j] = i == j ? piles[i] : Math.max(piles[i] - m[i + 1][j], piles[j] - m[i][j - 1]);
            }
        }
        return m[0][len - 1] > 0;
    }

//    public boolean stoneGame(int[] piles) {
//        return true
//    }

    public static void main(String[] args) {
        LT877 lt877 = new LT877();
        System.out.println(lt877.stoneGame(new int[]{5, 3, 4, 5})); // true
        System.out.println(lt877.stoneGame(new int[]{8, 9, 7, 6, 7, 6})); // true
        System.out.println(lt877.stoneGame(new int[]{6, 7, 6, 7, 9, 8})); // true
        System.out.println(lt877.stoneGame(new int[]{6, 3, 9, 9, 3, 8, 8, 7})); // true
    }

}

/**
Link: https://leetcode-cn.com/problems/stone-game/

亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子piles[i]。
游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回true，当李赢得比赛时返回false。

示例：
输入：[5, 3, 4, 5]
输出：true
解释：
亚历克斯先开始，只能拿前5颗或后5颗石子。
假设他取了前5颗，这一行就变成了[3, 4, 5]。
如果李拿走前3颗，那么剩下的是[4, 5]，亚历克斯拿走后5颗赢得10分。
如果李拿走后5颗，那么剩下的是[3, 4]，亚历克斯拿走后4颗赢得9分。
这表明，取前5颗石子对亚历克斯来说是一个胜利的举动，所以我们返回true。

提示：
2 <= piles.length <= 500
piles.length是偶数。
1 <= piles[i] <= 500
sum(piles)是奇数。

*/