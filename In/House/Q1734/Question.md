<h1>解码异或后的排列</h1>

给你一个整数数组perm，它是前n个正整数的排列，且n是个奇数。</br>
它被加密成另一个长度为n - 1的整数数组encoded，满足encoded[i] = perm[i] XOR perm[i + 1]。比方说，如果perm = [1, 3, 2]，那么encoded = [2, 1]。</br>
给你encoded数组，请你返回原始数组perm。题目保证答案存在且唯一。</br>

示例1：</br>
输入：encoded = [3, 1]</br>
输出：[1, 2, 3]</br>
解释：如果perm = [1, 2, 3]，那么encoded = [1 XOR 2, 2 XOR 3] = [3, 1]</br>

示例2：</br>
输入：encoded = [6, 5, 4, 6]</br>
输出：[2, 4, 1, 5, 3]</br>

提示：</br>
3 <= n <10^5</br>
n是奇数。</br>
encoded.length == n - 1</br>

[Link](https://leetcode-cn.com/problems/decode-xored-permutation/)