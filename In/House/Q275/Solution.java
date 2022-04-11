package In.House.Q275;

public class Solution {

    public int hIndex(int[] citations) {
        int len = citations.length;
        int start = 0, end = len - 1;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int tmp = len - mid;
            if (citations[mid] > tmp) {
                --end;
                result = len - mid;
            } else if (citations[mid] < tmp) {
                ++start;
            } else {
                result = len - mid;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.hIndex(new int[]{0, 1, 3, 5, 6})); // 3
        System.out.println(slt.hIndex(new int[]{0, 1, 3, 4, 5, 6})); // 3
        System.out.println(slt.hIndex(new int[]{100})); // 1
    }

}
