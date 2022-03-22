package In.House.Q2038;

public class Solution {

    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0, len = colors.length();
        char cur = colors.charAt(0);
        int count = 1;
        for (int i = 1; i < len; ++i) {
            char tmp = colors.charAt(i);
            if (tmp != cur) {
                cur = tmp;
                count = 1;
            } else {
                ++ count;
                if (count < 3) {
                    continue;
                }
                if (cur == 'A')  {
                    ++ alice;
                } else {
                    ++ bob;
                }
            }
        }
        return alice > bob;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.winnerOfGame("AAABABB")); // true
        System.out.println(slt.winnerOfGame("AA")); // false
        System.out.println(slt.winnerOfGame("ABBBBBBBAAA")); // false
    }

}

/**
Ques: 如果相邻两个颜色均相同则删除当前颜色
Link: https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/

总共有n个颜色片段排成一列，每个颜色片段要么是'A'要么是'B'。给你一个长度为n的字符串colors，其中colors[i]表示第i个颜色片段的颜色。
Alice和Bob在玩一个游戏，他们轮流从这个字符串中删除颜色。Alice先手。
如果一个颜色片段为'A'且相邻两个颜色都是颜色'A'，那么Alice可以删除该颜色片段。Alice不可以删除任何颜色'B'片段。
如果一个颜色片段为'B'且相邻两个颜色都是颜色'B'，那么Bob可以删除该颜色片段。Bob不可以删除任何颜色'A'片段。
Alice和Bob不能从字符串两端删除颜色片段。
如果其中一人无法继续操作，则该玩家输掉游戏且另一玩家获胜。
假设Alice和Bob都采用最优策略，如果Alice获胜，请返回true，否则Bob获胜，返回false。

示例1：
输入：colors = "AAABABB"
输出：true
解释：
AAABABB -> AABABB
Alice先操作。
她删除从左数第二个'A'，这也是唯一一个相邻颜色片段都是'A'的'A'。
现在轮到Bob操作。
Bob无法执行任何操作，因为没有相邻位置都是'B'的颜色片段'B'。
因此，Alice获胜，返回true。

示例2：
输入：colors = "AA"
输出：false
解释：
Alice 先操作。
只有2个'A'且它们都在字符串的两端，所以她无法执行任何操作。
因此，Bob获胜，返回false。

示例3：
输入：colors = "ABBBBBBBAAA"
输出：false
解释：
ABBBBBBBAAA -> ABBBBBBBAA
Alice先操作。
她唯一的选择是删除从右数起第二个'A'。
ABBBBBBBAA -> ABBBBBBAA
接下来轮到Bob操作。
他有许多选择，他可以选择任何一个'B'删除。
然后轮到Alice操作，她无法删除任何片段。
所以Bob获胜，返回false。

提示：
1 <= colors.length <= 10^5
colors只包含字母'A'和'B'

*/