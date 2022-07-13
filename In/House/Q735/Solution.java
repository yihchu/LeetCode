package In.House.Q735;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        for (int i = 1; i < len; ++i) {
            if (asteroids[i] >= 0) {
                continue;
            }
            int cur = asteroids[i];
            for (int j = i - 1; j > -1; --j) {
                if (asteroids[j] < 0) {
                    break;
                }
                asteroids[j + 1] = 0;
                asteroids[j] = Math.abs(cur) > asteroids[j] ? cur : Math.abs(cur) == asteroids[j] ? 0 : asteroids[j];
                cur = asteroids[j];
                if (cur >= 0) {
                    break;
                }
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < len; ++i) {
            if (asteroids[i] == 0) {
                continue;
            }
            list.add(asteroids[i]);
        }
        return list.stream().mapToInt(a -> a).toArray();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.asteroidCollision(new int[] {5, 10, -5})).forEach(a -> System.out.print(a + " "));
        System.out.println(); // [5, 10]
        Arrays.stream(slt.asteroidCollision(new int[] {8, -8})).forEach(a -> System.out.print(a + " "));
        System.out.println(); // []
        Arrays.stream(slt.asteroidCollision(new int[] {10, 2, -5})).forEach(a -> System.out.print(a + " "));
        System.out.println(); // [10]
        Arrays.stream(slt.asteroidCollision(new int[] {5, 10, -50, 1})).forEach(a -> System.out.print(a + " "));
        System.out.println(); // [-50, 1]
    }

}
