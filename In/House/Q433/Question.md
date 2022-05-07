<h1>最小基因变化</h1>

基因序列可以表示为一条由8个字符组成的字符串，其中每个字符都是'A'、'C'、'G'和'T'之一。</br>
假设我们需要调查从基因序列start变为end所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。</br>
例如，"AACCGGTT" --> "AACCGGTA"就是一次基因变化。</br>
另有一个基因库bank记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。</br>
给你两个基因序列start和end，以及一个基因库bank，请你找出并返回能够使start变化为end所需的最少变化次数。如果无法完成此基因变化，返回-1。</br>
注意：起始基因序列start默认是有效的，但是它并不一定会出现在基因库中。</br>

示例1：</br>
输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]</br>
输出：1</br>

示例2：</br>
输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]</br>
输出：2</br>

示例3：</br>
输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]</br>
输出：3</br>

提示：</br>
start.length == 8</br>
end.length == 8</br>
0 <= bank.length <= 10</br>
bank[i].length == 8</br>
start、end和bank[i]仅由字符['A', 'C', 'G', 'T']组成</br>

[Link](https://leetcode-cn.com/problems/minimum-genetic-mutation/)