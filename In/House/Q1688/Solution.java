package In.House.Q1688;

public class Solution {

    public int numberOfMatches(int n) {
        int sum = 0;
        while (n > 1) {
            boolean even = n % 2 == 0;
            sum += even ? n / 2 : (n - 1) / 2;
            n = even ? n / 2 : n / 2 + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numberOfMatches(7)); // 6
        System.out.println(slt.numberOfMatches(14)); // 13
    }

}

/**
Link: https://leetcode-cn.com/problems/count-of-matches-in-tournament/
Ques: 比赛中的配对次数

给你一个整数n，表示比赛中的队伍数。比赛遵循一种独特的赛制：
如果当前队伍数是偶数，那么每支队伍都会与另一支队伍配对。总共进行n / 2场比赛，且产生n / 2支队伍进入下一轮。
如果当前队伍数为奇数 ，那么将会随机轮空并晋级一支队伍，其余的队伍配对。总共进行(n - 1) / 2场比赛，且产生(n - 1) / 2 + 1支队伍进入下一轮。
返回在比赛中进行的配对次数，直到决出获胜队伍为止。

示例1：
输入：n = 7
输出：6
解释：比赛详情：
- 第1轮：队伍数 = 7，配对次数 = 3，4支队伍晋级。
- 第2轮：队伍数 = 4，配对次数 = 2，2支队伍晋级。
- 第3轮：队伍数 = 2，配对次数 = 1，决出1支获胜队伍。
总配对次数 = 3 + 2 + 1 = 6

示例2：
输入：n = 14
输出：13
解释：比赛详情：
- 第1轮：队伍数 = 14，配对次数 = 7，7支队伍晋级。
- 第2轮：队伍数 = 7，配对次数 = 3，4支队伍晋级。
- 第3轮：队伍数 = 4，配对次数 = 2，2支队伍晋级。
- 第4轮：队伍数 = 2，配对次数 = 1，决出1支获胜队伍。
总配对次数 = 7 + 3 + 2 + 1 = 13

提示：
1 <= n <= 200

*/