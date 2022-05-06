package In.House.Q933;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        this.queue.add(t);
        int start = t - 3000;
        if (start < 1) {
            return this.queue.size();
        }
        while (this.queue.peek() < start) {
            this.queue.poll();
        }
        return this.queue.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(1);     // requests = [1]，范围是[-2999, 1]，返回1
        recentCounter.ping(100);   // requests = [1, 100]，范围是[-2900, 100]，返回2
        recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是[1, 3001]，返回3
        recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是[2, 3002]，返回3
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */