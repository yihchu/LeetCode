package In.House.Q1576;

public class Solution {

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        char[] alters = new char[] {'a', 'b', 'c'};
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            if (chars[i] != '?') {
                continue;
            }
            for (int j = 0; j < 3; ++j) {
                if (i != 0 && chars[i - 1] == alters[j]) {
                    continue;
                }
                if (i != len - 1 && chars[i + 1] == alters[j]) {
                    continue;
                }
                chars[i] = alters[j];
                break;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.modifyString("?zs")); // azs
        System.out.println(slt.modifyString("ubv?w")); // "ubvaw"
        System.out.println(slt.modifyString("j?qg??b")); // "jaqgacb"
        System.out.println(slt.modifyString("??yw?ipkj?")); // "acywaipkja"
    }

}
