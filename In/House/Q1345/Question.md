<h1>跳跃游戏IV</h1>

给你一个整数数组arr，你一开始在数组的第一个元素处（下标为0）。</br>
每一步，你可以从下标i跳到下标：</br>
i + 1满足：i + 1 < arr.length</br>
i - 1满足：i - 1 >= 0</br>
j满足：arr[i] == arr[j]且i != j</br>

请你返回到达数组最后一个元素的下标处所需的最少操作次数。</br>
注意：任何时候你都不能跳到数组外面。</br>

示例1：</br>
输入：arr = [100, -23, -23, 404, 100, 23, 23, 23, 3, 404]</br>
输出：3</br>
解释：那你需要跳跃3次，下标依次为 0 --> 4 --> 3 --> 9 。下标9为数组的最后一个元素的下标。</br>

示例2：</br>
输入：arr = [7]</br>
输出：0</br>
解释：一开始就在最后一个元素处，所以你不需要跳跃。</br>

示例3：</br>
输入：arr = [7, 6, 9, 6, 9, 6, 9, 7]</br>
输出：1</br>
解释：你可以直接从下标0处跳到下标7处，也就是数组的最后一个元素处。</br>

示例4：</br>
输入：arr = [6, 1, 9]</br>
输出：2</br>

示例5：</br>
输入：arr = [11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13]</br>
输出：3</br>

提示：
- 1 <= arr.length <= 5 * 10^4
- -10^8 <= arr[i] <= 10^8

[Link](https://leetcode-cn.com/problems/jump-game-iv/)