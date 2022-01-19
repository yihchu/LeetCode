package In.House.Q401;

import java.util.*;

public class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        if (turnedOn == 0) {
            result.add("0:00");
            return result;
        }
        doReadBinaryWatch(result, "", 10, turnedOn);
        return result;
    }

    private void doReadBinaryWatch(List<String> result, String prefix, int pos, int turnedOn) {
        if (pos < turnedOn || (pos == 8 && prefix.startsWith("11"))) {
            return;
        }
        if (turnedOn == 1) {
            char[] chars = new char[pos];
            Arrays.fill(chars, '0');
            for (int i = 0; i < pos; ++i) {
                chars[i] = '1';
                String r = readFromBinary(prefix + new String(chars));
                if (Objects.nonNull(r)) {
                    result.add(r);
                }
                chars[i] = '0';
            }
            return;
        }
        int index = 0;
        String str = "";
        while (pos - index >= turnedOn) {
            doReadBinaryWatch(result, prefix + str + 1, pos - index - 1, turnedOn - 1);
            ++index;
            str += "0";
        }
    }

    private String readFromBinary(String str) {
        int start = 8;
        int hours = 0;
        for (int i = 0; i < 4; ++i) {
            hours += (str.charAt(i) == '1' ? start : 0);
            start /= 2;
        }
        if (hours > 11) {
            return null;
        }
        start = 32;
        int minutes = 0;
        for (int i = 4; i < 10; ++i) {
            minutes += (str.charAt(i) == '1' ? start : 0);
            start /= 2;
        }
        if (minutes > 59) {
            return null;
        }
        if (minutes == 0) {
            return hours + ":00";
        }
        return hours + ":" + (minutes < 10 ? "0" + minutes : minutes);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        System.out.println("--------------------");
        System.out.println(">>>>> turned = 0: ");
        slt.readBinaryWatch(0).stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("--------------------");
        System.out.println(">>>>> turned = 1: ");
        slt.readBinaryWatch(1).stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("--------------------");
        // ["0:03","0:05","0:06","0:09","0:10","0:12","0:17","0:18","0:20","0:24","0:33","0:34","0:36","0:40","0:48","1:01","1:02","1:04","1:08","1:16","1:32","2:01","2:02","2:04","2:08","2:16","2:32","3:00","4:01","4:02","4:04","4:08","4:16","4:32","5:00","6:00","8:01","8:02","8:04","8:08","8:16","8:32","9:00","10:00"]
        System.out.println(">>>>> turned = 2: ");
        slt.readBinaryWatch(2).stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("--------------------");
        System.out.println(">>>>> turned = 9: ");
        slt.readBinaryWatch(9).stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("--------------------");
        System.out.println("<<<<<<<<<<<<<<<<<<<<");
    }

}

/**
Ques: 二进制手表
Link: https://leetcode-cn.com/problems/binary-watch/

二进制手表顶部有4个LED代表小时（0-11）底部的6个LED代表分钟（0-59）。每个LED代表一个0或1，最低位在右侧。
例如，图1.jpeg中的二进制手表读取"3:25"。
给你一个整数turnedOn，表示当前亮着的LED的数量，返回二进制手表可以表示的所有可能时间。你可以按任意顺序返回答案。
小时不会以零开头：
例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
分钟必须由两位数组成，可能会以零开头：
例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。

示例1：
输入：turnedOn = 1
输出：["0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00"]

示例2：
输入：turnedOn = 9
输出：[]

解释：
0 <= turnedOn <= 10

*/