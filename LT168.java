import java.util.HashMap;

public class LT168 {

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
        LT168 lt168 = new LT168();
        System.out.println(lt168.convertToTitle(1)); // A
        System.out.println(lt168.convertToTitle(28)); // AB
        System.out.println(lt168.convertToTitle(701)); // ZY
        System.out.println(lt168.convertToTitle(2147483647)); // FXSHRXW
        System.out.println(lt168.convertToTitle(52)); // AZ
    }

}


/**
Link: https://leetcode-cn.com/problems/excel-sheet-column-title/

给定一个正整数，返回它在Excel表中相对应的列名称。

例如，
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...

示例1:
输入: 1
输出: "A"

示例2:
输入: 28
输出: "AB"

示例3:
输入: 701
输出: "ZY"

*/