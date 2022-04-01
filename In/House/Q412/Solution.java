package In.House.Q412;

import java.util.ArrayList;
import java.util.List;

public class Solution {

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
        Solution slt = new Solution();
        slt.fizzBuzz(15).forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

}

