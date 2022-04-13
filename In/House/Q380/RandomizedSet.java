package In.House.Q380;

import java.util.*;

//// 随机过不去，我有什么办法呢？
//class RandomizedSet {
//
//    private int size;
//    private Map<Integer, Integer> idx;
//    private List<Integer> list;
//
//    public RandomizedSet() {
//        this.size = 0;
//        this.idx = new HashMap<>();
//        this.list = new ArrayList<>();
//    }
//
//    public boolean insert(int val) {
//        if (idx.containsKey(val)) {
//            return false;
//        }
//        this.list.add(val);
//        this.idx.put(val, this.size ++);
//        return true;
//    }
//
//    public boolean remove(int val) {
//        int i = this.idx.getOrDefault(val, -1);
//        if (i < 0) {
//            return false;
//        }
//        this.idx.remove(val);
//        this.list.remove(i);
//        --this.size;
//        return true;
//    }
//
//    public int getRandom() {
//        int i = new Random().nextInt(this.size);
//        return this.list.get(i);
//    }
//
//    public static void main(String[] args) {
//        RandomizedSet set = new RandomizedSet();
//        set.insert(1);
//        set.remove(2);
//        set.insert(2);
//        System.out.println(set.getRandom());
//        set.remove(1);
//        set.insert(2);
//        System.out.println(set.getRandom());
//
//    }
//}


// CV大法
class RandomizedSet {

    private List<Integer> nums;
    private Map<Integer, Integer> indices;
    private Random random;

    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        indices = new HashMap<Integer, Integer>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        indices.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        int index = indices.get(val);
        int last = nums.get(nums.size() - 1);
        nums.set(index, last);
        indices.put(last, index);
        nums.remove(nums.size() - 1);
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */