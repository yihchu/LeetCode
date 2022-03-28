package In.House.Q852;

public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int s = 0, e = arr.length - 1, m;
        if (e == 2) return arr[1];
        while(s < e) {
            m = (s + e) / 2;
            if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) {
                return m;
            }
            if (arr[m] <= arr[m - 1]) {
                e = m;
            }
            if (arr[m] <= arr[m + 1]) {
                s = m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.peakIndexInMountainArray(new int[]{0, 1, 0})); // 1
        System.out.println(slt.peakIndexInMountainArray(new int[]{0,2,1,0})); // 1
        System.out.println(slt.peakIndexInMountainArray(new int[]{0,10,5,2})); // 1
        System.out.println(slt.peakIndexInMountainArray(new int[]{3,4,5,1})); // 2
        System.out.println(slt.peakIndexInMountainArray(new int[]{24,69,100,99,79,78,67,36,26,19})); // 2
    }

}
