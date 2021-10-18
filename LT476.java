public class LT476 {

    public int findComplement(int num) {
        int sum = 0, gap = 1073741824; // 1 << 30;
        boolean flag = false;
        for (int i = gap; i >= 1; i = i >> 1) {
            if ((num & i) > 0) {
                flag = true;
            } else if (flag) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LT476 lt476 = new LT476();
        System.out.println(lt476.findComplement(5)); // 2
        System.out.println(lt476.findComplement(1)); // 0
        System.out.println(lt476.findComplement(Integer.MAX_VALUE)); // 0
        System.out.println(lt476.findComplement(Integer.MAX_VALUE - 1)); // 1
    }

}

/**
Link: https://leetcode-cn.com/problems/number-complement/

给你一个正整数num，输出它的补数。补数是对该数的二进制表示取反。

示例1：
输入：num = 5
输出：2
解释：5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。

示例2：
输入：num = 1
输出：0
解释：1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。

提示：
给定的整数num保证在32位带符号整数的范围内。
num >= 1
你可以假定二进制数不包含前导零位。
本题与1009(https://leetcode-cn.com/problems/complement-of-base-10-integer/)相同
*/