package In.House.Q172;

public class Solution {

    public int trailingZeroes(int n) {
        int result = 0;
        for (int i = 5; i <= n; i += 5) {
            int k = i;
            while (k % 5 == 0) {
                ++ result;
                k /= 5;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.trailingZeroes(3)); // 0
        System.out.println(slt.trailingZeroes(5)); // 1
        System.out.println(slt.trailingZeroes(0)); // 0
        System.out.println(slt.trailingZeroes(10)); // 2
        System.out.println(slt.trailingZeroes(30)); // 7
    }

}
