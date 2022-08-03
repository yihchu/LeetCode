<h1>如果相邻两个颜色均相同则删除当前颜色</h1>

总共有n个颜色片段排成一列，每个颜色片段要么是'A'要么是'B'。给你一个长度为n的字符串colors，其中colors[i]表示第i个颜色片段的颜色。</br>
Alice和Bob在玩一个游戏，他们轮流从这个字符串中删除颜色。Alice先手。</br>
如果一个颜色片段为'A'且相邻两个颜色都是颜色'A'，那么Alice可以删除该颜色片段。Alice不可以删除任何颜色'B'片段。</br>
如果一个颜色片段为'B'且相邻两个颜色都是颜色'B'，那么Bob可以删除该颜色片段。Bob不可以删除任何颜色'A'片段。</br>
Alice和Bob不能从字符串两端删除颜色片段。</br>
如果其中一人无法继续操作，则该玩家输掉游戏且另一玩家获胜。</br>
假设Alice和Bob都采用最优策略，如果Alice获胜，请返回true，否则Bob获胜，返回false。</br>

示例1：</br>
输入：colors = "AAABABB"</br>
输出：true</br>
解释：</br>
AAABABB -> AABABB</br>
Alice先操作。</br>
她删除从左数第二个'A'，这也是唯一一个相邻颜色片段都是'A'的'A'。</br>
现在轮到Bob操作。</br>
Bob无法执行任何操作，因为没有相邻位置都是'B'的颜色片段'B'。</br>
因此，Alice获胜，返回true。</br>

示例2：</br>
输入：colors = "AA"</br>
输出：false</br>
解释：</br>
Alice先操作。</br>
只有2个'A'且它们都在字符串的两端，所以她无法执行任何操作。</br>
因此，Bob获胜，返回false。</br>

示例3：</br>
输入：colors = "ABBBBBBBAAA"</br>
输出：false</br>
解释：</br>
ABBBBBBBAAA -> ABBBBBBBAA</br>
Alice先操作。</br>
她唯一的选择是删除从右数起第二个'A'。</br>
ABBBBBBBAA -> ABBBBBBAA</br>
接下来轮到Bob操作。</br>
他有许多选择，他可以选择任何一个'B'删除。</br>
然后轮到Alice操作，她无法删除任何片段。</br>
所以Bob获胜，返回false。</br>

提示：
- 1 <= colors.length <= 10^5
- colors只包含字母'A'和'B'

[Link](https://leetcode-cn.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/)