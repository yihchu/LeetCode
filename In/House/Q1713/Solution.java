package In.House.Q1713;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {


//    // 超时了
//    public int minOperations(int[] target, int[] arr) {
//        int len = target.length;
//        Map<Integer, Integer> map = new HashMap<>(){{
//            for (int i = 0; i < len; ++i) {
//                put(target[i], i);
//            }
//        }};
//        arr = Arrays.stream(arr).filter(a -> map.keySet().contains(a)).map(a -> map.get(a)).toArray();
//        int size = arr.length;
//        if (size == 0) {
//            return len;
//        }
//        int[] result = new int[size];
//        Arrays.fill(result, 1);
//        int max = 1;
//        for (int i = 1; i < size; ++i) {
//            for (int j = i - 1;j >= 0; --j) {
//                result[i] = arr[i] > arr[j] && result[i] < result[j] + 1 ? result[j] + 1 : result[i];
//            }
//            max = max < result[i] ? result[i] : max;
//        }
//        return len - max;
//    }


    public int minOperations(int[] target, int[] arr) {
        int len = target.length;
        Map<Integer, Integer> map = new HashMap<>(){{
            for (int i = 0; i < len; ++i) {
                put(target[i], i);
            }
        }};
        arr = Arrays.stream(arr).filter(a -> map.keySet().contains(a)).map(a -> map.get(a)).toArray();
        int size = arr.length;
        if (size == 0) {
            return len;
        }

        int idx = 1;
        int[] d = new int[size + 1];
        d[idx] = arr[0];
        for (int i = 1; i < size; ++i) {
            if (arr[i] > d[idx]) {
                d[++idx] = arr[i];
            } else {
                int l = 1, r = idx, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < arr[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = arr[i];
            }
        }
        return len - idx;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.minOperations(new int[]{5, 1, 3}, new int[]{9, 4, 2, 3, 4})); // 2
        System.out.println(slt.minOperations(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1})); // 3
        System.out.println(slt.minOperations(new int[]{16, 7, 20, 11, 15, 13, 10, 14, 6, 8}, new int[]{11, 14, 15, 7, 5, 5, 6, 10, 11, 6})); // 6
        System.out.println(slt.minOperations(new int[]{1, 3, 8}, new int[]{2, 6})); // 3
    }

}

