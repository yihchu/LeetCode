package In.House.Q2024;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        return Math.max(find(chars, 'T', k), find(chars, 'F', k));
    }

    private int find(char[] chars, char target, int k) {
        int len = chars.length;
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for (int i = 0; i < len; ++i) {
            if (chars[i] == target) {
                list.add(i);
            }
        }
        list.add(len);
        int count = list.size();
        if (count - 2 <= k) {
            return len;
        }
        int max = -1;
        for (int i = k + 1; i < count; ++i) {
            int tmp = (list.get(i) - 1) - (list.get(i - k - 1) + 1) + 1;
            max = Math.max(tmp, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxConsecutiveAnswers("TTFF", 2)); // 4
        System.out.println(slt.maxConsecutiveAnswers("TFFT", 1)); // 3
        System.out.println(slt.maxConsecutiveAnswers("TTFTTFTT", 1)); // 5
    }

}
