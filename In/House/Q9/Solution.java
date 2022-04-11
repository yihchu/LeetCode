package In.House.Q9;

public class Solution {

    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l ++) != str.charAt(r --)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.isPalindrome(121)); // true
        System.out.println(slt.isPalindrome(-121)); // false
        System.out.println(slt.isPalindrome(10)); // false
        System.out.println(slt.isPalindrome(-101)); // false
    }

}
