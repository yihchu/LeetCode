package In.House.Q748;

import java.util.*;

public class Solution {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < licensePlate.length(); ++i) {
            char c = licensePlate.charAt(i);
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                continue;
            }
            c = c >= 'a' ? c : (char)(c + 32);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        Arrays.sort(words, Comparator.comparingInt(String::length));
        String result = null;
        for (String word: words) {
            Map<Character, Integer> current = (HashMap<Character, Integer>) target.clone();
            for (int i = 0 ; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (!current.containsKey(c)) {
                    continue;
                }
                int v = current.get(c);
                if (v == 1) {
                    current.remove(c);
                } else {
                    current.put(c, v - 1);
                }
            }
            if (current.size() == 0) {
                result = word;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.shortestCompletingWord("1s3 PSt", new String[] {"step", "steps", "stripe", "stepple"})); // "steps"
        System.out.println(slt.shortestCompletingWord("1s3 456", new String[] {"looks", "pest", "stew", "show"})); // "pest"
        System.out.println(slt.shortestCompletingWord("Ah71752", new String[] {"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"})); // "husband"
        System.out.println(slt.shortestCompletingWord("OgEu755", new String[] {"enough","these","play","wide","wonder","box","arrive","money","tax","thus"})); // "enough"
        System.out.println(slt.shortestCompletingWord("iMSlpe4", new String[] {"claim","consumer","student","camera","public","never","wonder","simple","thought","use"})); // "simple"
    }

}