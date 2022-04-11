package In.House.Q371;

public class Solution {

    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = (a ^ b);
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.getSum(1, 2)); // 3
        System.out.println(slt.getSum(2, 3)); // 5
        System.out.println(slt.getSum(0, 3)); // 3
        System.out.println(slt.getSum(2, 0)); // 2
        System.out.println(slt.getSum(-1, 1)); // 0
    }

}

