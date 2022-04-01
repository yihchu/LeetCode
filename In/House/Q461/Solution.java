package In.House.Q461;

public class Solution {

    public int hammingDistance(int x, int y) {
        x = x ^ y;
        int c = 0;
        while (x > 0) {
            if ((x & 1) > 0) {
                ++c;
            }
            x >>= 1;
        }
        return c;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.hammingDistance(1, 4));
    }

}


