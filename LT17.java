public class LT17 {

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
        LT17 lt17 = new LT17();
        System.out.println(lt17.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5})); // 5
        System.out.println(lt17.majorityElement(new int[]{3, 2})); // -1
        System.out.println(lt17.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})); // 2
    }

}

/*

数组中占比超过一半的元素称之为主要元素。给你一个整数数组，找出其中的主要元素。若没有，返回-1。请设计时间复杂度为O(N)、空间复杂度为O(1)的解决方案。

示例 1：
输入：[1,2,5,9,5,9,5,5,5]
输出：5

示例 2：
输入：[3,2]
输出：-1

示例 3：
输入：[2,2,1,1,1,2,2]
输出：2

*/
