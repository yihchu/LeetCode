package In.House.Q944;

public class Solution {

    public int minDeletionSize(String[] strs) {
        int m = strs.length, n = strs[0].length();
        int count = 0;
        for (int j = 0; j < n; ++j) {
            for (int i = 1; i < m; ++ i) {
                if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                    ++count;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.minDeletionSize(new String[] {"cba", "daf", "ghi"})); // 1
        System.out.println(slt.minDeletionSize(new String[] {"a", "b"})); // 0
        System.out.println(slt.minDeletionSize(new String[] {"zyx", "wvu", "tsr"})); // 3
        System.out.println(slt.minDeletionSize(new String[] {"rrjk", "furt", "guzm"})); // 2
     }

}
