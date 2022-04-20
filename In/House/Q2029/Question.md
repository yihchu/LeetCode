<h1>石子游戏IX</h1>

Alice和Bob再次设计了一款新的石子游戏。现有一行n个石子，每个石子都有一个关联的数字表示它的价值。给你一个整数数组stones，其中stones[i]是第i个石子的价值。</br>
Alice和Bob轮流进行自己的回合，Alice先手。每一回合，玩家需要从stones中移除任一石子。</br>

如果玩家移除石子后，导致所有已移除石子的价值总和可以被3整除，那么该玩家就输掉游戏。</br>
如果不满足上一条，且移除后没有任何剩余的石子，那么Bob将会直接获胜（即便是在Alice的回合）。</br>
假设两位玩家均采用最佳决策。如果Alice获胜，返回true；如果Bob获胜，返回false。</br>

示例1：</br>
输入：stones = [2, 1]</br>
输出：true</br>
解释：游戏进行如下：</br>
- 回合 1：Alice可以移除任意一个石子。</br>
- 回合 2：Bob移除剩下的石子。</br>
  已移除的石子的值总和为1 + 2 = 3且可以被3整除。因此，Bob输，Alice获胜。</br>

示例2：</br>
输入：stones = [2]</br>
输出：false</br>
解释：Alice会移除唯一一个石子，已移除石子的值总和为2。</br>
由于所有石子都已移除，且值总和无法被3整除，Bob获胜。</br>

示例3：</br>
输入：stones = [5, 1, 2, 4, 3]</br>
输出：false</br>
解释：Bob总会获胜。其中一种可能的游戏进行方式如下：</br>
- 回合1：Alice可以移除值为1的第2个石子。已移除石子值总和为1。</br>
- 回合2：Bob可以移除值为3的第5个石子。已移除石子值总和为 = 1 + 3 = 4。</br>
- 回合3：Alices可以移除值为4的第4个石子。已移除石子值总和为 = 1 + 3 + 4 = 8。</br>
- 回合4：Bob可以移除值为2的第3个石子。已移除石子值总和为 = 1 + 3 + 4 + 2 = 10。</br>
- 回合5：Alice可以移除值为5的第1个石子。已移除石子值总和为 = 1 + 3 + 4 + 2 + 5 = 15。</br>
  Alice输掉游戏，因为已移除石子值总和（15）可以被3整除，Bob获胜。</br>

提示：</br>
1 <= stones.length <= 10^5</br>
1 <= stones[i] <= 10^4</br>

[Link](https://leetcode-cn.com/problems/stone-game-ix/)