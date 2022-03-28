package In.House.Q1688;

public class Solution {

    public int numberOfMatches(int n) {
        int sum = 0;
        while (n > 1) {
            boolean even = n % 2 == 0;
            sum += even ? n / 2 : (n - 1) / 2;
            n = even ? n / 2 : n / 2 + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numberOfMatches(7)); // 6
        System.out.println(slt.numberOfMatches(14)); // 13
    }

}
