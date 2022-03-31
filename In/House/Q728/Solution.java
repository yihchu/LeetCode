package In.House.Q728;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new LinkedList<>();
        for (int i = left; i <= right; ++i) {
            if (check(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean check(int n) {
        int tmp = n;
        while (tmp > 0) {
            int mod = tmp % 10;
            if (mod == 0 || n % mod > 0) {
                return false;
            }
            tmp /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
        slt.selfDividingNumbers(1, 22).stream().forEach(a -> System.out.print(a + " "));
        System.out.println();
        // [48, 55, 66, 77]
        slt.selfDividingNumbers(47, 85).stream().forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}