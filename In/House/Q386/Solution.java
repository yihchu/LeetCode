package In.House.Q386;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        for (int i = 1; i < 10; ++i) {
            if (i <= n) {
                result.add(i);
                findNum(i, n, result);
                continue;
            }
            break;
        }
        return result;
    }

    private void findNum(int current, int limit, List<Integer> result) {
        int tmp = current * 10;
        for (int i = 0; i < 10; ++i) {
            if (tmp + i <= limit) {
                result.add(tmp + i);
                findNum(tmp + i, limit, result);
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.lexicalOrder(13).forEach(s -> System.out.print(s + " "));
        System.out.println();
        slt.lexicalOrder(2).forEach(s -> System.out.print(s + " "));
        System.out.println();
        slt.lexicalOrder(1).forEach(s -> System.out.print(s + " "));
        System.out.println();
        slt.lexicalOrder(100).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

}
