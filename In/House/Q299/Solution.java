package In.House.Q299;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int len = guess.length(), bulls = 0, cows = 0;
        for (int i = 0; i < len; ++i) {
            char c = secret.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean[] mask = new boolean[len];
        Arrays.fill(mask, false);
        for (int i = 0; i < len; ++i) {
            char cc = secret.charAt(i);
            char c = guess.charAt(i);
            if (c == cc) {
                ++bulls;
                map.put(c, map.get(c) - 1);
                mask[i] = true;
            }
        }
        for (int i = 0; i < len; ++i) {
            if (mask[i]) {
                continue;
            }
            char c = guess.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) {
                ++cows;
                map.put(c, map.get(c) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.getHint("1807", "7810")); // 1A3B
        System.out.println(slt.getHint("1123", "0111")); // 1A1B
        System.out.println(slt.getHint("1", "0")); // 0A0B
        System.out.println(slt.getHint("1", "1")); // 1A0B
        System.out.println(slt.getHint("1122", "1222")); // "3A0B"
    }

}

