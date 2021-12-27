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

/**
Link: https://leetcode-cn.com/problems/friends-of-appropriate-ages/

在社交媒体网站上有n个用户。给你一个整数数组ages，其中ages[i]是第i个用户的年龄。
如果下述任意一个条件为真，那么用户x将不会向用户y（x != y）发送好友请求：
age[y] <= 0.5 * age[x] + 7
age[y] > age[x]
age[y] > 100 && age[x] < 100
否则，x将会向y发送一条好友请求。
注意，如果x向y发送一条好友请求，y不必也向x发送一条好友请求。另外，用户不会向自己发送好友请求。
返回在该社交媒体网站上产生的好友请求总数。

示例1：
输入：ages = [16, 16]
输出：2
解释：2人互发好友请求。

示例2：
输入：ages = [16, 17, 18]
输出：2
解释：产生的好友请求为 17 -> 16 ，18 -> 17。

示例3：
输入：ages = [20, 30, 100, 110, 120]
输出：3
解释：产生的好友请求为110 -> 100，120 -> 110，120 -> 100。

提示：
n == ages.length
1 <= n <= 2 * 10^4
1 <= ages[i] <= 120

*/