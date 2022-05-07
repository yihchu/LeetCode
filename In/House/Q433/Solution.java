package In.House.Q433;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private final static int LEN = 8;

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        int len = bank.length;
        int[][] map = new int[len][len];
        for (int i = 0; i < len; ++i) {
            map[i][i] = 0;
            for (int j = i + 1; j < len; ++j) {
                int tmp = calcDistance(bank[i], bank[j]);
                map[i][j] = tmp;
                map[j][i] = tmp;
            }
        }
        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < len; ++i) {
            if (startIdx < 0 && start.equals(bank[i])) {
                startIdx = i;
            }
            if (endIdx < 0 && end.equals(bank[i])) {
                endIdx = i;
            }
        }
        boolean[] mask = new boolean[len];
        Queue<Integer> queue = new LinkedList<>(), tmpQueue;
        Arrays.fill(mask, false);
        int turns = 0;
        if (startIdx < 0) {
            turns = 1;
            for (int i = 0; i < len; ++i) {
                if (calcDistance(start, bank[i]) > 1) {
                    continue;
                }
                if (bank[i].equals(end)) {
                    return turns;
                }
                mask[i] = true;
                queue.add(i);
            }
        } else {
            queue.add(startIdx);
            mask[startIdx] = true;
        }
        if (queue.isEmpty()) {
            return -1;
        }
        while (true) {
            tmpQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int idx = queue.poll();
                for (int i = 0; i < len; ++i) {
                    if (mask[i] || map[idx][i] > 1) {
                        continue;
                    }
                    if (i == endIdx) {
                        return turns + 1;
                    }
                    mask[i] = true;
                    tmpQueue.add(i);
                }
            }
            if (tmpQueue.isEmpty()) {
                break;
            }
            ++ turns;
            queue = tmpQueue;
        }
        return -1;
    }

    private int calcDistance(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < LEN; ++i) {
            if (str1.charAt(i) == str2.charAt(i)) {
                continue;
            }
            ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(slt.minMutation("AACCGGTT", "AACCGGTA", new String[] {"AACCGGTA"})); // 1
        System.out.println(slt.minMutation("AACCGGTT", "AAACGGTA", new String[] {"AACCGGTA", "AACCGCTA", "AAACGGTA"})); // 2
        System.out.println(slt.minMutation("AAAAACCC", "AACCCCCC", new String[] {"AAAACCCC", "AAACCCCC", "AACCCCCC"})); // 3
        System.out.println(slt.minMutation("AAAAAAAA", "CCCCCCCC", new String[] {"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA"})); // -1
        System.out.println(">>>>> cost " + (System.currentTimeMillis() - start) + " ms.");
    }

}