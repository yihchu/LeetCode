package In.House.Q1220;

public class Solution {

    // 哇，刷Hard，一下就想到了正解，真开心
    public int countVowelPermutation(int n) {
        final int THRESHOLD = 1000000007;
        int[] arr = new int[] {1, 1, 1, 1, 1};
        for (int i = 1; i < n; ++i) {
            int[] tmp = new int[5];
            tmp[0] = ((arr[1] + arr[2]) % THRESHOLD + arr[4]) % THRESHOLD;
            tmp[1] = (arr[0] + arr[2]) % THRESHOLD;
            tmp[2] = (arr[1] + arr[3]) % THRESHOLD;
            tmp[3] = arr[2];
            tmp[4] = (arr[2] + arr[3]) % THRESHOLD;
            arr = tmp;
        }
        int sum = 0;
        for (int s: arr) {
            sum += s;
            sum %= THRESHOLD;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.countVowelPermutation(1)); // 5
        System.out.println(slt.countVowelPermutation(2)); // 10
        System.out.println(slt.countVowelPermutation(5)); // 68
        System.out.println(slt.countVowelPermutation(144)); // 18208803
    }

}

