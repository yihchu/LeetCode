package In.House.Q1447;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public List<String> simplifiedFractions(int n) {
        Set<String> result = new HashSet<>();
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                int tmp = gcd(i, j);
                result.add("" + j / tmp + "/" + i / tmp);
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    private int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        for (int i = 0; i < 100; ++i) {
            System.out.print(">>>>> n = " + i + ": ");
            slt.simplifiedFractions(i).forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }

}
