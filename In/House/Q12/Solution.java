package In.House.Q12;

public class Solution {

    public String intToRoman(int num) {
        int[] steps = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4};
        String[] strs = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 12; i += 2) {
            while (num >= steps[i]) {
                result.append(strs[i]);
                num -= steps[i];
            }
            if (num >= steps[i + 1]) {
                result.append(strs[i + 1]);
                num -= steps[i + 1];
            }
        }
        while (num >= 1) {
            result.append("I");
            num -= 1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.intToRoman(3)); // III
        System.out.println(slt.intToRoman(4)); // IV
        System.out.println(slt.intToRoman(9)); // IX
        System.out.println(slt.intToRoman(58)); // LVIII
        System.out.println(slt.intToRoman(1994)); // MCMXCIV
    }

}

/**
Ques: 整数转罗马数字
Link: https://leetcode-cn.com/problems/integer-to-roman/

罗马数字包含以下七种字符：I，V，X，L，C，D和M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如，罗马数字2写做II，即为两个并列的1。12写做XII，即为X + II。27写做XXVII, 即为XX + V + II。
通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如4不写做IIII，而是IV。数字1在数字5的左边，所表示的数等于大数5减小数1得到的数值4。同样地，数字9表示为IX。这个特殊的规则只适用于以下六种情况：

I可以放在V(5)和X(10)的左边，来表示4和9。
X可以放在L(50)和C(100)的左边，来表示40和90。
C可以放在D(500)和M(1000)的左边，来表示400和900。
给你一个整数，将其转为罗马数字。

示例1:
输入: num = 3
输出: "III"

示例2:
输入:num = 4
输出: "IV"

示例3:
输入: num = 9
输出: "IX"

示例4:
输入: num = 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.

示例5:
输入: num = 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.

提示：
1 <= num <= 3999

*/