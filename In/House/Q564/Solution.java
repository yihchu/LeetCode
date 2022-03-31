package In.House.Q564;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n), result = -1;
        List<Long> candidates = getCandidates(n);
        for (long candidate: candidates) {
            if (candidate != num) {
                if (result == -1 ||
                        Math.abs(candidate - num) < Math.abs(result - num) ||
                        Math.abs(candidate - num) == Math.abs(result - num) && candidate < result) {
                    result = candidate;
                }
            }
        }
        return Long.toString(result);
    }

    public List<Long> getCandidates(String n) {
        int len = n.length();
        List<Long> candidates = new ArrayList<>() {{
            add((long) Math.pow(10, len - 1) - 1);
            add((long) Math.pow(10, len) + 1);
        }};
        long selfPrefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = selfPrefix - 1; i <= selfPrefix + 1; ++i) {
            StringBuilder builder = new StringBuilder();
            String prefix = String.valueOf(i);
            builder.append(prefix);
            StringBuilder suffix = new StringBuilder(prefix).reverse();
            builder.append(suffix.substring(len & 1));
            candidates.add(Long.parseLong(builder.toString()));
        }
        return candidates;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.nearestPalindromic("123")); // "121"
        System.out.println(slt.nearestPalindromic("1")); // "0"
    }

}

