<h1>随机数索引</h1>

给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。您可以假设给定的数字一定存在于数组中。</br>

注意：</br>
数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。</br>

示例:
```java
int[] nums = new int[] {1, 2, 3, 3, 3};
Solution solution = new Solution(nums);

// pick(3)应该返回索引2, 3或者4。每个索引的返回概率应该相等。
solution.pick(3);

// pick(1)应该返回0。因为只有nums[0]等于1。
solution.pick(1);
```

[Link](https://leetcode-cn.com/problems/random-pick-index/)