package In.House.Q6;

public class Solution {

    public String convert(String s, int numRows) {
        int len = s.length(), maxGap = Math.max((numRows - 1) * 2, 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            int tmp = numRows - i - 1;
            int gap1 = (tmp - 1) * 2 + 1 + 1, gap2 = maxGap - gap1;
            gap1 = (gap1 == 0 ? gap2 : gap1);
            gap2 = (gap2 == 0 ? gap1 : gap2);
            boolean flag = true;
            for (int j = i; j < len; ) {
                builder.append(s.charAt(j));
                j += (flag ? gap1 : gap2);
                flag = !flag;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
        System.out.println(slt.convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
        System.out.println(slt.convert("A", 1)); // A
    }

}

