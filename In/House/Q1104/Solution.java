package In.House.Q1104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> pathInZigZagTree(int label) {
        if (label == 1) {
            return new ArrayList<>(){{add(1);}};
        }
        int layer = 1, sum = 1, count = 1, tmp = label - count;
        List<Integer> starts = new ArrayList<>(){{add(0);add(1);}};
        List<Integer> counts = new ArrayList<>(){{add(0);add(1);}};
        while (true) {
            count *= 2;
            starts.add(sum + 1);
            counts.add(count);
            tmp -= count;
            if (tmp < 1) {
                break;
            }
            sum += count;
            ++layer;
        }
        ++layer;
        List<Integer> result = new ArrayList<>();
        tmp = label - sum;
        if (layer % 2 == 0) {
            tmp = counts.get(layer) + 1 - tmp;
        }
        while (layer > 0) {
            int r = 0;
            if (layer % 2 == 0) {
                r = counts.get(layer) + starts.get(layer) - tmp;
            } else {
                r = starts.get(layer) + tmp - 1;
            }
            tmp = (tmp + 1)/2;
            result.add(r);
            --layer;
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        slt.pathInZigZagTree(1).forEach(k -> System.out.print(k + " ")); // [1]
        System.out.println();
        slt.pathInZigZagTree(2).forEach(k -> System.out.print(k + " ")); // [1]
        System.out.println();
        slt.pathInZigZagTree(14).forEach(k -> System.out.print(k + " ")); // [1, 3, 4, 14]
        System.out.println();
        slt.pathInZigZagTree(26).forEach(k -> System.out.print(k + " ")); // [1, 2, 6, 10, 26]
        System.out.println();
    }

}

/**
Link: https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/

在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点逐行依次按“之”字形进行标记。
如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记（如图1.png）。
给你树上某一个节点的标号label，请你返回从根节点到该标号为label节点的路径，该路径是由途经的节点标号所组成的。

示例1：
输入：label = 14
输出：[1, 3, 4, 14]

示例2：
输入：label = 26
输出：[1, 2, 6, 10, 26]

提示：
1 <= label <= 10^6

*/