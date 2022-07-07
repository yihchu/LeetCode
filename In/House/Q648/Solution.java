package In.House.Q648;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {
        dictionary = new ArrayList<>(dictionary);
        Collections.sort(dictionary);
        dictionary.sort(Comparator.comparingInt(word -> word.length()));
        StringBuilder builder = new StringBuilder();
        String[] strs = sentence.split(" ");
        int len = strs.length;
        builder.append(doReplace(dictionary, strs[0]));
        for (int i = 1; i < len; ++i) {
            builder.append(' ');
            builder.append(doReplace(dictionary, strs[i]));
        }
        return builder.toString();
    }

    private String doReplace(List<String> dictionary, String str) {
        for (String prefix: dictionary) {
            if (!str.startsWith(prefix)) {
                continue;
            }
            return prefix;
        }
        return str;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery")); // "the cat was rat by the bat"
        System.out.println(slt.replaceWords(List.of("a", "b", "c"), "aadsfasf absbs bbab cadsfafs")); // "a a b c"
    }
}
