package Sword.to.Offer.V1.Q38;

import java.util.*;

public class Solution {

//    public String[] permutation(String s) {
//        Set<String> strs = new HashSet<>();
//        doPermutation(strs, "", s);
//        String[] result = new String[strs.size()];
//        strs.toArray(result);
//        return result;
//    }
//
//    public void doPermutation(Set<String> result, String prefix, String chars) {
//        int len = chars.length();
//        if (len == 0) {
//            return;
//        }
//        if (len == 1) {
//            result.add(prefix + chars.charAt(0));
//            return;
//        }
//        for (int i = 0; i < len; ++i) {
//            doPermutation(result, prefix + chars.charAt(i), i == 0 ? chars.substring(1) : (chars.substring(0, i) + chars.substring(i + 1)));
//        }
//    }

    public String[] permutation(String s) {
        boolean[] flags = new boolean[s.length()];
        Arrays.fill(flags, false);
        Set<String> strs = new HashSet<>();
        doPermutation(strs, flags, "", s);
        String[] result = new String[strs.size()];
        strs.toArray(result);
        return result;
    }

    public void doPermutation(Set<String> result, boolean[] flags, String prefix, String chars) {
        int len = chars.length();
        if (prefix.length() == len) {
            result.add(prefix);
        }
        for (int i = 0; i < len; ++i) {
            if (flags[i]) {
                continue;
            }
            flags[i] = true;
            doPermutation(result, flags, prefix + chars.charAt(i), chars);
            flags[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.permutation("abc")).forEach(s -> System.out.print(s + " "));
        Arrays.stream(slt.permutation("aab")).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

}

