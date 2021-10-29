package In.House.Q815;

import java.util.*;

public class Solution {

//    // 超时~
//    public int numBusesToDestination(int[][] routes, int source, int target) {
//        if (source == target) {
//            return 0;
//        }
//        boolean[] flags = new boolean[routes.length];
//        Arrays.fill(flags, false);
//        int result =  numBusesToDestination(routes, flags, source, target);
//        return result > 500 ? -1 : result;
//    }
//
//    private int numBusesToDestination(int[][] routes, boolean[] flags, int source, int target) {
//        if (source == target) {
//            return 0;
//        }
//        int len = flags.length;
//        int min = 501;
//        for (int i = 0; i < len; ++i) {
//            if (flags[i]) {
//                continue;
//            }
//            int[] stops = routes[i];
//            for (int j = 0; j < stops.length; ++j) {
//                if (stops[j] == source) {
//                    flags[i] = true;
//                    for (int k = 0; k < stops.length; ++k) {
//                        if (k == j) {
//                            continue;
//                        }
//                        int num = numBusesToDestination(routes, flags, stops[k], target);
//                        min = min > num ? num : min;
//                    }
//                    flags[i] = false;
//                    break;
//                }
//            }
//            if (min == -1) {
//                return 501;
//            }
//        }
//        return 1 + min;
//    }
//    // -------------

//    // 还是超时呢
//    public int numBusesToDestination(int[][] routes, int source, int target) {
//        if (source == target) {
//            return 0;
//        }
//        Map<Integer, Set<Integer>> buses = new HashMap<>();
//        int len = routes.length;
//        for (int i = 0; i < len; ++i) {
//            buses.put(i, Arrays.stream(routes[i]).boxed().collect(Collectors.toSet()));
//        }
//        int min = Integer.MAX_VALUE;
//        for (Map.Entry<Integer, Set<Integer>> entry: buses.entrySet()) {
//            if (entry.getValue().contains(source)) {
//                int r = findBusRoute(buses, new HashSet<>(){{add(entry.getKey());}}, entry.getKey(), target);
//                min = min > r ? r : min;
//            }
//        }
//        return min == Integer.MAX_VALUE ? -1 : min;
//    }
//
//    private int findBusRoute(Map<Integer, Set<Integer>> buses, Set<Integer> blackBuses, int bus, int target) {
//        if (buses.get(bus).contains(target)) {
//            return 1;
//        }
//        int min = Integer.MAX_VALUE;
//        for (Map.Entry<Integer, Set<Integer>> entry: buses.entrySet()) {
//            if (blackBuses.contains(entry.getKey())) {
//                continue;
//            }
//            if (!entry.getValue().stream().anyMatch(v -> buses.get(bus).contains(v))) {
//                continue;
//            }
//            Set<Integer> passed = new HashSet<>();
//            for (Integer b: blackBuses) {
//                passed.addAll(buses.get(b));
//            }
//            if (passed.containsAll(entry.getValue())) {
//                continue;
//            }
//            blackBuses.add(entry.getKey());
//            int r = findBusRoute(buses, blackBuses, entry.getKey(), target);
//            blackBuses.remove(entry.getKey());
//            min = min > r ? r : min;
//        }
//        return min == Integer.MAX_VALUE ? min : min + 1;
//    }

////    第一个通过版本
//    public int numBusesToDestination(int[][] routes, int source, int target) {
//        if (source == target) {
//            return 0;
//        }
//        int len = routes.length;
//        int[][] map = new int[len][len];
//        Set<Integer> departs = new HashSet<>();
//        Set<Integer> arrives = new HashSet<>();
//        HashMap<Integer, Set<Integer>> buses = new HashMap<>();
//        for (int i = 0; i < len; ++i) {
//            Set<Integer> s = Arrays.stream(routes[i]).boxed().collect(Collectors.toSet());
//            if (s.contains(source)) {
//                departs.add(i);
//            }
//            if (s.contains(target)) {
//                arrives.add(i);
//            }
//            buses.put(i, s);
//        }
//        if (departs.isEmpty() || arrives.isEmpty()) {
//            return -1;
//        }
//        for (int i = 0; i < len - 1; ++i) {
//            for (int j = i + 1; j < len; ++j) {
//                Set<Integer> s1 = buses.get(i);
//                Set<Integer> s2 = buses.get(j);
//                if (s1.stream().anyMatch(stop -> s2.contains(stop))) {
//                    map[i][j] = 1;
//                    map[j][i] = 1;
//                }
//            }
//        }
//        int min = Integer.MAX_VALUE;
//        for (Integer t: arrives) {
//            int c = findWay(map, departs, t);
//            min = min > c ? c : min;
//        }
//        return min == Integer.MAX_VALUE ? -1 : min;
//    }
//
//    private int findWay(int[][] map, Set<Integer> starts, int target) {
//        int idx = 1, len = map.length;
//        if (starts.contains(target)) {
//            return idx;
//        }
//        Set<Integer> passed = new HashSet<>();
//        Queue<Integer> q = new LinkedList<>();
//        q.addAll(starts);
//        while (true) {
//            Queue<Integer> t = new LinkedList<>();
//            while (!q.isEmpty()) {
//                Integer stop = q.poll();
//                if (stop == target) {
//                    return idx;
//                }
//                if (passed.contains(stop)) {
//                    continue;
//                }
//                for (int i = 0; i < len; ++i) {
//                    if (map[stop][i] > 0) {
//                        t.add(i);
//                    }
//                }
//                passed.add(stop);
//            }
//            ++idx;
//            if (!t.isEmpty()) {
//                q = t;
//            } else {
//                break;
//            }
//        }
//        return Integer.MAX_VALUE;
//    }

    // 优化了一下，但是内存占用高了，虽然时间消耗略减，但是得不偿失
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int len = routes.length;
        int[][] map = new int[len][len];
        Set<Integer> departs = new HashSet<>();
        Set<Integer> arrives = new HashSet<>();
        HashMap<Integer, Set<Integer>> buses = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            Set<Integer> s = new HashSet<>();
            for (int stop: routes[i]) {
                if (stop == source) departs.add(i);
                if (stop == target) arrives.add(i);
                s.add(stop);
            }
            buses.put(i, s);
        }
        if (departs.isEmpty() || arrives.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < len - 1; ++i) {
            for (int j = i + 1; j < len; ++j) {
                Set<Integer> s1 = buses.get(i);
                Set<Integer> s2 = buses.get(j);
                if (s1.stream().anyMatch(stop -> s2.contains(stop))) {
                    map[i][j] = 1;
                    map[j][i] = 1;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer t: arrives) {
            int c = findWay(map, departs, t, min);
            min = min > c ? c : min;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int findWay(int[][] map, Set<Integer> starts, int target, int thres) {
        int idx = 1, len = map.length;
        if (starts.contains(target)) {
            return idx;
        }
        Set<Integer> passed = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.addAll(starts);
        while (true) {
            Queue<Integer> t = new LinkedList<>();
            while (!q.isEmpty()) {
                Integer stop = q.poll();
                if (stop == target) {
                    return idx;
                }
                if (passed.contains(stop)) {
                    continue;
                }
                for (int i = 0; i < len; ++i) {
                    if (map[stop][i] > 0) {
                        t.add(i);
                    }
                }
                passed.add(stop);
            }
            ++idx;
            if (idx >= thres) {
                break;
            }
            if (!t.isEmpty()) {
                q = t;
            } else {
                break;
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Solution slt = new Solution();
        System.out.println(slt.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6)); // 2
        System.out.println(slt.numBusesToDestination(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}}, 15, 12)); // -1
        for (int i = 0; i < 100; ++i) // 80 - 100
        System.out.println(slt.numBusesToDestination(new int[][]{{3, 16, 33, 45, 59, 79, 103, 135}, {3, 35, 39, 54, 56, 78, 96, 101, 120, 132, 146, 148}, {13, 72, 98}, {37, 70, 107}, {0, 12, 31, 37, 41, 68, 78, 94, 100, 101, 113, 123}, {11, 32, 52, 85, 135}, {43, 50, 128}, {0, 13, 49, 51, 53, 55, 60, 65, 66, 80, 82, 87, 92, 99, 112, 118, 120, 125, 128, 131, 137}, {15, 19, 34, 37, 45, 52, 56, 97, 108, 123, 142}, {7, 9, 20, 28, 29, 33, 34, 38, 43, 46, 47, 48, 53, 59, 65, 72, 74, 80, 88, 92, 110, 111, 113, 119, 135, 140}, {15, 41, 64, 83}, {7, 13, 26, 31, 57, 85, 101, 108, 110, 115, 119, 124, 149}, {47, 61, 67, 70, 74, 75, 77, 84, 92, 101, 124, 132, 133, 142, 147}, {0, 2, 5, 6, 12, 18, 34, 37, 47, 58, 77, 98, 99, 109, 112, 131, 135, 149}, {6, 7, 8, 9, 14, 17, 21, 25, 33, 40, 45, 50, 56, 57, 58, 60, 68, 92, 93, 100, 108, 114, 130, 149}, {7}, {5, 16, 22, 48, 77, 82, 108, 114, 124}, {34, 71}, {8, 16, 32, 48, 104, 108, 116, 134, 145}, {3, 10, 16, 19, 35, 45, 64, 74, 89, 101, 116, 149}, {1, 5, 7, 10, 11, 18, 40, 45, 50, 51, 52, 54, 55, 69, 71, 81, 82, 83, 85, 89, 96, 100, 114, 115, 124, 134, 138, 148}, {0, 2, 3, 5, 6, 9, 15, 52, 64, 103, 108, 114, 146}, {5, 33, 39, 40, 44, 45, 66, 67, 68, 69, 84, 102, 106, 115, 120, 128, 133}, {17, 26, 49, 50, 55, 58, 60, 65, 88, 90, 102, 121, 126, 130, 137, 139, 144}, {6, 12, 13, 37, 41, 42, 48, 50, 51, 55, 64, 65, 68, 70, 73, 102, 106, 108, 120, 123, 126, 127, 129, 135, 136, 149}, {6, 7, 12, 33, 37, 41, 47, 53, 54, 80, 107, 121, 126}, {15, 75, 91, 103, 107, 110, 125, 139, 142, 149}, {18, 24, 30, 52, 61, 64, 75, 79, 85, 95, 100, 103, 105, 111, 128, 129, 142}, {3, 14, 18, 32, 45, 52, 57, 63, 68, 78, 85, 91, 100, 104, 111, 114, 142}, {4, 7, 11, 20, 21, 31, 32, 33, 48, 61, 62, 65, 66, 73, 80, 92, 93, 97, 99, 108, 112, 116, 136, 139}}, 85, 112));
        System.out.println(">>>>> cost " + (System.currentTimeMillis() - start));
    }

}


/**
Link: https://leetcode-cn.com/problems/bus-routes/

给你一个数组routes，表示一系列公交线路，其中每个routes[i]表示一条公交线路，第i辆公交车将会在上面循环行驶。
例如，路线routes[0] = [1, 5, 7]表示第0辆公交车会一直按序列1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ...这样的车站路线行驶。
现在从source车站出发（初始时不在公交车上），要前往target车站。 期间仅可乘坐公交车。
求出最少乘坐的公交车数量。如果不可能到达终点车站，返回-1 。

示例1：
输入：routes = [[1, 2, 7], [3, 6, 7]], source = 1, target = 6
输出：2
解释：最优策略是先乘坐第一辆公交车到达车站7, 然后换乘第二辆公交车到车站6。

示例2：
输入：routes = [[7, 12], [4, 5, 15], [6], [15, 19], [9, 12, 13]], source = 15, target = 12
输出：-1

提示：
1 <= routes.length <= 500.
1 <= routes[i].length <= 10^5
routes[i]中的所有值互不相同
sum(routes[i].length) <= 10^5
0 <= routes[i][j] < 10^6
0 <= source, target < 10^6
*/
