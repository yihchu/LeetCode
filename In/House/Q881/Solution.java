package In.House.Q881;

import java.util.Arrays;

public class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        int l = 0, r = len - 1, count = len;
        while (r > l) {
            if (people[l] + people[r] > limit) {
                --r;
                continue;
            }
            --count;
            ++l;
            --r;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numRescueBoats(new int[]{1, 2}, 3)); // 1
        System.out.println(slt.numRescueBoats(new int[]{3, 2, 2, 1}, 3)); // 3
        System.out.println(slt.numRescueBoats(new int[]{3, 5, 3, 4}, 5)); // 4
    }

}
