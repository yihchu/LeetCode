package In.House.Q1734;

import java.util.Arrays;

public class Solution {

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] perm = new int[n];
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            sum ^= i;
        }
        int last = sum;
        for (int i = 0; i < n - 1; i += 2) {
            last ^= encoded[i];
        }
        perm[n - 1] = last;
        for (int i = n - 2; i > -1; --i) {
            perm[i] = perm[i + 1] ^ encoded[i];
        }
        return perm;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.decode(new int[]{3, 1})).forEach(k -> System.out.print(k + " "));
        System.out.println();
        Arrays.stream(slt.decode(new int[]{6, 5, 4, 6})).forEach(k -> System.out.print(k + " "));
        System.out.println();
    }

}