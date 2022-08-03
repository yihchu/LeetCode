<h1>打乱数组</h1>

给你一个整数数组nums，设计算法来打乱一个没有重复元素的数组。</br>
实现Solution class:</br>
Solution(int[] nums)使用整数数组nums初始化对象</br>
int[] reset()重设数组到它的初始状态并返回</br>
int[] shuffle()返回数组随机打乱后的结果</br>

示例：</br>
输入</br>
["Solution", "shuffle", "reset", "shuffle"]</br>
[[[1, 2, 3]], [], [], []]</br>
输出</br>
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]</br>

解释</br>

    Solution solution = new Solution([1, 2, 3]);</br>
    solution.shuffle();    // 打乱数组[1, 2, 3]并返回结果。任何[1, 2, 3]的排列返回的概率应该相同。例如，返回[3, 1, 2]</br>
    solution.reset();      // 重设数组到它的初始状态[1, 2, 3]。返回[1, 2, 3]</br>
    solution.shuffle();    // 随机返回数组[1, 2, 3]打乱后的结果。例如，返回[1, 3, 2]</br>

提示：
- 1 <= nums.length <= 200
- -10^6 <= nums[i] <= 10^6
- nums中的所有元素都是唯一的
- 最多可以调用5 * 10^4次reset和shuffle

[Link](https://leetcode-cn.com/problems/shuffle-an-array/)