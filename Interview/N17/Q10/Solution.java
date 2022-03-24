package Interview.N17.Q10;

public class Solution {

    // 这什么Boyer-Moore Algorithm，没听说过，第一次用，感觉挺靠谱~
    public int majorityElement(int[] nums) {
        int result = -1, count = 0;
        for (int num: nums) {
            result = count == 0 ? num : result;
            count += result == num ? 1 : -1;
        }
        count = 0;
        for (int num: nums) {
            count += result == num ? 1 : 0;
        }
        return count * 2 > nums.length ? result : -1;
    }

    public static void main(String[] args) {
        Solution lts = new Solution();
        System.out.println(lts.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5})); // 5
        System.out.println(lts.majorityElement(new int[]{3, 2})); // -1
        System.out.println(lts.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})); // 2
    }

}

