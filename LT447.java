import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LT447 {

    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int j = 0; j < points.length; ++j) {
                if (i == j) {
                    continue;
                }
                int w = points[j][0] - points[i][0], h = points[j][1] - points[i][1];
                int d = w * w + h * h;
                if (!map.containsKey(d)) {
                    map.put(d, new LinkedList<>());
                }
                map.get(d).add(points[j]);
            }
            for (List<int[]> l: map.values()) {
                if (l.size() < 2) {
                    continue;
                }
                result += l.size() * (l.size() - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LT447 lt447 = new LT447();
        System.out.println(lt447.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}})); // 2
        System.out.println(lt447.numberOfBoomerangs(new int[][]{{1, 1}, {2, 2}, {3, 3}})); // 2
        System.out.println(lt447.numberOfBoomerangs(new int[][]{{1, 1}})); // 0
    }

}


/**
Link: https://leetcode-cn.com/problems/number-of-boomerangs/

给定平面上n对互不相同的点points，其中points[i] = [x[i], y[i]]。回旋镖是由点(i, j, k)表示的元组，其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
返回平面上所有回旋镖的数量。

示例1：
输入：points = [[0, 0], [1, 0], [2, 0]]
输出：2
解释：两个回旋镖为[[1, 0], [0, 0], [2, 0]]和[[1, 0], [2, 0], [0, 0]]

示例2：
输入：points = [[1, 1], [2, 2], [3, 3]]
输出：2

示例3：
输入：points = [[1, 1]]
输出：0

提示：
n == points.length
1 <= n <= 500
points[i].length == 2
-10^4 <= x[i], y[i] <= 10^4
所有点都互不相同

*/