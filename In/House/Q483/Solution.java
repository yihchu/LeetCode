package In.House.Q483;

public class Solution {

    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.smallestGoodBase("13")); // 3
        System.out.println(slt.smallestGoodBase("4681")); // 8
        System.out.println(slt.smallestGoodBase("1000000000000000000")); // 999999999999999999
    }

}

