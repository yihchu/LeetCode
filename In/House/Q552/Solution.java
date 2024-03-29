package In.House.Q552;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//    // 递归：java.lang.StackOverflowError
//    private final int THRESHOLD = 1000000007;
//    public int checkRecord(int n) {
//        long sum = 0;
//        for (int i = 0; i <= n; ++i) {
//            int[] arr = new int[n];
//            if (i != n) {
//                arr[i] = 'A';
//            }
//            sum += (findRecords(arr, 0, n) % THRESHOLD);
//            sum %= THRESHOLD;
//        }
//        return (int)sum;
//    }
//
//    private int findRecords(int[] arr, int p, int n) {
//        if (p == n) {
//            return 1;
//        }
//        if (arr[p] == 'A') {
//            return findRecords(arr, p + 1, n);
//        }
//        arr[p] = 'P';
//        int s1 = findRecords(arr, p + 1, n) % THRESHOLD;
//        int s2 = 0;
//        if (p < 2 || arr[p - 1] != 'L' || arr[p - 2] != 'L') {
//            arr[p] = 'L';
//            s2 = findRecords(arr, p + 1, n) % THRESHOLD;
//        }
//        long sum = (s1 + s2) % THRESHOLD;
//        return (int)sum;
//    }

//    // passed
//    private final int THRESHOLD = 1000000007;
//    public int checkRecord(int n) {
//        Map<Integer, Long>[] array = new HashMap[n];
//
//        array[0] = new HashMap<>();
//        array[0].put(1, 1l); // P
//        array[0].put(2, 1l); // A
//        array[0].put(4, 1l); // L
//
//        long count = 0;
//        for (int i = 1; i < n; ++i) {
//            array[i] = new HashMap<>();
//
//            count = array[i - 1].getOrDefault(1, 0l);
//            array[i].put(1, (array[i].getOrDefault(1, 0l) + count) % THRESHOLD); // P
//            array[i].put(4, (array[i].getOrDefault(4, 0l) + count) % THRESHOLD); // A
//            array[i].put(2, (array[i].getOrDefault(2, 0l) + count) % THRESHOLD); // L
//
//            count = array[i - 1].getOrDefault(2, 0l);
//            array[i].put(1, (array[i].getOrDefault(1, 0l) + count) % THRESHOLD); // P
//            array[i].put(4, (array[i].getOrDefault(4, 0l) + count) % THRESHOLD); // A
//            array[i].put(3, (array[i].getOrDefault(3, 0l) + count) % THRESHOLD); // L
//
//            count = array[i - 1].getOrDefault(3, 0l);
//            array[i].put(1, (array[i].getOrDefault(1, 0l) + count) % THRESHOLD); // P
//            array[i].put(4, (array[i].getOrDefault(4, 0l) + count) % THRESHOLD); // A
//
//            count = array[i - 1].getOrDefault(4, 0l);
//            array[i].put(4, (array[i].getOrDefault(4, 0l) + count) % THRESHOLD); // P
//            array[i].put(5, (array[i].getOrDefault(5, 0l) + count) % THRESHOLD); // L
//
//            count = array[i - 1].getOrDefault(5, 0l);
//            array[i].put(4, (array[i].getOrDefault(4, 0l) + count) % THRESHOLD); // P
//            array[i].put(6, (array[i].getOrDefault(6, 0l) + count) % THRESHOLD); // L
//
//            count = array[i - 1].getOrDefault(6, 0l);
//            array[i].put(4, (array[i].getOrDefault(4, 0l) + count) % THRESHOLD); // P
//        }
//        long sum = 0;
//        for (long v: array[n - 1].values()) {
//            sum += (v % THRESHOLD);
//            sum %= THRESHOLD;
//        }
//        return (int)sum;
//    }

    // 优化内存使用
    private final int THRESHOLD = 1000000007;
    public int checkRecord(int n) {
        Map<Integer, Long> map = new HashMap<>() {{
            put(1, 1l); // P
            put(2, 1l); // A
            put(4, 1l); // L
        }};

        long count = 0;
        for (int i = 1; i < n; ++i) {
            Map<Integer, Long> tmp = new HashMap<>();

            count = map.getOrDefault(1, 0l);
            tmp.put(1, (tmp.getOrDefault(1, 0l) + count) % THRESHOLD); // P
            tmp.put(4, (tmp.getOrDefault(4, 0l) + count) % THRESHOLD); // A
            tmp.put(2, (tmp.getOrDefault(2, 0l) + count) % THRESHOLD); // L

            count = map.getOrDefault(2, 0l);
            tmp.put(1, (tmp.getOrDefault(1, 0l) + count) % THRESHOLD); // P
            tmp.put(4, (tmp.getOrDefault(4, 0l) + count) % THRESHOLD); // A
            tmp.put(3, (tmp.getOrDefault(3, 0l) + count) % THRESHOLD); // L

            count = map.getOrDefault(3, 0l);
            tmp.put(1, (tmp.getOrDefault(1, 0l) + count) % THRESHOLD); // P
            tmp.put(4, (tmp.getOrDefault(4, 0l) + count) % THRESHOLD); // A

            count = map.getOrDefault(4, 0l);
            tmp.put(4, (tmp.getOrDefault(4, 0l) + count) % THRESHOLD); // P
            tmp.put(5, (tmp.getOrDefault(5, 0l) + count) % THRESHOLD); // L

            count = map.getOrDefault(5, 0l);
            tmp.put(4, (tmp.getOrDefault(4, 0l) + count) % THRESHOLD); // P
            tmp.put(6, (tmp.getOrDefault(6, 0l) + count) % THRESHOLD); // L

            count = map.getOrDefault(6, 0l);
            tmp.put(4, (tmp.getOrDefault(4, 0l) + count) % THRESHOLD); // P

            map = tmp;
        }
        long sum = 0;
        for (long v: map.values()) {
            sum += (v % THRESHOLD);
            sum %= THRESHOLD;
        }
        return (int)sum;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.checkRecord(1)); // 3
        System.out.println(slt.checkRecord(2)); // 8
        System.out.println(slt.checkRecord(3)); // 19
        System.out.println(slt.checkRecord(4)); // 43
        System.out.println(slt.checkRecord(5)); // 94
        System.out.println(slt.checkRecord(10101)); // 183236316
        System.out.println(slt.checkRecord(100000)); // 749184020
    }

}
//1: A, L, P
//2: PP, AP, PA, LP, PL, AL, LA, LL
//3: PPP, PPA, PPL,

//没有A
//    结尾没有L的00
//    结尾是一个L01
//    结尾是两个L02
//有A
//    结尾没有L的10
//    结尾是一个L11
//    结尾是两个L12