package In.House.Q1109;

import java.util.Arrays;

public class Solution {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int i = 0; i < bookings.length; ++i) {
            int[] booking = bookings[i];
            for (int j = booking[0] - 1; j < booking[1]; ++ j) {
                result[j] += booking[2];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)).forEach(a -> System.out.print(a + " "));
        System.out.println(); // [10, 55, 45, 25, 25]
        Arrays.stream(slt.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 2, 15}}, 2)).forEach(a -> System.out.print(a + " "));
        System.out.println(); // [10, 25]
    }

}

