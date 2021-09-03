import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LT17_14 {

    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int len = arr.length;
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; ++i) {
            queue.add(arr[i]);
        }
        for (int i = k; i < len; ++i) {
            if (queue.peek() <= arr[i]) {
                continue;
            }
            queue.poll();
            queue.add(arr[i]);
        }
        return queue.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        LT17_14 lt17_14 = new LT17_14();
        Arrays.stream(lt17_14.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)).forEach(a -> System.out.print(a));
        System.out.println();
        Arrays.stream(lt17_14.smallestK(new int[]{}, 0)).forEach(a -> System.out.print(a));
        System.out.println();
        Arrays.stream(lt17_14.smallestK(new int[]{1, 2, 3}, 0)).forEach(a -> System.out.print(a));
        System.out.println();
    }

}


/*
设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

示例：
输入： arr = [1, 3, 5, 7, 2, 4, 6, 8], k = 4
输出： [1, 2, 3, 4]
提示：

0 <= len(arr) <= 100000
0 <= k <= min(100000, len(arr))
*/