<h1>两个列表的最小索引总和</h1>

两个列表的最小索引总和</br>
假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。</br>
你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。如果答案不止一个，则输出所有答案并且不考虑顺序。你可以假设答案总是存在。</br>

示例1:</br>
输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]</br>
输出: ["Shogun"]</br>
解释: 他们唯一共同喜爱的餐厅是“Shogun”。</br>

示例2:</br>
输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]</br>
输出: ["Shogun"]</br>
解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0 + 1)。</br>

提示:</br>
1 <= list1.length, list2.length <= 1000</br>
1 <= list1[i].length, list2[i].length <= 30</br>
list1[i]和list2[i]由空格' '和英文字母组成。</br>
list1的所有字符串都是唯一的。</br>
list2中的所有字符串都是唯一的。</br>

[Link](https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/)