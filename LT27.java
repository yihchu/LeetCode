public class LT27 {

    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1;
        int temp;
        while (l <= r) {
            if (nums[l] == val) {
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                --r;
            } else {
                ++l;
            }
        }
        return r < 0 ? 0 : l;
    }

    public static void main(String[] args) {
        LT27 lt27 = new LT27();
        System.out.println(lt27.removeElement(new int[]{}, 1)); // 0
        System.out.println(lt27.removeElement(new int[]{1}, 1)); // 0
        System.out.println(lt27.removeElement(new int[]{2}, 1)); // 1
        System.out.println(lt27.removeElement(new int[]{3, 3}, 3)); // 0
        System.out.println(lt27.removeElement(new int[]{4, 5}, 5)); // 1
        System.out.println(lt27.removeElement(new int[]{3, 2, 2, 3}, 3)); // 2
        System.out.println(lt27.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2)); // 5
    }

}
