package In.House.Q1108;

public class Solution {

//    public String defangIPaddr(String address) {
//        return address.replaceAll("\\.", "[\\.]");
//    }

    public String defangIPaddr(String address) {
        int len = address.length(), idx = 0;
        char[] chars = new char[len + 6], origin = address.toCharArray();
        for (char c: origin) {
            if (c != '.') {
                chars[idx ++] = c;
                continue;
            }
            chars[idx ++] = '[';
            chars[idx ++] = c;
            chars[idx ++] = ']';
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.defangIPaddr("1.1.1.1")); // 1[.]1[.]1[.]1"
        System.out.println(slt.defangIPaddr("255.100.50.0")); // "255[.]100[.]50[.]0"
    }
}
