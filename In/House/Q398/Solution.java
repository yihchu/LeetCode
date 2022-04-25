package In.House.Q398;

import java.util.*;

class Solution {

    private Map<Integer, List<Integer>> map;
    private Random random;

    public Solution(int[] nums) {
        this.random = new Random();
        this.map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!this.map.containsKey(nums[i])) {
                this.map.put(nums[i], new ArrayList<>());
            }
            this.map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = this.map.get(target);
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 3, 3};
        Solution solution = new Solution(nums);

        // pick(3)应该返回索引2, 3或者4。每个索引的返回概率应该相等。
        System.out.println(solution.pick(3));

        // pick(1)应该返回0。因为只有nums[0]等于1。
        System.out.println(solution.pick(1));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */