<h1>一手顺子</h1>

Alice手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是groupSize，并且由groupSize张连续的牌组成。</br>
给你一个整数数组hand其中hand[i]是写在第i张牌，和一个整数groupSize。如果她可能重新排列这些牌，返回true；否则，返回false。</br>

示例1：</br>
输入：hand = [1, 2, 3, 6, 2, 3, 4, 7, 8], groupSize = 3</br>
输出：true</br>
解释：Alice手中的牌可以被重新排列为[1, 2, 3]，[2, 3, 4]，[6, 7, 8]。</br>

示例2：</br>
输入：hand = [1, 2, 3, 4, 5], groupSize = 4</br>
输出：false</br>
解释：Alice手中的牌无法被重新排列成几个大小为4的组。</br>

提示：</br>
1 <= hand.length <= 10^4</br>
0 <= hand[i] <= 10^9</br>
1 <= groupSize <= hand.length</br>

[Link](https://leetcode-cn.com/problems/hand-of-straights/)