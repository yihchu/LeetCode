package In.House.Q1154;

public class Solution {

    public int dayOfYear(String date) {
        String[] array = date.split("-");
        int year = Integer.valueOf(array[0]), month = Integer.valueOf(array[1]), day = Integer.valueOf(array[2]);
        int sum = 0;
        for (int i = 1; i < month; ++i) {
            if (i == 1 || i == 3 || i == 5 || i == 8 || i == 7 || i == 10 || i == 12) {
                sum += 31;
                continue;
            }
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                sum += 30;
                continue;
            }
            sum += ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) ? 29 : 28;
        }
        return sum + day;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.dayOfYear("2019-01-09")); // 9
        System.out.println(slt.dayOfYear("2019-02-10")); // 41
        System.out.println(slt.dayOfYear("2003-03-01")); // 60
        System.out.println(slt.dayOfYear("2004-03-01")); // 61
    }

}

/**
Ques: 一年中的第几天
Link: https://leetcode-cn.com/problems/day-of-the-year/

给你一个字符串date，按YYYY-MM-DD格式表示一个现行公元纪年法日期。请你计算并返回该日期是当年的第几天。
通常情况下，我们认为1月1日是每年的第1天，1月2日是每年的第2天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。

示例1：
输入：date = "2019-01-09"
输出：9

示例2：
输入：date = "2019-02-10"
输出：41

示例3：
输入：date = "2003-03-01"
输出：60

示例4：
输入：date = "2004-03-01"
输出：61

提示：
date.length == 10
date[4] == date[7] == '-'，其他的date[i]都是数字
date表示的范围从1900年1月1日至2019年12月31日

*/
