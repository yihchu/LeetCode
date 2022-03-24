package In.House.Q440;

public class Solution {

    // CV大法
    public int findKthNumber(int n, int k) {
        int result = 1;
        k = k - result;
        while(k > 0) {
            int count = calc(result, n);
            if (count <= k) {
                k -= count;
                ++ result;
            } else {
                k -= 1;
                result *= 10;
            }
        }
        return result;
    }

    private int calc(int result, long limit) {
        long start = result, end = result;
        int count = 0;
        while (start <= limit) {
            count += (Math.min(limit, end) - start + 1);
            start = start * 10;
            end = end * 10 + 9;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findKthNumber(13, 2)); // 10
        System.out.println(slt.findKthNumber(13, 3)); // 11
        System.out.println(slt.findKthNumber(1, 1)); // 1

    }

}