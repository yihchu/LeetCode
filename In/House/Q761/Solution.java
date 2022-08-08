package In.House.Q761;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    // CV大法
    public String makeLargestSpecial(String s) {
        int len = s.length();
        if (len <= 2) {
            return s;
        }
        int count = 0, left = 0;
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == '1') {
                ++ count;
            } else {
                -- count;
                if (count == 0) {
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }
        Collections.sort(subs, Comparator.reverseOrder());
        StringBuilder builder = new StringBuilder();
        for (String sub: subs) {
            builder.append(sub);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.makeLargestSpecial("11011000")); // "11100100"
    }

}
