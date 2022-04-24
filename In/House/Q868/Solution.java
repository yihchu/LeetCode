package In.House.Q868;

public class Solution {

    public int binaryGap(int n) {
        int idx = 0, last = -1, max = 0;
        while (n > 0) {
            if (n % 2 > 0) {
                if (last > -1) {
                    max = Math.max(idx - last, max);
                }
                last = idx;
            }
            ++idx;
            n /= 2;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.binaryGap(22)); // 2
        System.out.println(slt.binaryGap(8)); // 0
        System.out.println(slt.binaryGap(5)); // 2
    }

}
