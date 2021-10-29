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

/**
Link: https://leetcode-cn.com/problems/number-of-atoms/

给定一个化学式formula（作为字符串），返回每种原子的数量。
原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
如果数量大于1，原子后会跟着数字表示原子的数量。如果数量等于1则不会跟数字。例如，H2O和H2O2是可行的，但H1O2这个表达是不可行的。
两个化学式连在一起是新的化学式。例如H2O2He3Mg4也是化学式。
一个括号中的化学式和数字（可选择性添加）也是化学式。例如(H2O2)和(H2O2)3是化学式。
给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于1），以此类推。

示例1:
输入:
formula = "H2O"
输出: "H2O"
解释:
原子的数量是 {'H': 2, 'O': 1}。

示例2:
输入:
formula = "Mg(OH)2"
输出: "H2MgO2"
解释:
原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。

示例3:
输入:
formula = "K4(ON(SO3)2)2"
输出: "K4N2O14S4"
解释:
原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。

注意:
所有原子的第一个字母为大写，剩余字母都是小写。
formula的长度在[1, 1000]之间。
formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。

*/