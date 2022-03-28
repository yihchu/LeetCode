package In.House.Q1486;

public class Solution {

    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; ++i) {
            result ^= (start + (i << 1));
        }
        return result;
//        return IntStream.range(0, n).map(i -> start + (i << 1)).reduce(0, (a, b) -> a ^ b);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.xorOperation(5, 0)); // [0, 2, 4, 6, 8]
        System.out.println(slt.xorOperation(4, 3)); // [3, 5, 7, 9]
        System.out.println(slt.xorOperation(1, 7)); // [7]
        System.out.println(slt.xorOperation(10, 5));// [0, 2, 4, 6, 8, 10, 20, 40, 80, 160]
    }

}

