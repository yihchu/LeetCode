package In.House.Q1405;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder builder = new StringBuilder();
        Pair[] pairs = {
            new Pair(a, 'a'),
            new Pair(b, 'b'),
            new Pair(c, 'c')
        };
        while (true) {
            Arrays.sort(pairs, Comparator.comparingInt(p -> - p.count));
            boolean hasNext = false;
            for (Pair pair: pairs) {
                if (pair.count <= 0) {
                    break;
                }
                int l = builder.length();
                if (l >= 2 && builder.charAt(l - 2) == pair.c && builder.charAt(l - 1) == pair.c) {
                    continue;
                }
                hasNext = true;
                builder.append(pair.c);
                -- pair.count;
                break;
            }
            if (!hasNext) {
                break;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.longestDiverseString(1, 1, 7)); // "ccaccbcc" / "ccbccacc"
        System.out.println(slt.longestDiverseString(2, 2, 1)); // "aabbc"
        System.out.println(slt.longestDiverseString(7, 1, 0)); // "aabaa"
    }

}

class Pair {
    int count;
    char c;

    public Pair(int count, char c) {
        this.count = count;
        this.c = c;
    }
}
