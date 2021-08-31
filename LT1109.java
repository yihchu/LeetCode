import java.util.Arrays;

public class LT1109 {

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
        LT1109 lt1109 = new LT1109();
        Arrays.stream(lt1109.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5)).forEach(a -> System.out.print(a + " "));
        System.out.println(); // [10, 55, 45, 25, 25]
        Arrays.stream(lt1109.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 2, 15}}, 2)).forEach(a -> System.out.print(a + " "));
        System.out.println(); // [10, 25]
    }

}

/*

这里有n个航班，它们分别从1到n进行编号。
有一份航班预订表bookings，表中第i条预订记录bookings[i] = [first[i], last[i], seats[i]]意味着在从first[i]到last[i]（包含first[i]和last[i]）的每个航班上预订了seats[i]个座位。
请你返回一个长度为n的数组answer，其中answer[i]是航班i上预订的座位总数。

示例 1：
输入：bookings = [[1, 2, 10], [2, 3, 20], [2, 5, 25]], n = 5
输出：[10, 55, 45, 25, 25]
解释：
航班编号        1   2   3   4   5
预订记录 1 ：   10  10
预订记录 2 ：       20  20
预订记录 3 ：       25  25  25  25
总座位数：      10  55  45  25  25
因此，answer = [10, 55, 45, 25, 25]

示例 2：
输入：bookings = [[1, 2, 10], [2, 2, 15]], n = 2
输出：[10, 25]
解释：
航班编号        1   2
预订记录 1 ：   10  10
预订记录 2 ：       15
总座位数：      10  25
因此，answer = [10, 25]

提示：
1 <= n <= 2 * 10^4
1 <= bookings.length <= 2 * 10^4
bookings[i].length == 3
1 <= first[i] <= last[i] <= n
1 <= seats[i] <= 10^4

*/