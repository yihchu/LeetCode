<h1>祖玛游戏</h1>

你正在参与祖玛游戏的一个变种。</br>
在这个祖玛游戏变体中，桌面上有一排彩球，每个球的颜色可能是：红色'R'、黄色'Y'、蓝色'B'、绿色'G' 或白色'W'。你的手中也有一些彩球。</br>
你的目标是清空桌面上所有的球。每一回合：</br>
从你手上的彩球中选出任意一颗，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。</br>
接着，如果有出现三个或者三个以上且颜色相同的球相连的话，就把它们移除掉。</br>
如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。</br>
如果桌面上所有球都被移除，则认为你赢得本场游戏。</br>
重复这个过程，直到你赢了游戏或者手中没有更多的球。</br>
给你一个字符串board，表示桌面上最开始的那排球。另给你一个字符串hand，表示手里的彩球。请你按上述操作步骤移除掉桌上所有球，计算并返回所需的最少球数。如果不能移除桌上所有的球，返回-1。</br>

示例1：</br>
输入：board = "WRRBBW", hand = "RB"</br>
输出：-1</br>
解释：无法移除桌面上的所有球。可以得到的最好局面是：</br>
- 插入一个'R'，使桌面变为WRRRBBW。WRRRBBW -> WBBW</br>
- 插入一个'B'，使桌面变为WBBBW。WBBBW -> WW</br>
  桌面上还剩着球，没有其他球可以插入。</br>

示例2：</br>
输入：board = "WWRRBBWW", hand = "WRBRW"</br>
输出：2</br>
解释：要想清空桌面上的球，可以按下述步骤：</br>
- 插入一个'R'，使桌面变为WWRRRBBWW。WWRRRBBWW -> WWBBWW</br>
- 插入一个'B'，使桌面变为WWBBBWW。WWBBBWW -> WWWW -> empty</br>
  只需从手中出2个球就可以清空桌面。</br>

示例3：</br>
输入：board = "G", hand = "GGGGG"</br>
输出：2</br>
解释：要想清空桌面上的球，可以按下述步骤：</br>
- 插入一个'G'，使桌面变为GG 。</br>
- 插入一个'G'，使桌面变为GGG。GGG -> empty</br>
  只需从手中出2个球就可以清空桌面。</br>

示例4：</br>
输入：board = "RBYYBBRRB", hand = "YRBGB"</br>
输出：3</br>
解释：要想清空桌面上的球，可以按下述步骤：</br>
- 插入一个'Y'，使桌面变为RBYYYBBRRB。RBYYYBBRRB -> RBBBRRB -> RRRB -> B</br>
- 插入一个'B'，使桌面变为BB。</br>
- 插入一个'B'，使桌面变为BBB。BBB -> empty</br>
  只需从手中出3个球就可以清空桌面。</br>

提示：
- 1 <= board.length <= 16
- 1 <= hand.length <= 5
- board和hand由字符'R'、'Y'、'B'、'G'和'W'组成
- 桌面上一开始的球中，不会有三个及三个以上颜色相同且连着的球

[Link](https://leetcode-cn.com/problems/zuma-game/)
