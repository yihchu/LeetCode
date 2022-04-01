package In.House.Q458;

public class Solution {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) {
            return 0;
        }
        int times = minutesToTest / minutesToDie + 1;
        for (int i = 1; i < buckets; ++i) {
            if (Math.pow(times, i) >= buckets) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.poorPigs(1000, 15, 60)); // 5
        System.out.println(slt.poorPigs(4, 15, 15)); // 2
        System.out.println(slt.poorPigs(4, 15, 30)); // 2
    }

}



