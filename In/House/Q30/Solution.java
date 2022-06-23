package In.House.Q30;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = words[0].length(), wordsLen = wordLen * words.length, limit = s.length() - wordsLen;
        List<Integer> result = new ArrayList<>();
        Map<String, Long> map = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> candidates = new HashMap<>();
        for (int i = 0; i <= limit; ++i) {
            String word = s.substring(i, i + wordLen);
            if (!map.containsKey(word)) {
                continue;
            }
            candidates.putAll(map);
            int tmpLimit = i + wordsLen;
            for (int j = i; j < tmpLimit; j += wordLen) {
                word = s.substring(j, j + wordLen);
                if (!candidates.containsKey(word)) {
                    break;
                }
                long count = candidates.get(word);
                if (count == 1) {
                    candidates.remove(word);
                } else {
                    candidates.put(word, count - 1);
                }
            }
            if (candidates.isEmpty()) {
                result.add(i);
            } else {
                candidates.clear();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        // [0, 9]
        slt.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"})
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        // []
        slt.findSubstring("wordgoodgoodgoodbestword", new String[] {"word", "good", "best", "word"})
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
        // [6, 9, 12]
        slt.findSubstring("barfoofoobarthefoobarman", new String[] {"bar", "foo", "the"})
                .forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}
