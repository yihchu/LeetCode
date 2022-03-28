package In.House.Q1720;

public class Solution {

    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 0; i < encoded.length; ++i) {
            result[i + 1] = encoded[i] ^ result[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        int[] result = slt.decode(new int[]{6,2,7,3}, 4);
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i]);
        }
        System.out.println();
        result = slt.decode(new int[]{1, 2, 3}, 1);
        for (int i = 0; i < result.length; ++i) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

}
























