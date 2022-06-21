package In.House.Q1108;

public class Solution {

    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[\\.]");
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.defangIPaddr("1.1.1.1")); // 1[.]1[.]1[.]1"
        System.out.println(slt.defangIPaddr("255.100.50.0")); // "255[.]100[.]50[.]0"
    }
}
