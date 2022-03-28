package In.House.Q2038;

public class Solution {

    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0, len = colors.length();
        char cur = colors.charAt(0);
        int count = 1;
        for (int i = 1; i < len; ++i) {
            char tmp = colors.charAt(i);
            if (tmp != cur) {
                cur = tmp;
                count = 1;
            } else {
                ++ count;
                if (count < 3) {
                    continue;
                }
                if (cur == 'A')  {
                    ++ alice;
                } else {
                    ++ bob;
                }
            }
        }
        return alice > bob;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.winnerOfGame("AAABABB")); // true
        System.out.println(slt.winnerOfGame("AA")); // false
        System.out.println(slt.winnerOfGame("ABBBBBBBAAA")); // false
    }

}
