package In.House.Q380;

import java.util.*;

class RandomizedSet {

    private int size;
    private Map<Integer, Integer> idx;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        this.size = 0;
        this.idx = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (idx.containsKey(val)) {
            return false;
        }
        this.list.add(val);
        this.idx.put(val, this.size ++);
        return true;
    }

    public boolean remove(int val) {
        int i = this.idx.getOrDefault(val, -1);
        if (i < 0) {
            return false;
        }
        this.idx.remove(val);
        this.list.remove(i);
        -- this.size;
        if (this.list.isEmpty() || i == this.list.size()) {
            return true;
        }
        int last = this.list.get(this.size - 1);
        this.list.remove(this.size - 1);
        this.list.add(i, last);
        this.idx.put(last, i);
        return true;
    }

    public int getRandom() {
        int i = this.random.nextInt(this.size);
        return this.list.get(i);
    }

    public static void main(String[] args) {
        RandomizedSet set1 = new RandomizedSet();
        set1.insert(1);
        set1.remove(2);
        set1.insert(2);
        System.out.println(set1.getRandom()); // 2
        set1.remove(1);
        set1.insert(2);
        System.out.println(set1.getRandom()); // 2

        RandomizedSet set2 = new RandomizedSet();
        set2.insert(0);
        set2.insert(1);
        set2.remove(0);
        set2.insert(2);
        set2.remove(1);
        System.out.println(set2.getRandom()); // 2

        RandomizedSet set3 = new RandomizedSet();
        set3.insert(3);
        set3.insert(3);
        System.out.println(set3.getRandom());
        System.out.println(set3.getRandom());
        set3.insert(1);
        set3.remove(3);
        System.out.println(set3.getRandom());
        System.out.println(set3.getRandom());
        set3.insert(0);
        set3.remove(0);

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
