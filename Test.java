//public class Test {
//
//    public static void bag(int[] v, int[] w, int c) {
//        int l = v.length;
//        int[][] V = new int[l][c + 1];
//        for (int i = 0; i < l; ++i) {
//            V[i][0] = 0;
//        }
//        for (int i = 1; i < l; ++i) {
//            for (int j = 0; j <= c; ++j) {
//                if (j < w[i]) {
//                    V[i][j] = V[i - 1][j];
//                } else {
//                    V[i][j] = Math.max(V[i - 1][j], V[i - 1][j - w[i]] + v[i]);
//                }
//            }
//        }
//        for (int i = 0; i < l; ++i) {
//            for (int j = 0; j <= c; ++j) {
//                System.out.print(V[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] v = new int[]{3, 4, 5, 6};
//        int[] w = new int[]{2, 3, 4, 5};
//        int cap = 8;
//        bag(v, w, 8);
//    }
//
//}
