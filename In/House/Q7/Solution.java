package In.House.Q7;

public class Solution {

    public int reverse(int x) {
        boolean flag = x < 0;
        x = x < 0 ? -x : x;
        String str = "" + x;
        if (x < 0) return 0;
        str = new StringBuffer(str).reverse().toString();
        long result = Long.parseLong(str);
        if (flag) result = -result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) result = 0;
        return (int)result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.reverse(1245));
    }

}

