import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LT65 {

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
        LT65 lt65 = new LT65();
        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        System.out.println(">>>>> answer = [true, false, false, true, false]");
        System.out.println(lt65.isNumber("0")); // true
        System.out.println(lt65.isNumber("e")); // false
        System.out.println(lt65.isNumber(".")); // false
        System.out.println(lt65.isNumber(".1")); // true
        System.out.println(lt65.isNumber(".1.")); // false
        System.out.println(lt65.isNumber("6+1")); // false
        System.out.println(lt65.isNumber("46.e3")); // true
        System.out.println(lt65.isNumber("092e359-2")); // false
        System.out.println(">>>>> answer = [true, ......]");
        System.out.println(lt65.isNumber("2")); // true
        System.out.println(lt65.isNumber("0089")); // true
        System.out.println(lt65.isNumber("-0.1")); // true
        System.out.println(lt65.isNumber("+3.14")); // true
        System.out.println(lt65.isNumber("4.")); // true
        System.out.println(lt65.isNumber("-.9")); // true
        System.out.println(lt65.isNumber("2e10")); // true
        System.out.println(lt65.isNumber("-90E3")); // true
        System.out.println(lt65.isNumber("3e+7")); // true
        System.out.println(lt65.isNumber("+6e-1")); // true
        System.out.println(lt65.isNumber("53.5e93")); // true
        System.out.println(lt65.isNumber("-123.456e789")); // true
        System.out.println(">>>>> answer = [false, ......]");
        System.out.println(lt65.isNumber("abc")); // false
        System.out.println(lt65.isNumber("1a")); // false
        System.out.println(lt65.isNumber("1e")); // false
        System.out.println(lt65.isNumber("e3")); // false
        System.out.println(lt65.isNumber("99e2.5")); // false
        System.out.println(lt65.isNumber("--6")); // false
        System.out.println(lt65.isNumber("-+3")); // false
        System.out.println(lt65.isNumber("95a54e53")); // false
        System.out.println("<<<<<<<<<<<<<<<<<<<<");
    }

}



/**
Link: https://leetcode-cn.com/problems/valid-number/

有效数字（按顺序）可以分成以下几个部分：
1. 一个小数或者整数
2.（可选）一个'e'或'E'，后面跟着一个整数

小数（按顺序）可以分成以下几个部分：
1.（可选）一个符号字符（'+' 或 '-'）
2. 下述格式之一：
    a. 至少一位数字，后面跟着一个点'.'
    b. 至少一位数字，后面跟着一个点'.'，后面再跟着至少一位数字
    c. 一个点'.'，后面跟着至少一位数字
整数（按顺序）可以分成以下几个部分：
1.（可选）一个符号字符（'+'或'-'）
2. 至少一位数字
部分有效数字列举如下：
["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
部分无效数字列举如下：
["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
给你一个字符串s，如果s是一个有效数字，请返回true 。

示例1：
输入：s = "0"
输出：true

示例2：
输入：s = "e"
输出：false

示例3：
输入：s = "."
输出：false

示例4：
输入：s = ".1"
输出：true

提示：
1 <= s.length <= 20
s仅含英文字母（大写和小写），数字（0-9），加号'+'，减号'-'，或者点'.'。
*/
