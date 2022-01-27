package In.House.Q2047;

public class Solution {

    public int countValidWords(String sentence) {
        String[] arr = sentence.split(" ");
        int count = 0;
        for (String str: arr) {
            int len = str.length();
            if (len == 0) {
                continue;
            }
            int idx = 0;
            boolean flag = false;
            for (; idx < len; ++idx) {
                char c = str.charAt(idx);
                if (Character.isDigit(c)) {
                    break;
                }
                if (c == '-') {
                    if (flag || (idx == 0 || idx == len - 1 || !Character.isLetter(str.charAt(idx - 1)) || !Character.isLetter(str.charAt(idx + 1)))) {
                        break;
                    }
                    flag = true;
                }
                if ((c == '!' || c == '.' || c == ',') && idx != len - 1) {
                    break;
                }
            }
            count += idx == len ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.countValidWords("cat and  dog")); // 3
        System.out.println(slt.countValidWords("!this  1-s b8d!")); // 0
        System.out.println(slt.countValidWords("alice and  bob are playing stone-game10")); // 5
        System.out.println(slt.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.")); // 6
        System.out.println(slt.countValidWords("a-b-c")); // 0
        System.out.println(slt.countValidWords(" 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif ")); // 0
    }

}

/**
Link: https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence/
Ques: 句子中的有效单词数

句子仅由小写字母（'a'到'z'）、数字（'0'到'9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。每个句子可以根据空格分解成一个或者多个token，这些token之间由一个或者多个空格' '分隔。
如果一个token同时满足下述条件，则认为这个token是一个有效单词：
仅由小写字母、连字符和/或标点（不含数字）。
至多一个连字符'-'。如果存在，连字符两侧应当都存在小写字母（"a-b"是一个有效单词，但"-ab"和"ab-"不是有效单词）。
至多一个标点符号。如果存在，标点符号应当位于token的末尾。
这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!"。
给你一个字符串sentence，请你找出并返回sentence中有效单词的数目。

示例1：
输入：sentence = "cat and  dog"
输出：3
解释：句子中的有效单词是"cat"、"and"和"dog"

示例2：
输入：sentence = "!this  1-s b8d!"
输出：0
解释：句子中没有有效单词
"!this"不是有效单词，因为它以一个标点开头
"1-s"和"b8d"也不是有效单词，因为它们都包含数字

示例3：
输入：sentence = "alice and  bob are playing stone-game10"
输出：5
解释：句子中的有效单词是"alice"、"and"、"bob"、"are"和"playing"
"stone-game10"不是有效单词，因为它含有数字

示例4：
输入：sentence = "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."
输出：6
解释：句子中的有效单词是"he"、"bought"、"pencils,"、"erasers,"、"and" 和 "pencil-sharpener."

提示：
1 <= sentence.length <= 1000
sentence由小写英文字母、数字（0-9）、以及字符（' '、'-'、'!'、'.' 和 ','）组成
句子中至少有1个token
*/