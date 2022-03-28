package In.House.Q838;

import java.util.Arrays;

public class Solution {

    public String pushDominoes(String dominoes) {
        int len = dominoes.length();
        char[] chars = dominoes.toCharArray();
        while (true) {
            boolean flag = false;
            char[] tmps = Arrays.copyOf(chars, len);
            for (int i = 0; i < len; ++i) {
                if (tmps[i] != '.') {
                    continue;
                }
                int tmp = 0;
                if (i > 0 && tmps[i - 1] == 'R') {
                    ++tmp;
                }
                if (i < len - 1 && tmps[i + 1] == 'L') {
                    --tmp;
                }
                if (tmp == 0) {
                    continue;
                }
                chars[i] = tmp > 0 ? 'R' : 'L';
                flag = true;
            }
            if (!flag) {
                break;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.pushDominoes("RR.L")); // RR.L
        System.out.println(slt.pushDominoes(".L.R...LR..L..")); // LL.RR.LLRRLL..
    }

}
