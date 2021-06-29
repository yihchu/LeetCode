import java.util.HashMap;
import java.util.Map;

public class LT149 {

    private final static int MAGIC_NUMBER = 20001;

    public int maxPoints(int[][] points) {
        int len = points.length, max = -1;
        if (len < 3) {
            return len;
        }
        for (int i = 0; i < len - 2; ++i) {
            if (max > len - i - 1) {
                continue;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < len; ++j) {
                int y = points[j][1] - points[i][1];
                int x = points[j][0] - points[i][0];
                int product = x * y;
                if (product < 0) {
                    x = x > 0 ? -x : x;
                    y = y > 0 ? y : -y;
                } else {
                    x = Math.abs(x);
                    y = Math.abs(y);
                }
                if (product != 0) {
                    int c = gcd(Math.abs(x), Math.abs(y));
                    y /= c;
                    x /= c;
                } else {
                    x = x == 0 ? x : 1;
                    y = y == 0 ? y : 1;
                }
                if (x == y) {
                    x = y = 1;
                }
                int key = x * MAGIC_NUMBER + y;
                map.put(key, map.getOrDefault(key, 1) + 1);
            }
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                max = max < entry.getValue() ? entry.getValue() : max;
            }
        }
        return max;
    }

    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    public static void main(String[] args) {
        LT149 lt149 = new LT149();
        System.out.println(lt149.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}})); // 3
        System.out.println(lt149.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}})); // 4
        System.out.println(lt149.maxPoints(new int[][]{{0,0}})); // 1
        System.out.println(lt149.maxPoints(new int[][]{{4,5}, {4,-1}, {4,0}})); // 3
        System.out.println(lt149.maxPoints(new int[][]{{9,-25}, {-4,1}, {-1,5}, {-7,7}})); // 3
        System.out.println(lt149.maxPoints(new int[][]{{0,0}, {2,2}, {-1,-1}})); // 3
        System.out.println(lt149.maxPoints(new int[][]{{0,9}, {-161,-481}, {230, 709}, {-30,-102}})); // 3
        System.out.println(lt149.maxPoints(
                new int[][]{{-184,-551}, {-105,-467}, {-90,-394}, {-60,-248}, {115,359}, {138,429}, {60,336}, {150,774}
                , {207,639}, {-150,-686}, {-135,-613}, {92,289}, {23,79}, {135,701}, {0,9}, {-230,-691}, {-115,-341}
                , {-161,-481}, {230,709}, {-30,-102}})); // 11
    }

}

/*
* 给你一个数组 points ，其中 points[i] = [x[i], y[i]] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。

示例 1：
输入：points = [[1,1],[2,2],[3,3]]
输出：3

示例 2：
输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
输出：4

提示：
1 <= points.length <= 300
points[i].length == 2
-10^4 <= x[i], y[i] <= 10^4
points中的所有点互不相同
*
*/