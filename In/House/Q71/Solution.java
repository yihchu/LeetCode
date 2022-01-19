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

/**
Ques: 简化路径
Link: https://leetcode-cn.com/problems/simplify-path/

给你一个字符串path，表示指向某一文件或目录的Unix风格绝对路径（以'/'开头），请你将其转化为更加简洁的规范路径。
在Unix风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点（..）表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
任意多个连续的斜杠（即，'//'）都被视为单个斜杠'/'。对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。

请注意，返回的规范路径必须遵循下述格式：
始终以斜杠'/'开头。
两个目录名之间必须只有一个斜杠'/'。
最后一个目录名（如果存在）不能以'/'结尾。
此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含'.'或'..'）。
返回简化后得到的规范路径。

示例1：
输入：path = "/home/"
输出："/home"
解释：注意，最后一个目录名后面没有斜杠。

示例2：
输入：path = "/../"
输出："/"
解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。

示例3：
输入：path = "/home//foo/"
输出："/home/foo"
解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。

示例4：
输入：path = "/a/./b/../../c/"
输出："/c"

提示：
1 <= path.length <= 3000
path由英文字母，数字，'.'，'/'或'_'组成。
path是一个有效的Unix风格绝对路径。

*/