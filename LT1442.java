public class LT1442 {

    public int countTriplets(int[] arr) {
        int result = 0;
        if (arr.length == 1) {
            return result;
        }
        int[] m = new int[arr.length];
        m[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            m[i] = m[i - 1] ^ arr[i];
        }
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 1; j < arr.length; ++j) {
                for (int k = i + 1; k <= j; ++k) {
                    if ( (m[k - 1] ^ (i > 0 ? m[i - 1] : 0)) == (m[j] ^ m[k - 1]) ) {
                        ++result;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LT1442 lt1442 = new LT1442();
        System.out.println(lt1442.countTriplets(new int[]{2, 3, 1, 6, 7})); // 4
        System.out.println(lt1442.countTriplets(new int[]{1, 1, 1, 1, 1})); // 10
        System.out.println(lt1442.countTriplets(new int[]{2, 3})); // 0
        System.out.println(lt1442.countTriplets(new int[]{1, 3, 5, 7, 9})); // 3
        System.out.println(lt1442.countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22})); // 8
    }

}

/*
给你一个整数数组 arr 。

现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。

a 和 b 定义如下：

a = arr[i] ^ arr[i + 1] ^ ... ^ arr[k - 1]
b = arr[k] ^ arr[k + 1] ^ ... ^ arr[j]
注意：^ 表示 按位异或 操作。

请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。

示例 1：

输入：arr = [2,3,1,6,7]
输出：4
解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
示例 2：

输入：arr = [1,1,1,1,1]
输出：10
示例 3：

输入：arr = [2,3]
输出：0
示例 4：

输入：arr = [1,3,5,7,9]
输出：3
示例 5：

输入：arr = [7,11,12,9,5,2,7,17,22]
输出：8

提示：
1 <= arr.length <= 300
1 <= arr[i] <= 10^8
 */