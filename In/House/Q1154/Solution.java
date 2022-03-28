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

