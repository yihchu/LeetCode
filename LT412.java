import java.util.ArrayList;
import java.util.List;

public class LT412 {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            int m3 = i % 3, m5 = i % 5;
            if (m3 == 0 && m5 == 0) {
                result.add("FizzBuzz");
            } else if (m3 == 0) {
                result.add("Fizz");
            } else if (m5 == 0) {
                result.add("Buzz");
            } else {
                result.add("" + i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LT412 lt412 = new LT412();
        lt412.fizzBuzz(15).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}

/**
Link: https://leetcode-cn.com/problems/fizz-buzz/

写一个程序，输出从1到n数字的字符串表示。
1. 如果n是3的倍数，输出“Fizz”；
2. 如果n是5的倍数，输出“Buzz”；
3. 如果n同时是3和5的倍数，输出 “FizzBuzz”。

示例：
n = 15, 返回:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
*/