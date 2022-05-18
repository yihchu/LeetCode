package In.House.Q668;

public class Solution {

    // CV大法
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = x / n * n;
            for (int i = x / n + 1; i <= m; ++i) {
                count += x / i;
            }
            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        System.out.println(slt.findKthNumber(3, 3, 5)); // 3
//        System.out.println(slt.findKthNumber(2, 3, 6)); // 6
        System.out.println(slt.findKthNumber(42, 34, 401)); // 126
    }

}
