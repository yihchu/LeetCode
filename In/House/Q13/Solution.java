package In.House.Q13;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>() {{
            put("I", 1);   put("IV", 4);   put("V", 5);   put("IX", 9);
            put("X", 10);  put("XL", 40);  put("L", 50);  put("XC", 90);
            put("C", 100); put("CD", 400); put("D", 500); put("CM", 900);
            put("M", 1000);
        }};
        int sum = 0, len = s.length();
        for (int i = 0; i < len; ) {
            String key = "";
            if (i + 1 < len) {
                key = "" + s.charAt(i) + s.charAt(i + 1);
            }
            if (map.containsKey(key)) {
                i += 2;
            } else {
                key = "" + s.charAt(i);
                i += 1;
            }
            sum += map.get(key);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        System.out.println(slt.romanToInt("III")); // 3
//        System.out.println(slt.romanToInt("IV")); // 4
//        System.out.println(slt.romanToInt("IX")); // 9
//        System.out.println(slt.romanToInt("LVIII")); // 58
//        System.out.println(slt.romanToInt("MCMXCIV")); // 1994
        System.out.println(slt.romanToInt("DCXXI")); // 621
    }

}

/**
Link: https://leetcode-cn.com/problems/roman-to-integer/
Ques: 罗马数字转整数

罗马数字包含以下七种字符: I，V，X，L，C，D和M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

例如， 罗马数字2写做II，即为两个并列的1。12写做XII，即为X+II。27写做XXVII, 即为XX+V+II。
通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如4不写做IIII，而是IV。数字1在数字5的左边，所表示的数等于大数5减小数1得到的数值4。同样地，数字9表示为IX。这个特殊的规则只适用于以下六种情况：
I可以放在V(5)和X(10)的左边，来表示4和9。
X可以放在L(50)和C(100)的左边，来表示40和90。
C可以放在D(500)和M(1000)的左边，来表示400和900。
给定一个罗马数字，将其转换成整数。

示例1:
输入:s = "III"
输出: 3

示例2:
输入:s = "IV"
输出: 4

示例3:
输入:s = "IX"
输出: 9

示例4:
输入: s = "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.

示例5:
输入: s = "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.

提示：
1 <= s.length <= 15
s仅含字符('I', 'V', 'X', 'L', 'C', 'D', 'M')
题目数据保证s是一个有效的罗马数字，且表示整数在范围[1, 3999]内
题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
IL和IM这样的例子并不符合题目要求，49应该写作XLIX，999应该写作CMXCIX。
关于罗马数字的详尽书写规则，可以参考<罗马数字-Mathematics>。

*/