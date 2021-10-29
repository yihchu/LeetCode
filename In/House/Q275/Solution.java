package In.House.Q275;

public class Solution {

    public int hIndex(int[] citations) {
        int len = citations.length;
        int start = 0, end = len - 1;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) >> 1;
            int tmp = len - mid;
            if (citations[mid] > tmp) {
                --end;
                result = len - mid;
            } else if (citations[mid] < tmp) {
                ++start;
            } else {
                result = len - mid;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.hIndex(new int[]{0, 1, 3, 5, 6})); // 3
        System.out.println(slt.hIndex(new int[]{0, 1, 3, 4, 5, 6})); // 3
        System.out.println(slt.hIndex(new int[]{100})); // 1
    }

}

/**
Link: https://leetcode-cn.com/problems/h-index-ii/

给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的h指数。
h指数的定义: “h代表“高引用次数”（high citations），一名科研人员的h指数是指他（她）的（N篇论文中）总共有h篇论文分别被引用了至少h次。（其余的N-h篇论文每篇被引用次数不多于h次。）"

示例:
输入: citations = [0,1,3,5,6]
输出: 3
解释: 给定数组表示研究者总共有5篇论文，每篇论文相应的被引用了0, 1, 3, 5, 6次。
由于研究者有3篇论文每篇至少被引用了3次，其余两篇论文每篇被引用不多于3次，所以她的h指数是3。

说明:
如果h有多有种可能的值，h指数是其中最大的那个。

进阶：
这是H指数的延伸题目，本题中的citations数组是保证有序的。
你可以优化你的算法到对数时间复杂度吗？

*/
