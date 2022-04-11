package In.House.Q68;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int left = maxWidth, len = words.length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; ) {
            String word = words[i];
            int l = (left == maxWidth ? word.length() : 1 + word.length());
            if (left >= l) {
                if (left != maxWidth) {
                    builder.append(" ");
                }
                builder.append(word);
                left -= l;
                ++i;
            } else {
                String[] array = builder.toString().split(" ");
                if (array.length == 1) {
                    result.add(array[0] + getSpaces(maxWidth - array[0].length()));
                } else {
                    String spaces = getSpaces(left / (array.length - 1) + 1);
                    left %= (array.length - 1);
                    StringBuilder b = new StringBuilder();
                    b.append(array[0]);
                    for (int j = 1; j < array.length; ++j) {
                        b.append(spaces);
                        if (left > 0) {
                            b.append(" ");
                            --left;
                        }
                        b.append(array[j]);
                    }
                    result.add(b.toString());
                }

                left = maxWidth;
                builder = new StringBuilder();
            }
        }
        String str = builder.toString();
        if (!str.equals("")) {
            result.add(str + getSpaces(maxWidth - str.length()));
        }
        return result;
    }

    private String getSpaces(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(">>>>>>>>>> test-1");
        slt.fullJustify(new String[] {
                "This", "is", "an", "example", "of", "text", "justification."
        }, 16).stream().forEach(str -> System.out.println("*" + str + "*"));
        System.out.println("<<<<<<<<<<");
        System.out.println();
        System.out.println(">>>>>>>>>> test-2");
        slt.fullJustify(new String[]{
                "What", "must", "be", "acknowledgment", "shall", "be"
        }, 16).stream().forEach(str -> System.out.println("*" + str + "*"));
        System.out.println("<<<<<<<<<<");
        System.out.println();
        System.out.println(">>>>>>>>>> test-3");
        slt.fullJustify(new String[]{
                "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"
        }, 20).stream().forEach(str -> System.out.println("*" + str + "*"));
        System.out.println("<<<<<<<<<<");
    }

}


