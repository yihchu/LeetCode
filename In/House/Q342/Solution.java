package In.House.Q342;

public class Solution {

    public boolean isPowerOfFourV0(int n) {
        if (n < 1 ) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int k = 1;
        for (int i = 0; i < 16; ++i) {
            k *= 4;
            if (k == n) {
                return true;
            }
        }
        return false;
    }

    public boolean isPowerOfFour(int n) {
        // 还不如上面的循环版本
//        return Arrays.stream(new int[] {
//                1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576, 4194304, 16777216, 67108864, 268435456, 1073741824
//        }).boxed().collect(Collectors.toSet()).contains(n);
        return n > 0 && ((n & (n - 1)) == 0) && ((n & 0x55555555) > 0);
    }


    public static void main(String[] args) {
        Solution slt = new Solution();

        System.out.println(slt.isPowerOfFourV0(16) + " vs " + slt.isPowerOfFour(16));
        System.out.println(slt.isPowerOfFourV0(5) + " vs " + slt.isPowerOfFour(5));
        System.out.println(slt.isPowerOfFourV0(1) + " vs " + slt.isPowerOfFour(1));
    }
}

