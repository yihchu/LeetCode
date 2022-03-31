package In.House.Q575;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int distributeCandies(int[] candyType) {
        int count = candyType.length;
        Set<Integer> set = new HashSet<>();
        for (int ct: candyType) {
            set.add(ct);
        }
        if (set.size() * 2 >= count) {
            return count / 2;
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.distributeCandies(new int[] {1, 1, 2, 2, 3, 3})); // 3
        System.out.println(slt.distributeCandies(new int[] {1, 1, 2, 3})); // 2
    }

}

