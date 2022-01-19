package In.House.Q458;

public class Solution {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) {
            return 0;
        }
        int times = minutesToTest / minutesToDie + 1;
        for (int i = 1; i < buckets; ++i) {
            if (Math.pow(times, i) >= buckets) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.poorPigs(1000, 15, 60)); // 5
        System.out.println(slt.poorPigs(4, 15, 15)); // 2
        System.out.println(slt.poorPigs(4, 15, 30)); // 2
    }

}

/**
Ques: 可怜的小猪
Link: https://leetcode-cn.com/problems/poor-pigs/

有buckets桶液体，其中正好有一桶含有毒药，其余装的都是水。它们从外观看起来都一样。为了弄清楚哪只水桶含有毒药，你可以喂一些猪喝，通过观察猪是否会死进行判断。不幸的是，你只有minutesToTest分钟时间来确定哪桶液体是有毒的。

喂猪的规则如下：
选择若干活猪进行喂养
可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。
小猪喝完水后，必须有minutesToDie分钟的冷却时间。在这段时间里，你只能观察，而不允许继续喂猪。
过了minutesToDie分钟后，所有喝到毒药的猪都会死去，其他所有猪都会活下来。
重复这一过程，直到时间用完。
给你桶的数目buckets，minutesToDie和minutesToTest，返回在规定时间内判断哪个桶有毒所需的最小猪数。

示例1：
输入：buckets = 1000, minutesToDie = 15, minutesToTest = 60         1 500 500 2
输出：5                                                             2 250 250 2

示例2：
输入：buckets = 4, minutesToDie = 15, minutesToTest = 15
输出：2

示例3：
输入：buckets = 4, minutesToDie = 15, minutesToTest = 30
输出：2

提示：
1 <= buckets <= 1000
1 <= minutesToDie <= minutesToTest <= 100

*/


