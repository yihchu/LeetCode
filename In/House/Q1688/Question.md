<h1>比赛中的配对次数</h1>

给你一个整数n，表示比赛中的队伍数。比赛遵循一种独特的赛制：</br>
如果当前队伍数是偶数，那么每支队伍都会与另一支队伍配对。总共进行n / 2场比赛，且产生n / 2支队伍进入下一轮。</br>
如果当前队伍数为奇数 ，那么将会随机轮空并晋级一支队伍，其余的队伍配对。总共进行(n - 1) / 2场比赛，且产生(n - 1) / 2 + 1支队伍进入下一轮。</br>
返回在比赛中进行的配对次数，直到决出获胜队伍为止。</br>

示例1：</br>
输入：n = 7</br>
输出：6</br>
解释：比赛详情：</br>
- 第1轮：队伍数 = 7，配对次数 = 3，4支队伍晋级。</br>
- 第2轮：队伍数 = 4，配对次数 = 2，2支队伍晋级。</br>
- 第3轮：队伍数 = 2，配对次数 = 1，决出1支获胜队伍。</br>
  总配对次数 = 3 + 2 + 1 = 6</br>

示例2：</br>
输入：n = 14</br>
输出：13</br>
解释：比赛详情：</br>
- 第1轮：队伍数 = 14，配对次数 = 7，7支队伍晋级。</br>
- 第2轮：队伍数 = 7，配对次数 = 3，4支队伍晋级。</br>
- 第3轮：队伍数 = 4，配对次数 = 2，2支队伍晋级。</br>
- 第4轮：队伍数 = 2，配对次数 = 1，决出1支获胜队伍。</br>
  总配对次数 = 7 + 3 + 2 + 1 = 13</br>

提示：
- 1 <= n <= 200

[Link](https://leetcode-cn.com/problems/count-of-matches-in-tournament/)