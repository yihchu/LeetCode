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

/**
Ques: 两个列表的最小索引总和
Link: https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/

两个列表的最小索引总和
假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。如果答案不止一个，则输出所有答案并且不考虑顺序。你可以假设答案总是存在。

示例1:
输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出: ["Shogun"]
解释: 他们唯一共同喜爱的餐厅是“Shogun”。

示例2:
输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
输出: ["Shogun"]
解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。

提示:
1 <= list1.length, list2.length <= 1000
1 <= list1[i].length, list2[i].length <= 30
list1[i]和list2[i]由空格' '和英文字母组成。
list1的所有字符串都是唯一的。
list2中的所有字符串都是唯一的。

*/