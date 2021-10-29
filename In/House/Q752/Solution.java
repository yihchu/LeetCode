package In.House.Q752;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    private final static String START_POSITON = "0000";

    public int openLock(String[] deadends, String target) {
        if (target.equals(START_POSITON)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>(){{add(START_POSITON);}};
        Set<String> s = new HashSet<>(){{add(START_POSITON);}};
        Set<String> d = Arrays.stream(deadends).collect(Collectors.toSet());
        int idx = 0;
        if (d.contains(START_POSITON)) {
            return -1;
        }
        while (true) {
            ++idx;
            Queue<String> t = new LinkedList<>();
            while (!q.isEmpty()) {
                String cur = q.poll();
                for (String str: nexts(cur)) {
                    if (s.contains(str) || d.contains(str)) {
                        continue;
                    }
                    if (str.equals(target)) {
                        return idx;
                    }
                    t.add(str);
                    s.add(str);
                }
            }
            if (!t.isEmpty()) {
                q = t;
            } else {
                break;
            }
        }
        return -1;
    }

    private List<String> nexts(String str) {
        List<String> result = new ArrayList<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char c = str.charAt(i);
            char d = (c == '9' ? '0' : (char)(c + 1));
            arr[i] = d;
            result.add(new String(arr));
            arr[i] = c;
            char b = (c == '0' ? '9' : (char)(c - 1));
            arr[i] = b;
            result.add(new String(arr));
            arr[i] = c;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution lt752 = new Solution();
        System.out.println(lt752.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202")); // 6
        System.out.println(lt752.openLock(new String[]{"8888"}, "0009")); // 1
        System.out.println(lt752.openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888")); // -1
        System.out.println(lt752.openLock(new String[]{"0000"}, "8888")); // -1
    }
}


/**
Link: https://leetcode-cn.com/problems/open-the-lock/

你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字：'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'。每个拨轮可以自由旋转：例如把'9'变为'0'，'0' 变为'9' 。每次旋转都只能旋转一个拨轮的一位数字。
锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
列表deadends包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
字符串target代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回-1。'0'

示例1:
输入：deadends = ["0201", "0101", "0102", "1212", "2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到"0102"时这个锁就会被锁定。

示例2:
输入: deadends = ["8888"], target = "0009"
输出：1
解释：
把最后一位反向旋转一次即可"0000" -> "0009"。

示例3:
输入: deadends = ["8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"], target = "8888"
输出：-1
解释：
无法旋转到目标数字且不被锁定。

示例4:
输入: deadends = ["0000"], target = "8888"
输出：-1

提示：
1 <= deadends.length <= 500
deadends[i].length == 4
target.length == 4
target不在deadends之中
target和deadends[i] 仅由若干位数字组成
*/

/*

我们可以使用广度优先搜索，找出从初始数字 00000000 到解锁数字 \textit{target}target 的最小旋转次数。

具体地，我们在一开始将 (0000, 0)(0000,0) 加入队列，并使用该队列进行广度优先搜索。在搜索的过程中，设当前搜索到的数字为 \textit{status}status，旋转的次数为 \textit{step}step，我们可以枚举 \textit{status}status 通过一次旋转得到的数字。设其中的某个数字为 \textit{next\_status}next_status，如果其没有被搜索过，我们就将 (\textit{next\_status}, \textit{step} + 1)(next_status,step+1) 加入队列。如果搜索到了 \textit{target}target，我们就返回其对应的旋转次数。

为了避免搜索到死亡数字，我们可以使用哈希表存储 \textit{deadends}deadends 中的所有元素，这样在搜索的过程中，我们可以均摊 O(1)O(1) 地判断一个数字是否为死亡数字。同时，我们还需要一个哈希表存储所有搜索到的状态，避免重复搜索。

如果搜索完成后，我们仍没有搜索到 \textit{target}target，说明我们无法解锁，返回 -1−1。

细节

本题中需要注意如下两个细节：

如果 \textit{target}target 就是初始数字 00000000，那么直接返回答案 00；

如果初始数字 00000000 出现在 \textit{deadends}deadends 中，那么直接返回答案 -1−1。

*/

