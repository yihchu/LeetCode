package In.House.Q507;

public class Solution {

    public boolean checkPerfectNumber(int num) {
        if (num <= 2) {
            return num == 1 ? true : false;
        }
        int k = num / 2, sum = 1;
        for (int i = 2; i <= k; ++i) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.checkPerfectNumber(28)); // true
        System.out.println(slt.checkPerfectNumber(6)); // true
        System.out.println(slt.checkPerfectNumber(496)); // true
        System.out.println(slt.checkPerfectNumber(8128)); // true
        System.out.println(slt.checkPerfectNumber(2)); // false
    }

}
