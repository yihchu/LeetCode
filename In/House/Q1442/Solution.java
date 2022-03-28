package In.House.Q1442;

public class Solution {

    public int countTriplets(int[] arr) {
        int result = 0;
        if (arr.length == 1) {
            return result;
        }
        int[] m = new int[arr.length];
        m[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            m[i] = m[i - 1] ^ arr[i];
        }
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 1; j < arr.length; ++j) {
                for (int k = i + 1; k <= j; ++k) {
                    if ( (m[k - 1] ^ (i > 0 ? m[i - 1] : 0)) == (m[j] ^ m[k - 1]) ) {
                        ++result;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.countTriplets(new int[]{2, 3, 1, 6, 7})); // 4
        System.out.println(slt.countTriplets(new int[]{1, 1, 1, 1, 1})); // 10
        System.out.println(slt.countTriplets(new int[]{2, 3})); // 0
        System.out.println(slt.countTriplets(new int[]{1, 3, 5, 7, 9})); // 3
        System.out.println(slt.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22})); // 8
    }

}

