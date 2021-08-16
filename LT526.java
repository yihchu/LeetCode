import java.util.*;

public class LT526 {

    public int countArrangement(int n) {
        int[] mask = new int[n];
        return findArrangement(n, n, mask);
    }


    public int findArrangement(int pos, int n, int[] mask) {
        if (pos == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = n; i > 0; --i) {
            if (mask[i - 1] > 0) {
                continue;
            }
            if (pos % i == 0 || i % pos == 0) {
                mask[i - 1] = 1;
                sum += findArrangement(pos - 1, n, mask);
                mask[i - 1] = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LT526 lt526 = new LT526();
//        System.out.println(lt526.countArrangement(2)); // 2
        System.out.println(lt526.countArrangement(4)); // 8
    }

}

/*

假设有从1到N的N个整数，如果从这N个数字中成功构造出一个数组，使得数组的第i位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。

条件：
第i位的数字能被i整除
i能被第i位上的数字整除
现在给定一个整数N，请问可以构造多少个优美的排列？

示例1:
输入: 2
输出: 2

解释:
第1个优美的排列是[1, 2]:
  第1个位置（i = 1）上的数字是1，1能被i（i = 1）整除
  第2个位置（i = 2）上的数字是2，2能被i（i = 2）整除

第2个优美的排列是[2, 1]:
  第1个位置（i = 1）上的数字是2，2能被i（i = 1）整除
  第2个位置（i = 2）上的数字是1，i（i = 2）能被1整除

说明:
N是一个正整数，并且不会超过15。

*/
