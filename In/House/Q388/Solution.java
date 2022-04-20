package In.House.Q388;

public class Solution {

    private final static String REGEX_SUFFIX = "(?!\t)";

    public int lengthLongestPath(String input) {
        String[] arr = input.split("\n" + REGEX_SUFFIX);
        int result = 0;
        for (String str: arr) {
            int tmp = findLongestPath(str, "\n\t");
            result = result < tmp ? tmp : result;
        }
        return result;
    }

    private int findLongestPath(String input, String regex) {
        String[] arr = input.split(regex + REGEX_SUFFIX);
        if (arr.length == 1) {
            return input.contains(".") ? input.length() : 0;
        }
        int max = 0;
        String newRegex = regex + '\t';
        for (int i = 1; i < arr.length; ++i) {
            int tmp = findLongestPath(arr[i], newRegex);
            max = max < tmp ? tmp : max;
        }
        return max == 0 ? 0 : arr[0].length() + max + 1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext")); // 20
        System.out.println(slt.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext")); // 32
        System.out.println(slt.lengthLongestPath("a")); // 0
        System.out.println(slt.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt")); // 12
        System.out.println(slt.lengthLongestPath("a\n\tb\n\t\tc")); // 0
    }

}
