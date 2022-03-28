package In.House.Q1418;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> meals = new HashSet<>();
        Set<Integer> tables = new HashSet<>();
        Map<Integer, Map<String, Integer>> m = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        int len = orders.size();
        for (int i = 0; i < len; ++i) {
            List<String> order = orders.get(i);
            Integer table = Integer.parseInt(order.get(1));
            String meal = order.get(2);
            meals.add(meal);
            m.compute(table, (k, v) ->  {
                tables.add(table);
                if (Objects.isNull(v)) {
                    return new HashMap<>(){{put(meal, 1);}};
                } else {
                    v.put(meal, v.getOrDefault(meal, 0) + 1);
                    return v;
                }
            });
        }
        List<String> sortedMeals = meals.stream().sorted().collect(Collectors.toList());
        List<Integer> sortedTables = tables.stream().sorted().collect(Collectors.toList());
        List<String> titles = new ArrayList<>(){{add("Table");addAll(sortedMeals);}};
        result.add(titles);
        for (Integer table: sortedTables) {
            Map<String, Integer> menu = m.get(table);
            List<String> numbers = new ArrayList<>(){{add("" + table);}};
            for (String meal: sortedMeals) {
                numbers.add("" + menu.getOrDefault(meal, 0));
            }
            result.add(numbers);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        List<List<String>> tc1 = new ArrayList<>(){{
            add(new ArrayList<>(){{ add("David");add("3");add("Ceviche"); }});
            add(new ArrayList<>(){{ add("Corina");add("10");add("Beef Burrito"); }});
            add(new ArrayList<>(){{ add("David");add("3");add("Fried Chicken"); }});
            add(new ArrayList<>(){{ add("Carla");add("5");add("Water"); }});
            add(new ArrayList<>(){{ add("Carla");add("5");add("Ceviche"); }});
            add(new ArrayList<>(){{ add("Rous");add("3");add("Ceviche"); }});
        }};
        System.out.println(slt.displayTable(tc1));
        List<List<String>> tc2 = new ArrayList<>(){{
            add(new ArrayList<>(){{ add("James");add("12");add("Fried Chicken"); }});
            add(new ArrayList<>(){{ add("Ratesh");add("12");add("Fried Chicken"); }});
            add(new ArrayList<>(){{ add("Amadeus");add("12");add("Fried Chicken"); }});
            add(new ArrayList<>(){{ add("Adam");add("1");add("Canadian Waffles"); }});
            add(new ArrayList<>(){{ add("Brianna");add("1");add("Canadian Waffles"); }});
        }};
        System.out.println(slt.displayTable(tc2));
        List<List<String>> tc3 = new ArrayList<>(){{
            add(new ArrayList<>(){{ add("Laura");add("2");add("Bean Burrito"); }});
            add(new ArrayList<>(){{ add("Jhon");add("2");add("Beef Burrito"); }});
            add(new ArrayList<>(){{ add("Melissa");add("2");add("Soda"); }});
        }};
        System.out.println(slt.displayTable(tc3));
    }

}

