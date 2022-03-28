package In.House.Q846;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length, count = len / groupSize;
        if (len % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < len; ++i) {
            queue.add(hand[i]);
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        for (int i = 0; i < count; ++i) {
            int min = queue.peek();
            for (int j = 0; j < groupSize; ++j) {
                if (!map.containsKey(min)) {
                    return false;
                }
                int c = map.get(min);
                if (c == 1) {
                    map.remove(min);
                } else {
                    map.put(min, c - 1);
                }
                queue.remove(min);
                ++min;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.isNStraightHand(new int[] {1, 2, 3, 6, 2, 3, 4, 7, 8}, 3)); // true
        System.out.println(slt.isNStraightHand(new int[] {1, 2, 3, 6, 2, 3, 4, 6, 8}, 3)); // false
        System.out.println(slt.isNStraightHand(new int[] {1, 2, 3, 4, 5}, 4)); // false
        System.out.println(slt.isNStraightHand(new int[] {8, 10, 12}, 3)); // false
    }

}

