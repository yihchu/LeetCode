package In.House.Q50;

public class Solution {

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? doPow(x, N) : 1 / doPow(x, -N);
    }

    private double doPow(double x, long N) {
        if (N == 0) {
            return 1;
        }
        double y = doPow(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.myPow(2.00000, 10)); // 1024.00000
        System.out.println(slt.myPow(2.10000, 3)); // 9.26100
        System.out.println(slt.myPow(2.00000, -2)); // 0.25000
        System.out.println(slt.myPow(2.00000, -2147483648)); // 0.25000
    }


}
