package In.House.Q258;

public class Solution {

    public int addDigits(int num) {
        while (true) {
            int result = 0;
            while (num > 0) {
                result += num % 10;
                num /= 10;
            }
            if (result < 10) {
                return result;
            }
            num = result;
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.addDigits(38)); // 2
        System.out.println(slt.addDigits(0)); // 0
    }

}

