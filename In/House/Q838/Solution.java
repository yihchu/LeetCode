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

/**
Ques: https://leetcode-cn.com/problems/push-dominoes/
Link: 推多米诺

n张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡，该骨牌仍然保持不变。
就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
给你一个字符串dominoes表示这一行多米诺骨牌的初始状态，其中：
dominoes[i] = 'L'，表示第i张多米诺骨牌被推向左侧，
dominoes[i] = 'R'，表示第i张多米诺骨牌被推向右侧，
dominoes[i] = '.'，表示没有推动第i张多米诺骨牌。
返回表示最终状态的字符串。

示例1：
输入：dominoes = "RR.L"
输出："RR.L"
解释：第一张多米诺骨牌没有给第二张施加额外的力。

示例2(图1.png)：
输入：dominoes = ".L.R...LR..L.."
输出："LL.RR.LLRRLL.."

提示：
n == dominoes.length
1 <= n <= 10^5
dominoes[i]为'L'、'R'或'.'

*/