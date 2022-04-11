package In.House.Q71;

import java.util.LinkedList;

public class Solution {

    private final String EMPTY = "";
    private final String CURRENT = ".";
    private final String FORWARD = "..";

    public String simplifyPath(String path) {
        String[] array = path.split("/");
        LinkedList<String> list = new LinkedList<>();
        for (String str: array) {
            if (EMPTY.equals(str) || CURRENT.equals(str)) {
                continue;
            }
            if (FORWARD.equals(str)) {
                if (!list.isEmpty()) {
                    list.removeLast();
                }
                continue;
            }
            list.add(str);
        }
        StringBuilder builder = new StringBuilder();
        for (String str: list) {
            builder.append("/").append(str);
        }
        String str = builder.toString();
        return str.isEmpty() ? "/" : str;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.simplifyPath("/home/")); // "/home"
        System.out.println(slt.simplifyPath("/../")); // "/"
        System.out.println(slt.simplifyPath("/home//foo/")); // "/home/foo"
        System.out.println(slt.simplifyPath("/a/./b/../../c/")); // "/c"
    }

}

