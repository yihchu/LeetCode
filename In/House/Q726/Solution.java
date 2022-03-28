package In.House.Q726;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    // 通过，但是有点慢
    public String countOfAtoms(String formula) {
        if (formula.equals("")) {
            return "";
        }
        Stack<Pair> s = new Stack<>();
        int len = formula.length();
        String ele = "", num = "";
        for (int i = 0; i < len; ) {
            char c = formula.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                if (!ele.equals("")) {
                    s.add(new Pair(ele, num));
                }
                num = "";
                ele = "" + c;
            } else if (c >= 'a' && c <= 'z') {
                ele += c;
            } else if (c == '(') {
                if (!ele.equals("")) {
                    s.add(new Pair(ele, num));
                    ele = "";
                    num = "";
                }
                s.add(new Pair("(", "0"));
            } else if (c == ')') {
                if (!ele.equals("")) {
                    s.add(new Pair(ele, num));
                    ele = "";
                    num = "";
                }
                String nn = "";
                int j;
                for (j = i + 1; j < len; ++j) {
                    char tc = formula.charAt(j);
                    if (tc <= '9' && tc >= '0') {
                        nn += tc;
                    } else  {
                        break;
                    }
                }
                i = j;
                Stack<Pair> ss = new Stack<>();
                Pair p = s.pop();
                while (!p.elem.equals("(")) {
                    p.add(nn);
                    ss.add(p);
                    p = s.pop();
                }
                while (!ss.isEmpty()) {
                    s.add(ss.pop());
                }
                continue;
            } else { // 0 - 9
                num += c;
            }
            ++i;
        }
        if (!ele.equals("")) {
            s.add(new Pair(ele, num));
        }
        Map<String, Integer> m = new HashMap<>();
        while (!s.empty()) {
            Pair p = s.pop();
            m.put(p.elem, m.getOrDefault(p.elem, 0) + p.num);
        }
        String result = "";
        List<String> elems = m.keySet().stream().sorted().collect(Collectors.toList());
        for (String e: elems) {
            int n = m.get(e);
            result += e + (n > 1 ? n : "");
        }
        return result;
    }

    public static class Pair {
        private String elem;
        private int num;

        public Pair(String str, String num) {
            this.elem = str;
            this.num = (num.equals("") ? 1 : Integer.parseInt(num));
        }

        private void add(String num) {
            this.num *= (num.equals("") ? 1 : Integer.parseInt(num));
        }

    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution slt = new Solution();
        for (int i = 0; i < 1000; ++i) {
            System.out.println(">>>>> H2O -> " + slt.countOfAtoms("H2O"));
            System.out.println(">>>>> Mg(OH)2 -> " + slt.countOfAtoms("Mg(OH)2"));
            System.out.println(">>>>> K4(ON(SO3)2)2 -> " + slt.countOfAtoms("K4(ON(SO3)2)2"));
        }
        System.out.println(System.currentTimeMillis() - start);
    }

}
