package In.House.Q1447;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public List<String> simplifiedFractions(int n) {
        Set<String> result = new HashSet<>();
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                int tmp = gcd(i, j);
                result.add("" + j / tmp + "/" + i / tmp);
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    private int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        for (int i = 0; i < 100; ++i) {
            System.out.print(">>>>> n = " + i + ": ");
            slt.simplifiedFractions(i).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }

}

/**
Ques: 最简分数
Link: https://leetcode-cn.com/problems/simplified-fractions/

给你一个整数n，请你返回所有0到1之间（不包括0和1）满足分母小于等于n的最简分数。分数可以以任意顺序返回。

示例1：
输入：n = 2
输出：["1/2"]
解释："1/2"是唯一一个分母小于等于2的最简分数。

示例2：
输入：n = 3
输出：["1/2", "1/3", "2/3"]

示例3：
输入：n = 4
输出：["1/2", "1/3", "1/4", "2/3", "3/4"]
解释："2/4"不是最简分数，因为它可以化简为"1/2"。

示例4：
输入：n = 1
输出：[]

提示：
1 <= n <= 100
*/