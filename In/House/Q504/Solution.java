package In.House.Q504;

public class Solution {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean flag = false;
        if (num < 0) {
            num = - num;
            flag = true;
        }
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            builder.append(num % 7);
            num /= 7;
        }
        if (flag) {
            builder.append("-");
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.convertToBase7(100)); // 202
        System.out.println(slt.convertToBase7(-7)); // -10
        System.out.println(slt.convertToBase7(0)); // 0
    }

}

