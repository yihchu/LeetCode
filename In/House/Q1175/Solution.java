package In.House.Q1175;

public class Solution {

    private final static int THRESHOLD = 1000000007;

    public int numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            count += isPrime(i) ? 1 : 0;
        }
        return (int)(factorial(count) * factorial(n - count) % THRESHOLD);
    }


    private boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    private long factorial(int n) {
        long result = 1;
        for (int i = n; i > 0; --i) {
            result *= i;
            result %= THRESHOLD;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numPrimeArrangements(5)); // 12
        System.out.println(slt.numPrimeArrangements(100)); // 682289015
    }

}
