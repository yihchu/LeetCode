package In.House.Q599;

import java.util.*;

public class Solution {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; ++i) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; ++i) {
            map2.put(list2[i], i);
        }
        int idx = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map1.entrySet()) {
            if (!map2.containsKey(entry.getKey())) {
                continue;
            }
            int curIdx = entry.getValue() + map2.get(entry.getKey());
            if (idx < curIdx) {
                continue;
            }
            if (idx > curIdx) {
                idx = curIdx;
                result = new ArrayList<>();
            }
            result.add(entry.getKey());
        }
        return result.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        Arrays.stream(slt.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}
                , new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        Arrays.stream(slt.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}
                        , new String[]{"KFC", "Shogun", "Burger King"}))
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

}
