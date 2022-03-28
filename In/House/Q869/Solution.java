package In.House.Q869;

import java.util.*;

public class Solution {

    public boolean reorderedPowerOf2(int n) {
        if (n == 1 || n == 2 || n == 4 || n == 8) {
            return true;
        }
        Map target = toMap(n);
        int base = 16;
        for (int i = 0; i < 26; ++i) {
            Map cur = toMap(base);
            if (cur.equals(target)) {
                return true;
            }
            base *= 2;
        }
        return false;
    }

    private Map<Integer, Integer> toMap(int n) {
        String str = "" + n;
        int len = str.length();
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int j = 0; j < len; ++j) {
            int k = Integer.parseInt("" + str.charAt(j));
            m.put(k, m.getOrDefault(k, 0) + 1);
        }
        return m;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.reorderedPowerOf2(1));
        System.out.println(slt.reorderedPowerOf2(2));
        System.out.println(slt.reorderedPowerOf2(15));
        System.out.println(slt.reorderedPowerOf2(16));
        System.out.println(slt.reorderedPowerOf2(125));
        System.out.println(slt.reorderedPowerOf2(536780192));
    }

}
