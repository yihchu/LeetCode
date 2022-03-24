<h1>H2O生成</h1>

现在有两种线程，氧oxygen和氢hydrogen，你的目标是组织这两种线程来产生水分子。</br>
存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。</br>
氢和氧线程会被分别给予releaseHydrogen和releaseOxygen方法来允许它们突破屏障。</br>
这些线程应该三三成组突破屏障并能立即组合产生一个水分子。</br>
你必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。</br>

换句话说:</br>
如果一个氧线程到达屏障时没有氢线程到达，它必须等候直到两个氢线程到达。</br>
如果一个氢线程到达屏障时没有其它线程到达，它必须等候直到一个氧线程和另一个氢线程到达。</br>
书写满足这些限制条件的氢、氧线程同步代码。</br>

示例1:</br>
输入: "HOH"</br>
输出: "HHO"</br>
解释: "HOH"和"OHH"依然都是有效解。</br>

示例2:</br>
输入: "OOHHHH"</br>
输出: "HHOHHO"</br>
解释: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH"和"OHHOHH"依然都是有效解。</br>

提示：
输入字符串的总长将会是3n, 1 ≤ n ≤ 50；</br>
输入字符串中的“H”总数将会是2n。</br>
输入字符串中的“O”总数将会是n。</br>

[Link](https://leetcode-cn.com/problems/building-h2o/0