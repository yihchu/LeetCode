package In.House.Q693;

public class Solution {

    public boolean hasAlternatingBits(int n) {
        if ((n & 1) > 0) {
            n >>= 1;
        }
        while (n > 0) {
            if ((n & 3) != 2) {
                return false;
            }
            n >>= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.hasAlternatingBits(5)); // true
        System.out.println(slt.hasAlternatingBits(7)); // false
        System.out.println(slt.hasAlternatingBits(11)); // false
        System.out.println(slt.hasAlternatingBits(10)); // true
    }

}
