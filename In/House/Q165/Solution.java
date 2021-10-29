package In.House.Q165;

public class Solution {

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int limit = Math.min(len1, len2);
        int idx = 0;
        while (idx < limit) {
            int n1 = Integer.parseInt(arr1[idx]);
            int n2 = Integer.parseInt(arr2[idx]);
            ++idx;
            if (n1 == n2) {
                continue;
            }
            return n1 - n2 > 0 ? 1 : -1;
        }
        if (len1 == len2) {
            return 0;
        }
        if (idx == len1) {
            while (idx < len2) {
                if (Integer.parseInt(arr2[idx ++]) > 0) {
                    return -1;
                }
            }
        } else {
            while (idx < len1) {
                if (Integer.parseInt(arr1[idx ++]) > 0) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.compareVersion("1.01", "1.001")); // 0
        System.out.println(slt.compareVersion("1.0", "1.0.0")); // 0
        System.out.println(slt.compareVersion("0.1", "1.1")); // -1
        System.out.println(slt.compareVersion("1.0.1", "1")); // 1
        System.out.println(slt.compareVersion("7.5.2.4", "7.5.3")); // -1
    }
}

/**
Link: https://leetcode-cn.com/problems/compare-version-numbers/

给你两个版本号version1和version2，请你比较它们。
版本号由一个或多个修订号组成，各修订号由一个'.'连接。每个修订号由多位数字组成，可能包含前导零。每个版本号至少包含一个字符。修订号从左到右编号，下标从0开始，最左边的修订号下标为0，下一个修订号下标为1，以此类推。例如，2.5.33和0.1都是有效的版本号。
比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较忽略任何前导零后的整数值。也就是说，修订号1和修订号001相等。如果版本号没有指定某个下标处的修订号，则该修订号视为0。例如，版本1.0小于版本1.1，因为它们下标为0的修订号相同，而下标为1的修订号分别为0和1，0 < 1。

返回规则如下：
如果version1 > version2返回1，
如果version1 < version2返回-1，
除此之外返回0。

示例1：
输入：version1 = "1.01", version2 = "1.001"
输出：0
解释：忽略前导零，"01"和"001"都表示相同的整数"1"

示例2：
输入：version1 = "1.0", version2 = "1.0.0"
输出：0
解释：version1没有指定下标为2的修订号，即视为"0"

示例3：
输入：version1 = "0.1", version2 = "1.1"
输出：-1
解释：version1中下标为0的修订号是"0"，version2中下标为0的修订号是"1"。0 < 1，所以version1 < version2

示例4：
输入：version1 = "1.0.1", version2 = "1"
输出：1

示例5：
输入：version1 = "7.5.2.4", version2 = "7.5.3"
输出：-1

提示：
1 <= version1.length, version2.length <= 500
version1和version2仅包含数字和'.'
version1和version2都是有效版本号
version1和version2的所有修订号都可以存储在32位整数中

*/