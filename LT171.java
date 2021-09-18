public class LT171 {

    public int titleToNumber(String columnTitle) {
        int base = (int)'A' - 1, len = columnTitle.length();
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum *= 26;
            sum += (int)columnTitle.charAt(i) - base;
        }
        return sum;
    }

    public static void main(String[] args) {
        LT171 lt171 = new LT171();
        System.out.println(lt171.titleToNumber("A"));
        System.out.println(lt171.titleToNumber("AB"));
        System.out.println(lt171.titleToNumber("ZY"));
    }

}


/**
Link: https://leetcode-cn.com/problems/excel-sheet-column-number/

给定一个Excel表格中的列名称，返回其相应的列序号。
例如，
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...

示例1:
输入: "A"
输出: 1

示例2:
输入: "AB"
输出: 28

示例3:
输入: "ZY"
输出: 701

*/