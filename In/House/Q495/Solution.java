package In.House.Q495;

public class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisoned = timeSeries[0] + duration;
        int result = duration, len = timeSeries.length;
        for (int i = 1; i < len; ++i) {
            result += (timeSeries[i] < poisoned ? duration - (poisoned - timeSeries[i]) : duration);
            poisoned = timeSeries[i] + duration;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.findPoisonedDuration(new int[] {1, 4}, 2)); // 4
        System.out.println(slt.findPoisonedDuration(new int[] {1, 2}, 2)); // 3
        System.out.println(slt.findPoisonedDuration(new int[] {1, 2, 3, 4, 5}, 5)); // 9
    }
}

