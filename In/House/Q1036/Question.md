<h1>逃离大迷宫</h1>

在一个10^6 x 10^6的网格中，每个网格上方格的坐标为(x, y)。</br>
现在从源方格source = [s[x], s[y]]开始出发，意图赶往目标方格target = [t[x], t[y]]。数组blocked是封锁的方格列表，其中每个blocked[i] = [x[i], y[i]]表示坐标为(x[i], y[i])的方格是禁止通行的。</br>
每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格不在给出的封锁列表blocked上。同时，不允许走出网格。</br>
只有在可以通过一系列的移动从源方格source到达目标方格target 时才返回true。否则，返回false。</br>

示例1：</br>
输入：blocked = [[0, 1], [1, 0]], source = [0, 0], target = [0, 2]</br>
输出：false</br>
解释：</br>
从源方格无法到达目标方格，因为我们无法在网格中移动。</br>
无法向北或者向东移动是因为方格禁止通行。</br>
无法向南或者向西移动是因为不能走出网格。</br>

示例2：</br>
输入：blocked = [], source = [0, 0], target = [999999, 999999]</br>
输出：true</br>
解释：</br>
因为没有方格被封锁，所以一定可以到达目标方格。</br>

提示：
- 0 <= blocked.length <= 200
- blocked[i].length == 2
- 0 <= x[i], y[i] < 10^6
- source.length == target.length == 2
- 0 <= s[x], s[y], t[x], t[y] < 10^6
- source != target
- 题目数据保证source和target不在封锁列表内

[Link](https://leetcode-cn.com/problems/escape-a-large-maze/)
