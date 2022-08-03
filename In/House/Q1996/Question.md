<h1>游戏中弱角色的数量</h1>

你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击和防御。给你一个二维整数数组properties，其中properties[i] = [attack[i], defense[i]]表示游戏中第i个角色的属性。</br>
如果存在一个其他角色的攻击和防御等级都严格高于该角色的攻击和防御等级，则认为该角色为弱角色。更正式地，如果认为角色i弱于存在的另一个角色j，那么attack[j] > attack[i]且defense[j] > defense[i]。
返回弱角色的数量。</br>

示例1：</br>
输入：properties = [[5, 5], [6, 3], [3, 6]]</br>
输出：0</br>
解释：不存在攻击和防御都严格高于其他角色的角色。</br>

示例2：</br>
输入：properties = [[2, 2], [3, 3]]</br>
输出：1</br>
解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。</br>

示例3：</br>
输入：properties = [[1, 5], [10, 4], [4, 3]]</br>
输出：1</br>
解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。</br>

提示：
- 2 <= properties.length <= 10^5
- properties[i].length == 2
- 1 <= attack[i], defense[i] <= 10^5

[Link](https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/)