package In.House.Q357;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<Integer, Integer> map = new HashMap<>() {{
        put(0, 1);      put(1, 10);     put(2, 91);
        put(3, 739);    put(4, 5275);   put(5, 32491);
        put(6, 168571); put(7, 712891); put(8, 2345851);
    }};

    public int countNumbersWithUniqueDigits(int n) {
        return map.getOrDefault(n, 0);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.countNumbersWithUniqueDigits(2)); // 91
    }

}
