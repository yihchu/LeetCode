import java.util.*;

public class LT869 {

    public boolean reorderedPowerOf2(int n) {
        if (n == 1 || n == 2 || n == 4 || n == 8) {
            return true;
        }
        Map target = toMap(n);
        int base = 16;
        for (int i = 0; i < 26; ++i) {
            Map cur = toMap(base);
            if (cur.equals(target)) {
                return true;
            }
            base *= 2;
        }
        return false;
    }

    private Map<Integer, Integer> toMap(int n) {
        String str = "" + n;
        int len = str.length();
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int j = 0; j < len; ++j) {
            int k = Integer.parseInt("" + str.charAt(j));
            m.put(k, m.getOrDefault(k, 0) + 1);
        }
        return m;
    }

    public static void main(String[] args) {
        LT869 lt869 = new LT869();
        System.out.println(lt869.reorderedPowerOf2(1));
        System.out.println(lt869.reorderedPowerOf2(2));
        System.out.println(lt869.reorderedPowerOf2(15));
        System.out.println(lt869.reorderedPowerOf2(16));
        System.out.println(lt869.reorderedPowerOf2(125));
        System.out.println(lt869.reorderedPowerOf2(536780192));
    }

}


/**
Link: https://leetcode-cn.com/problems/reordered-power-of-2/

给定正整数N，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
如果我们可以通过上述方式得到2的幂，返回true；否则，返回false。

示例1：
输入：1
输出：true

示例2：
输入：10
输出：false

示例3：
输入：16
输出：true

示例4：
输入：24
输出：false

示例5：
输入：46
输出：true

提示：
1 <= N <= 10^9
*/