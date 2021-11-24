package In.House.Q423;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private Map<Integer, Map<Character, Integer>> dict = new HashMap<>() {{
        put(0, new HashMap<>(){{put('z', 1); put('e', 1); put('r', 1); put('o', 1);}});
        put(1, new HashMap<>(){{put('o', 1); put('n', 1); put('e', 1);}});
        put(2, new HashMap<>(){{put('t', 1); put('w', 1); put('o', 1);}});
        put(3, new HashMap<>(){{put('t', 1); put('h', 1); put('r', 1); put('e', 2);}});
        put(4, new HashMap<>(){{put('f', 1); put('o', 1); put('u', 1); put('r', 1);}});
        put(5, new HashMap<>(){{put('f', 1); put('i', 1); put('v', 1); put('e', 1);}});
        put(6, new HashMap<>(){{put('s', 1); put('i', 1); put('x', 1);}});
        put(7, new HashMap<>(){{put('s', 1); put('e', 2); put('v', 1); put('n', 1);}});
        put(8, new HashMap<>(){{put('e', 1); put('i', 1); put('g', 1); put('h', 1); put('t', 1);}});
        put(9, new HashMap<>(){{put('n', 2); put('i', 1); put('e', 1);}});
    }};
    private Map<Character, List<Integer>> idx =  new HashMap<>() {{
        put('z', List.of(0));
        put('w', List.of(2));
        put('u', List.of(4));
        put('x', List.of(6));
        put('g', List.of(8));
        put('h', List.of(3, 8));
        put('f', List.of(4, 5));
        put('v', List.of(5, 7));
        put('s', List.of(6, 7));
        put('r', List.of(0, 3, 4));
        put('n', List.of(1, 7, 9));
        put('t', List.of(2, 3, 8));
        put('i', List.of(5, 6, 8, 9));
        put('o', List.of(0, 1, 2, 4));
        put('e', List.of(0, 1, 3, 5, 7, 8, 9));
    }};

    private char[] singles = new char[] {'z', 'w', 'u', 'x', 'g'};
    private char[] multies = new char[] {'h', 'f', 'v', 's', 'r', 'n', 't', 'i', 'o', 'e'};
    private char[] all = new char[] {'z', 'w', 'u', 'x', 'g', 'h', 'f', 'v', 's', 'r', 'n', 't', 'i', 'o', 'e'};

//    // 超时
//    public String originalDigits(String s) {
//        List<Integer> result = new ArrayList<>();
//        Map<Character, Integer> map = new HashMap<>();
//        int len = s.length();
//        for (int i = 0; i < len; ++i) {
//            char c = s.charAt(i);
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        boolean isValid = processSingles(map, result) && processMulties(map, result);
//        Collections.sort(result);
//        return result.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
//    }
//
//    private boolean processSingles(Map<Character, Integer> map,  List<Integer> result) {
//        for (char c: this.singles) {
//            while (map.containsKey(c) && map.get(c) > 0) {
//                int t = this.idx.get(c).get(0);
//                result.add(t);
//                minus(map, this.dict.get(t));
//            }
//        }
//        for (char c: this.all) {
//            if (map.getOrDefault(c, 0) == 0) {
//                map.remove(c);
//            }
//        }
//        return true;
//    }
//
//    private boolean processMulties(Map<Character, Integer> map,  List<Integer> result) {
//        if (map.values().stream().anyMatch(v -> v < 0)) {
//            return false;
//        }
//        if (map.values().stream().noneMatch(v -> v != 0)) {
//            return true;
//        }
//        for (char c: multies) {
//            if (map.getOrDefault(c, 0) < 1) {
//                continue;
//            }
//            for (int t: idx.get(c)) {
//                Map<Character, Integer> tmp = this.dict.get(t);
//                if (!minus(map, tmp)) {
//                    add(map, tmp);
//                    continue;
//                }
//                if (processMulties(map, result)) {
//                    result.add(t);
//                    return true;
//                }
//                add(map, tmp);
//            }
//        }
//        return false;
//    }
//
//    private boolean minus(Map<Character, Integer> map, Map<Character, Integer> entry) {
//        boolean flag = true;
//        for (Character c: entry.keySet()) {
//            if (!map.containsKey(c)) {
//                flag = false;
//                continue;
//            }
//            map.put(c, map.get(c) - entry.get(c));
//        }
//        if (!flag) {
//            return false;
//        }
//        for (Character c: entry.keySet()) {
//            if (map.getOrDefault(c, 0) < 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void add(Map<Character, Integer> map, Map<Character, Integer> entry) {
//        for (Character c: entry.keySet()) {
//            if (!map.containsKey(c)) {
//                continue;
//            }
//            map.put(c, map.get(c) + entry.get(c));
//        }
//    }

    public String originalDigits(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: this.singles) {
            if (map.containsKey(c) && map.get(c) > 0) {
                int k = idx.get(c).get(0), t = map.get(c);
                Map<Character, Integer> entry = dict.get(k);
                for (char key: entry.keySet()) {
                    map.put(key, map.get(key) - entry.get(key) * t);
                }
                for (int i = 0; i < t; ++i) {
                    result.add(k);
                }
            }
        }
        for (char c: this.all) {
            if (map.getOrDefault(c, 0) == 0) {
                map.remove(c);
            }
        }
        processMulties(map, result);
        Collections.sort(result);
        return result.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
    }

    private boolean processMulties(Map<Character, Integer> map,  List<Integer> result) {
        if (map.values().stream().noneMatch(v -> v != 0)) {
            return true;
        }
        for (char c: multies) {
            if (map.getOrDefault(c, 0) < 1) {
                continue;
            }
            for (int t: idx.get(c)) {
                boolean flag = true;
                Map<Character, Integer> tmp = this.dict.get(t);
                for (char cc: tmp.keySet()) {
                    if (map.getOrDefault(cc, 0) < tmp.get(cc)) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    continue;
                }
                minus(map, tmp);
                if (processMulties(map, result)) {
                    result.add(t);
                    return true;
                }
                add(map, tmp);
            }
        }
        return false;
    }

    private void minus(Map<Character, Integer> map, Map<Character, Integer> entry) {
        for (Character c: entry.keySet()) {
            map.put(c, map.get(c) - entry.get(c));
        }
    }
    private void add(Map<Character, Integer> map, Map<Character, Integer> entry) {
        for (Character c: entry.keySet()) {
            map.put(c, map.get(c) + entry.get(c));
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.originalDigits("owoztneoer")); // 012
        System.out.println(slt.originalDigits("fviefuro")); // 45
        System.out.println(slt.originalDigits("esnve")); // 7
    }

}

/**
Link: https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/

给你一个字符串s，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按升序返回原始的数字。

示例1：
输入：s = "owoztneoer"
输出："012"

示例2：
输入：s = "fviefuro"
输出："45"

提示：
1 <= s.length <= 10^5
s[i]为["e", "g", "f", "i", "h", "o", "n", "s", "r", "u", "t", "w", "v", "x", "z"]这些字符之一
s保证是一个符合题目要求的字符串

*/