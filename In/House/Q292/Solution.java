package In.House.Q292;

public class Solution {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.canWinNim(4)); // false
        System.out.println(slt.canWinNim(1)); // true
        System.out.println(slt.canWinNim(2)); // true

    }

}
/*
a 1 2 3 5 6 7
b 4 8
 */

