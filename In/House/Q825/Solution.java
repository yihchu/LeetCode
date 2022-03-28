package In.House.Q825;

import java.util.Arrays;

public class Solution {

//    // 超时
//    public int numFriendRequests(int[] ages) {
//        int len = ages.length;
//        if (len == 1) {
//            return 0;
//        }
//        Arrays.sort(ages);
//        int sum = 0;
//        for (int i = 0; i < len; ++i) {
//            for (int k = i - 1; k > -1; --k) {
//                if (heyJudy(ages[i], ages[k])) {
//                    ++ sum;
//                } else {
//                    break;
//                }
//            }
//            for (int k = i + 1; k < len; ++k) {
//                if (heyJudy(ages[i], ages[k])) {
//                    ++ sum;
//                } else {
//                    break;
//                }
//            }
//        }
//        return sum;
//    }

    public int numFriendRequests(int[] ages) {
        int len = ages.length;
        if (len == 1) {
            return 0;
        }
        Arrays.sort(ages);
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += count(0, i - 1, i, ages);
            sum += count(i + 1, len - 1, i, ages);
        }
        return sum;
    }

    private int count(int l, int r, int t, int[] ages) {
        boolean toLeft = r < t ? true : false;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (heyJudy(ages[t], ages[mid])) {
                if (toLeft) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (toLeft) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return toLeft ? t - l : r - t;
    }

    private boolean heyJudy(int x, int y) {
        if (y <= 0.5 * x + 7) {
            return false;
        }
        if (y > x) {
            return false;
        }
        if (y > 100 && x < 100) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.numFriendRequests(new int[] {16, 16})); // 2
        System.out.println(slt.numFriendRequests(new int[] {16, 17, 18})); // 2
        System.out.println(slt.numFriendRequests(new int[] {20, 30, 100, 110, 120})); // 3
    }

}
