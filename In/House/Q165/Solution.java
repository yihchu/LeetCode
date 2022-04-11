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

