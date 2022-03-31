package In.House.Q2024;

public class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        return Math.max(find(chars, 'T', k), find(chars, 'F', k));
    }

    private int find(char[] chars, char target, int k) {
        int start = 0, end = 0, len = chars.length;
        int idx = 0, count = 0;
        while (chars[idx] != target) {
            ++idx;
        }
        start = idx;
        count = 1;
        while (count < k) {
            ++idx;
            if (chars[idx] != target) {
                continue;
            }
            ++idx;
        }
        end = idx;
        int result = end - start + 1;
        while (chars[idx] )
        while (end < )
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.maxConsecutiveAnswers("TTFF", 2)); // 4
        System.out.println(slt.maxConsecutiveAnswers("TFFT", 1)); // 3
        System.out.println(slt.maxConsecutiveAnswers("TTFTTFTT", 1)); // 5
    }

}
