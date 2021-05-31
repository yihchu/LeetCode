import java.util.Arrays;
import java.util.stream.Collectors;

public class LT342 {

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
        LT342 lt342 = new LT342();

        System.out.println(lt342.isPowerOfFourV0(16) + " vs " + lt342.isPowerOfFour(16));
        System.out.println(lt342.isPowerOfFourV0(5) + " vs " + lt342.isPowerOfFour(5));
        System.out.println(lt342.isPowerOfFourV0(1) + " vs " + lt342.isPowerOfFour(1));
    }
}

/*
给定一个整数，写一个函数来判断它是否是4的幂次方。如果是，返回 true;否则，返回false。
整数n是4的幂次方需满足：存在整数x使得n == 4^x

示例 1：
输入：n = 16
输出：true

示例 2：
输入：n = 5
输出：false

示例 3：
输入：n = 1
输出：true

提示：
-2^31 <= n <= 2^31 - 1

进阶：
你能不使用循环或者递归来完成本题吗？
*/