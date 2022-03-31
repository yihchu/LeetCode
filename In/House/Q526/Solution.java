package In.House.Q526;

public class Solution {


    public int countArrangement(int n) {
        int[] mask = new int[n];
        return findArrangement(n, n, mask);
    }


    public int findArrangement(int pos, int n, int[] mask) {
        if (pos == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = n; i > 0; --i) {
            if (mask[i - 1] > 0) {
                continue;
            }
            if (pos % i == 0 || i % pos == 0) {
                mask[i - 1] = 1;
                sum += findArrangement(pos - 1, n, mask);
                mask[i - 1] = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
//        System.out.println(slt.countArrangement(2)); // 2
        System.out.println(slt.countArrangement(4)); // 8
    }

}


