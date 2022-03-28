package In.House.Q1518;

public class Solution {

    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles, left = numBottles;
        while (left >= numExchange) {
            int tmp = left / numExchange;
            result += tmp;
            left = left % numExchange + tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numWaterBottles(9, 3)); // 13
        System.out.println(slt.numWaterBottles(15, 4)); // 19
        System.out.println(slt.numWaterBottles(5, 5)); // 6
        System.out.println(slt.numWaterBottles(2, 3)); // 2
    }
}


