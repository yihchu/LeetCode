package In.House.Q1646;

public class Solution {

    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        int max = -1, limit = n / 2;
        for (int i = 1; i <= limit; ++i) {
            int idx = i * 2;
            array[idx] = array[i];
            max = max < array[idx] ? array[idx] : max;
            idx += 1;
            if (idx <= n) {
                array[idx] = array[i] + array[i + 1];
                max = max < array[idx] ? array[idx] : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.getMaximumGenerated(7)); // 3
        System.out.println(slt.getMaximumGenerated(2)); // 1
        System.out.println(slt.getMaximumGenerated(3)); // 2
    }

}
