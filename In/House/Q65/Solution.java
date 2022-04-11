package In.House.Q65;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    Set<Character> numbers = Arrays.stream(new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'})
            .collect(Collectors.toSet());
    Set<Character> symbols = Arrays.stream(new Character[]{'+', '-'}).collect(Collectors.toSet());
    Set<Character> dots = Arrays.stream(new Character[]{'.'}).collect(Collectors.toSet());
    Set<Character> es = Arrays.stream(new Character[]{'e', 'E'}).collect(Collectors.toSet());

    public boolean isInteger(String s) {
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (symbols.contains(c)) {
                if (i == 0 && i + 1 < len && !symbols.contains(s.charAt(i + 1))) {
                    continue;
                }
                return false;
            } else if (numbers.contains(c)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isNumber(String s) {
        boolean hasDot = false, hasE = false, hasSymbol = false;
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (!hasSymbol && symbols.contains(c)) {
                hasSymbol = true;
                if (i == 0 && i + 1 < len && !symbols.contains(s.charAt(i + 1))) {
                    continue;
                }
                return false;
            } else if (numbers.contains(c)) {
                continue;
            } else if (!hasDot && dots.contains(c)) {
                hasDot = true;
                if ((i > 0 && numbers.contains(s.charAt(i - 1))) || (i + 1 < len && numbers.contains(s.charAt(i + 1)))) {
                    continue;
                }
                return false;
            } else if (!hasE && es.contains(c)) {
                hasE = true;
                if (i > 0 && (numbers.contains(s.charAt(i - 1)) || s.charAt(i - 1) == '.' ) && i + 1 < len) {
                    return isInteger(s.substring(i + 1));
                }
                return false;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>> answer = [true, false, false, true, false]");
        System.out.println(slt.isNumber("0")); // true
        System.out.println(slt.isNumber("e")); // false
        System.out.println(slt.isNumber(".")); // false
        System.out.println(slt.isNumber(".1")); // true
        System.out.println(slt.isNumber(".1.")); // false
        System.out.println(slt.isNumber("6+1")); // false
        System.out.println(slt.isNumber("46.e3")); // true
        System.out.println(slt.isNumber("092e359-2")); // false
        System.out.println(">>>>> answer = [true, ......]");
        System.out.println(slt.isNumber("2")); // true
        System.out.println(slt.isNumber("0089")); // true
        System.out.println(slt.isNumber("-0.1")); // true
        System.out.println(slt.isNumber("+3.14")); // true
        System.out.println(slt.isNumber("4.")); // true
        System.out.println(slt.isNumber("-.9")); // true
        System.out.println(slt.isNumber("2e10")); // true
        System.out.println(slt.isNumber("-90E3")); // true
        System.out.println(slt.isNumber("3e+7")); // true
        System.out.println(slt.isNumber("+6e-1")); // true
        System.out.println(slt.isNumber("53.5e93")); // true
        System.out.println(slt.isNumber("-123.456e789")); // true
        System.out.println(">>>>> answer = [false, ......]");
        System.out.println(slt.isNumber("abc")); // false
        System.out.println(slt.isNumber("1a")); // false
        System.out.println(slt.isNumber("1e")); // false
        System.out.println(slt.isNumber("e3")); // false
        System.out.println(slt.isNumber("99e2.5")); // false
        System.out.println(slt.isNumber("--6")); // false
        System.out.println(slt.isNumber("-+3")); // false
        System.out.println(slt.isNumber("95a54e53")); // false
        System.out.println("<<<<<<<<<<<<<<<<<<<<");
    }

}




