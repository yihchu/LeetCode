package In.House.Q551;

public class Solution {

    public boolean checkRecord(String s) {
        boolean A = false;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != 'A') {
                continue;
            }
            if (A) {
                return false;
            }
            A = true;
        }
        return !s.contains("LLL");
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.checkRecord("PPALLP"));
        System.out.println(slt.checkRecord("PPALLL"));
    }

}

