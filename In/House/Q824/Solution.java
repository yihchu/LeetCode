package In.House.Q824;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String toGoatLatin(String sentence) {
        Set<Character> set = new HashSet<>() {{
            add('a'); add('e'); add('i'); add('o'); add('u');
            add('A'); add('E'); add('I'); add('O'); add('U');
        }};
        String[] array = sentence.split(" ");

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            if (i > 0) {
                builder.append(" ");
            }
            char first = array[i].charAt(0);
            if (set.contains(first)) {
                builder.append(array[i]);
            } else {
                builder.append(array[i].substring(1)).append(first);
            }
            builder.append("ma");
            for (int j = 0; j <= i; ++j) {
                builder.append('a');
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.toGoatLatin("I speak Goat Latin")); // "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
        System.out.println(slt.toGoatLatin("The quick brown fox jumped over the lazy dog")); // "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
    }

}
