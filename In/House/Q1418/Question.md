<h1>点菜展示表</h1>

给你一个数组orders，表示客户在餐厅中完成的订单，确切地说，orders[i]=[customerName[i], tableNumber[i], foodItem[i]]，其中customerName[i]是客户的姓名，tableNumber[i]是客户所在餐桌的桌号，而foodItem[i]是客户点的餐品名称。</br>
请你返回该餐厅的点菜展示表。在这张表中，表中第一行为标题，其第一列为餐桌桌号“Table”，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。</br>
注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。</br>

示例1：</br>
输入：orders = [["David", "3", "Ceviche"], ["Corina", "10", "Beef Burrito"], ["David", "3", "Fried Chicken"], ["Carla", "5", "Water"], ["Carla", "5", "Ceviche"], ["Rous", "3", "Ceviche"]]</br>
输出：[["Table", "Beef Burrito", "Ceviche", "Fried Chicken", "Water"], ["3", "0", "2", "1", "0"], ["5", "0", "1", "0", "1"], ["10", "1", "0", "0", "0"]]</br>

解释：</br>
点菜展示表如下所示：</br>
Table, Beef Burrito, Ceviche, Fried Chicken, Water</br>
3    , 0           , 2      , 1            , 0</br>
5    , 0           , 1      , 0            , 1</br>
10   , 1           , 0      , 0            , 0</br>
对于餐桌3：David点了"Ceviche"和"Fried Chicken"，而Rous点了"Ceviche"</br>
而餐桌5：Carla点了"Water"和"Ceviche"</br>
餐桌10：Corina点了"Beef Burrito"</br>

示例2：</br>
输入：orders = [["James", "12", "Fried Chicken"], ["Ratesh", "12", "Fried Chicken"], ["Amadeus", "12", "Fried Chicken"], ["Adam", "1", "Canadian Waffles"], ["Brianna", "1", "Canadian Waffles"]]</br>
输出：[["Table", "Canadian Waffles", "Fried Chicken"], ["1", "2", "0"], ["12", "0", "3"]]</br>
解释：</br>
对于餐桌1：Adam和Brianna都点了"Canadian Waffles"</br>
而餐桌12：James, Ratesh和Amadeus都点了"Fried Chicken"</br>

示例3：</br>
输入：orders = [["Laura", "2", "Bean Burrito"], ["Jhon", "2", "Beef Burrito"], ["Melissa", "2", "Soda"]]</br>
输出：[["Table", "Bean Burrito", "Beef Burrito", "Soda"], ["2", "1", "1", "1"]]</br>

提示：</br>
1 <= orders.length <= 5 * 10^4</br>
orders[i].length == 3</br>
1 <= customerName[i].length, foodItem[i].length <= 20</br>
customerName[i]和foodItem[i]由大小写英文字母及空格字符' '组成。</br>
tableNumber[i]是1到500范围内的整数。</br>

[Link](https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant/)