import java.util.*;
import java.util.stream.Collectors;

public class LT1418 {

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
        LT1418 lt1418 = new LT1418();
        List<List<String>> tc1 = new ArrayList<>(){{
            add(new ArrayList<>(){{ add("David");add("3");add("Ceviche"); }});
            add(new ArrayList<>(){{ add("Corina");add("10");add("Beef Burrito"); }});
            add(new ArrayList<>(){{ add("David");add("3");add("Fried Chicken"); }});
            add(new ArrayList<>(){{ add("Carla");add("5");add("Water"); }});
            add(new ArrayList<>(){{ add("Carla");add("5");add("Ceviche"); }});
            add(new ArrayList<>(){{ add("Rous");add("3");add("Ceviche"); }});
        }};
        System.out.println(lt1418.displayTable(tc1));
        List<List<String>> tc2 = new ArrayList<>(){{
            add(new ArrayList<>(){{ add("James");add("12");add("Fried Chicken"); }});
            add(new ArrayList<>(){{ add("Ratesh");add("12");add("Fried Chicken"); }});
            add(new ArrayList<>(){{ add("Amadeus");add("12");add("Fried Chicken"); }});
            add(new ArrayList<>(){{ add("Adam");add("1");add("Canadian Waffles"); }});
            add(new ArrayList<>(){{ add("Brianna");add("1");add("Canadian Waffles"); }});
        }};
        System.out.println(lt1418.displayTable(tc2));
        List<List<String>> tc3 = new ArrayList<>(){{
            add(new ArrayList<>(){{ add("Laura");add("2");add("Bean Burrito"); }});
            add(new ArrayList<>(){{ add("Jhon");add("2");add("Beef Burrito"); }});
            add(new ArrayList<>(){{ add("Melissa");add("2");add("Soda"); }});
        }};
        System.out.println(lt1418.displayTable(tc3));
    }

}

/*

给你一个数组orders，表示客户在餐厅中完成的订单，确切地说，orders[i]=[customerName[i], tableNumber[i], foodItem[i]]，其中customerName[i]是客户的姓名，tableNumber[i]是客户所在餐桌的桌号，而foodItem[i]是客户点的餐品名称。
请你返回该餐厅的点菜展示表。在这张表中，表中第一行为标题，其第一列为餐桌桌号“Table”，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。

示例 1：
输入：orders = [["David", "3", "Ceviche"], ["Corina", "10", "Beef Burrito"], ["David", "3", "Fried Chicken"]
                , ["Carla", "5", "Water"], ["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]

解释：
点菜展示表如下所示：
Table, Beef Burrito, Ceviche, Fried Chicken, Water
3    , 0           , 2      , 1            , 0
5    , 0           , 1      , 0            , 1
10   , 1           , 0      , 0            , 0
对于餐桌3：David点了"Ceviche"和"Fried Chicken"，而Rous点了"Ceviche"
而餐桌5：Carla点了"Water"和"Ceviche"
餐桌10：Corina点了"Beef Burrito"

示例 2：
输入：orders = [["James", "12", "Fried Chicken"], ["Ratesh", "12", "Fried Chicken"], ["Amadeus", "12", "Fried Chicken"]
                , ["Adam", "1", "Canadian Waffles"], ["Brianna", "1", "Canadian Waffles"]]
输出：[["Table", "Canadian Waffles", "Fried Chicken"], ["1", "2", "0"], ["12", "0", "3"]]
解释：
对于餐桌1：Adam和Brianna都点了"Canadian Waffles"
而餐桌12：James, Ratesh和Amadeus都点了"Fried Chicken"

示例 3：
输入：orders = [["Laura", "2", "Bean Burrito"], ["Jhon", "2", "Beef Burrito"], ["Melissa", "2", "Soda"]]
输出：[["Table", "Bean Burrito", "Beef Burrito", "Soda"], ["2", "1", "1", "1"]]

提示：
1 <= orders.length <= 5 * 10^4
orders[i].length == 3
1 <= customerName[i].length, foodItem[i].length <= 20
customerName[i]和foodItem[i]由大小写英文字母及空格字符' '组成。
tableNumber[i]是1到500范围内的整数。

*/