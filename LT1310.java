import java.util.Arrays;

public class LT1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int sum = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; ++j) {
                sum ^= arr[j];
            }
            result[i] = sum;
        }
        return result;
    }

    // 超出内存限制
    public int[] xorQueriesV2(int[] arr, int[][] queries) {
        int[][] m = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i; j < arr.length; ++j) {
                if (i == j) {
                    m[i][j] = arr[i];
                    continue;
                }
                m[i][j] = m[i][j - 1] ^ arr[j];
            }
        }
        int[] result = new int[queries.length];
        for (int k = 0; k < queries.length; ++k) {
            result[k] = m[queries[k][0]][queries[k][1]];
        }
        return result;
    }

    public int[] xorQueriesV3(int[] arr, int[][] queries) {
        int[] m = new int[arr.length];
        m[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            m[i] = m[i - 1] ^ arr[i];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            result[i] = (queries[i][0] > 0 ? m[queries[i][0] - 1] : 0) ^ m[queries[i][1]];
        }
        return result;
    }

    public static void main(String[] args) {
        LT1310 lt1310 = new LT1310();
        Arrays.stream(
                lt1310.xorQueriesV3(new int[]{1, 3, 4, 8},
                        new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{0, 3}, new int[]{3, 3}}))
                .forEach(k -> System.out.print(k + " "));
        System.out.println();
        Arrays.stream(
                lt1310.xorQueriesV3(new int[]{4, 8, 2, 10},
                        new int[][]{new int[]{2, 3}, new int[]{1, 3}, new int[]{0, 0}, new int[]{0, 3}}))
                .forEach(k -> System.out.print(k + " "));
        System.out.println();
        Arrays.stream(
                lt1310.xorQueriesV3(new int[]{16},
                        new int[][]{new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}}))
                .forEach(k -> System.out.print(k + " "));
        System.out.println();
    }

}
