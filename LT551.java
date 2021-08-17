public class LT551 {

    public boolean checkRecord(String s) {
        boolean A = false;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != 'A') {
                continue;
            }
            if (A) {
                return false;
            }
            A = true;
        }
        return !s.contains("LLL");
    }

    public static void main(String[] args) {
        LT551 lt551 = new LT551();
        System.out.println(lt551.checkRecord("PPALLP"));
        System.out.println(lt551.checkRecord("PPALLL"));
    }

}

/*

给你一个字符串s表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：

'A'：Absent，缺勤
'L'：Late，迟到
'P'：Present，到场

如果学生能够同时满足下面两个条件，则可以获得出勤奖励：
按总出勤计，学生缺勤（'A'）严格少于两天。
学生不会存在连续3天或3天以上的迟到（'L'）记录。
如果学生可以获得出勤奖励，返回true；否则，返回false。

示例 1：
输入：s = "PPALLP"
输出：true
解释：学生缺勤次数少于2次，且不存在3天或以上的连续迟到记录。

示例 2：
输入：s = "PPALLL"
输出：false
解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。

提示：
1 <= s.length <= 1000
s[i]为'A'、'L'或'P'

*/