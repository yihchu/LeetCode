package In.House.Q168;

import java.util.HashMap;

public class Solution {

    HashMap<Integer, Character> map = new HashMap<>(){
        {
            put(1, 'A');
            put(2, 'B');
            put(3, 'C');
            put(4, 'D');
            put(5, 'E');
            put(6, 'F');
            put(7, 'G');
            put(8, 'H');
            put(9, 'I');
            put(10, 'J');
            put(11, 'K');
            put(12, 'L');
            put(13, 'M');
            put(14, 'N');
            put(15, 'O');
            put(16, 'P');
            put(17, 'Q');
            put(18, 'R');
            put(19, 'S');
            put(20, 'T');
            put(21, 'U');
            put(22, 'V');
            put(23, 'W');
            put(24, 'X');
            put(25, 'Y');
            put(26, 'Z');
        }
    };

    private final static int MAGIC_NUMBER = 26;

    public String convertToTitle(int columnNumber) {
        String result = "";
        if (columnNumber <= 0) {
            return result;
        }
        while (columnNumber > MAGIC_NUMBER) {
            result += convertToTitle((columnNumber - 1) / MAGIC_NUMBER);
            columnNumber %= MAGIC_NUMBER;
        }
        result += map.get(columnNumber == 0 ? 26 : columnNumber);
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.convertToTitle(1)); // A
        System.out.println(slt.convertToTitle(28)); // AB
        System.out.println(slt.convertToTitle(701)); // ZY
        System.out.println(slt.convertToTitle(2147483647)); // FXSHRXW
        System.out.println(slt.convertToTitle(52)); // AZ
    }

}

