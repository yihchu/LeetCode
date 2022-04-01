<h1>可怜的小猪</h1>

有buckets桶液体，其中正好有一桶含有毒药，其余装的都是水。它们从外观看起来都一样。为了弄清楚哪只水桶含有毒药，你可以喂一些猪喝，通过观察猪是否会死进行判断。不幸的是，你只有minutesToTest分钟时间来确定哪桶液体是有毒的。</br>

喂猪的规则如下：</br>
选择若干活猪进行喂养</br>
可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。</br>
小猪喝完水后，必须有minutesToDie分钟的冷却时间。在这段时间里，你只能观察，而不允许继续喂猪。</br>
过了minutesToDie分钟后，所有喝到毒药的猪都会死去，其他所有猪都会活下来。</br>
重复这一过程，直到时间用完。</br>
给你桶的数目buckets，minutesToDie和minutesToTest，返回在规定时间内判断哪个桶有毒所需的最小猪数。</br>

示例1：</br>
输入：buckets = 1000, minutesToDie = 15, minutesToTest = 60</br>
输出：5</br>

示例2：</br>
输入：buckets = 4, minutesToDie = 15, minutesToTest = 15</br>
输出：2</br>

示例3：</br>
输入：buckets = 4, minutesToDie = 15, minutesToTest = 30</br>
输出：2</br>

提示：</br>
1 <= buckets <= 1000</br>
1 <= minutesToDie <= minutesToTest <= 100</br>

[Link](https://leetcode-cn.com/problems/poor-pigs/)