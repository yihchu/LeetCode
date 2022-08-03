<h1>O(1)时间插入、删除和获取随机元素</h1>

实现RandomizedSet类：</br>
`RandomizedSet()`初始化RandomizedSet对象</br>
`bool insert(int val)`当元素val不存在时，向集合中插入该项，并返回true；否则，返回false。</br>
`bool remove(int val)`当元素val存在时，从集合中移除该项，并返回true；否则，返回false。</br>
`int getRandom()`随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有相同的概率被返回。</br>
你必须实现类的所有函数，并满足每个函数的平均时间复杂度为O(1)。</br>

示例：</br>
输入</br>
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]</br>
[[], [1], [2], [2], [], [1], [2], []]</br>
输出</br>
[null, true, false, true, 2, true, false, 2]</br>

解释
```java
RandomizedSet.randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // 向集合中插入1。返回true表示1被成功地插入。
randomizedSet.remove(2); // 返回false，表示集合中不存在2。
randomizedSet.insert(2); // 向集合中插入2 。返回true。集合现在包含[1, 2]。
randomizedSet.getRandom(); // getRandom应随机返回1或2。
randomizedSet.remove(1); // 从集合中移除1，返回true。集合现在包含[2]。
randomizedSet.insert(2); // 2已在集合中，所以返回false。
randomizedSet.getRandom(); // 由于2是集合中唯一的数字，getRandom总是返回2。
```

提示：
- -2^31 <= val <= 2^31 - 1
- 最多调用insert、remove和getRandom函数2 * 10^5次
- 在调用getRandom方法时，数据结构中至少存在一个元素。

[Link](https://leetcode-cn.com/problems/insert-delete-getrandom-o1/)