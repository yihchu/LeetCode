<h1>救生艇</h1>

第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。</br>
每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。</br>
返回载到每一个人所需的最小船数。(保证每个人都能被船载)。</br>

示例1：</br>
输入：people = [1, 2], limit = 3</br>
输出：1</br>
解释：1艘船载(1, 2)</br>

示例2：</br>
输入：people = [3, 2, 2, 1], limit = 3</br>
输出：3</br>
解释：3艘船分别载(1, 2), (2)和(3)</br>

示例3：</br>
输入：people = [3, 5, 3, 4], limit = 5</br>
输出：4</br>
解释：4艘船分别载(3), (3), (4), (5)</br>

提示：
- 1 <= people.length <= 50000
- 1 <= people[i] <= limit <= 30000

[Link](https://leetcode-cn.com/problems/boats-to-save-people/)