package In.House.Q299;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int len = guess.length(), bulls = 0, cows = 0;
        for (int i = 0; i < len; ++i) {
            char c = secret.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean[] mask = new boolean[len];
        Arrays.fill(mask, false);
        for (int i = 0; i < len; ++i) {
            char cc = secret.charAt(i);
            char c = guess.charAt(i);
            if (c == cc) {
                ++bulls;
                map.put(c, map.get(c) - 1);
                mask[i] = true;
            }
        }
        for (int i = 0; i < len; ++i) {
            if (mask[i]) {
                continue;
            }
            char c = guess.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                ++cows;
                map.put(c, map.get(c) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.getHint("1807", "7810")); // 1A3B
        System.out.println(slt.getHint("1123", "0111")); // 1A1B
        System.out.println(slt.getHint("1", "0")); // 0A0B
        System.out.println(slt.getHint("1", "1")); // 1A0B
        System.out.println(slt.getHint("1122", "1222")); // "3A0B"
    }

}

/**
Link: https://leetcode-cn.com/problems/bulls-and-cows/

你在和朋友一起玩猜数字（Bulls and Cows）游戏，该游戏规则如下：
写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
猜测数字中有多少位属于数字和确切位置都猜对了（称为"Bulls", 公牛），
有多少位属于数字猜对了但是位置不对（称为"Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
给你一个秘密数字secret和朋友猜测的数字guess，请你返回对朋友这次猜测的提示。
提示的格式为"xAyB"，x是公牛个数， y是奶牛个数，A表示公牛，B表示奶牛。
请注意秘密数字和朋友猜测的数字都可能含有重复数字。

示例1:
输入: secret = "1807", guess = "7810"
输出: "1A3B"
解释: 数字和位置都对（公牛）用'|'连接，数字猜对位置不对（奶牛）的采用斜体加粗（单引号）标识。
"1807"
  |
"781'0'"

示例2:
输入: secret = "1123", guess = "0111"
输出: "1A1B"
解释: 数字和位置都对（公牛）用'|'连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
"1123"        "1123"
  |      or     |
"01'1'1"      "011'1'"
注意，两个不匹配的1中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个1可以成为公牛数字。

示例3：
输入：secret = "1", guess = "0"
输出："0A0B"

示例4：
输入：secret = "1", guess = "1"
输出："1A0B"

提示：
1 <= secret.length, guess.length <= 1000
secret.length == guess.length
secret和guess仅由数字组成

*/
