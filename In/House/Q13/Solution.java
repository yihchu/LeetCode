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
