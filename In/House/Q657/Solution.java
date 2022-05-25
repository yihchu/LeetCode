package In.House.Q657;

import java.util.*;

public class Solution {

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        int row = forest.size(), col = forest.get(0).size();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[] {i, j});
                }
            }
        }
        Collections.sort(trees, Comparator.comparingInt(a -> forest.get(a[0]).get(a[1])));
        int currentX = 0, currentY = 0;
        int result = 0;
        for (int i = 0; i < trees.size(); ++i) {
            int steps = bfs(forest, currentX, currentY, trees.get(i)[0], trees.get(i)[1]);
            if (steps < 0) {
                return -1;
            }
            result += steps;
            currentX = trees.get(i)[0];
            currentY = trees.get(i)[1];
        }
        return result;
    }

    public int bfs(List<List<Integer>> forest, int startX, int startY, int targetX, int targetY) {
        if (startX == targetX && startY == targetY) {
            return 0;
        }
        int row = forest.size(), col = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {0, startX * col + startY});
        boolean[][] visited = new boolean[row][col];
        visited[startX][startY] = true;
        while (!pq.isEmpty()) {
            int[] array = pq.poll();
            int steps = array[0], position = array[1];
            for (int j = 0; j < 4; ++j) {
                int nextX = position / col + directions[j][0];
                int nextY = position % col + directions[j][1];
                if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col) {
                    if (!visited[nextX][nextY] && forest.get(nextX).get(nextY) > 0) {
                        if (nextX == targetX && nextY == targetY) {
                            return steps + 1;
                        }
                        pq.add(new int[] { steps + 1, nextX * col + nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return -1;
    }

    private static List<List<Integer>> arr2List(int[][] arrs) {
        List<List<Integer>> lists = new ArrayList();
        for (int[] arr: arrs) {
            List<Integer> list = new ArrayList<>();
            for (int a: arr) {
                list.add(a);
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.cutOffTree(arr2List(new int[][] {{1, 2, 3}, {0, 0, 4}, {7, 6, 5}}))); // 6
        System.out.println(slt.cutOffTree(arr2List(new int[][] {{1, 2, 3}, {0, 0, 0}, {7, 6, 5}}))); // -1
        System.out.println(slt.cutOffTree(arr2List(new int[][] {{2, 3, 4}, {0, 0, 5}, {8, 7, 6}}))); // 6
    }

}
