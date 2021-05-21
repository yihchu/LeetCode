import java.util.*;

public class LT692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> mCounts = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            mCounts.compute(words[i], (key, value) -> Objects.isNull(value) ? 1 : ++value);
        }
        MaxHeap h = new MaxHeap(mCounts.entrySet());
        List<String> results = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            results.add(h.pop());
        }
        return results;
    }

    public static class MaxHeap {

        private Map.Entry<String, Integer>[] data;
        private int top = 1, end = 1;

//        public MaxHeap(Set<Map.Entry<String, Integer>> entries) {
//            end = entries.size();
//            data = new Map.Entry[end + 1];
//            int index = 1;
//            for (Map.Entry<String, Integer> e : entries) {
//                data[index++] = e;
//            }
//            for (int k = end; k > 0; ) {
//                int idx = k;
//                while (idx > 0 && idx / 2 > 0 && compare(data[idx], data[idx / 2]) > 0) {
//                    Map.Entry<String, Integer> tmp = data[idx];
//                    data[idx] = data[idx / 2];
//                    data[idx / 2] = tmp;
//                    idx /= 2;
//                }
//                k = (idx == k ? --k : k);
//            }
//        }

        public MaxHeap(Set<Map.Entry<String, Integer>> entries) {
            data = new Map.Entry[entries.size() + 1];
            for (Map.Entry<String, Integer> e : entries) {
                data[end] = e;
                if (top == end) {
                    ++end;
                    continue;
                }
                int idx = end++;
                while (idx > 0 && idx / 2 > 0) {
                    if (compare(data[idx], data[idx / 2]) > 0) {
                        Map.Entry<String, Integer> tmp = data[idx];
                        data[idx] = data[idx / 2];
                        data[idx / 2] = tmp;
                    }
                    idx /= 2;
                }
            }
            end = entries.size();
        }

        public String pop() {
            String target = data[top].getKey();
            data[top] = data[end];
            data[end--] = null;
            int p = top;
            while (true) {
                int s = p, l = 2 * s, r = l + 1;
                if (l <= end && compare(data[s], data[l]) < 0) {
                    s = l;
                }
                if (r <= end && compare(data[s], data[r]) < 0) {
                    s = r;
                }
                if (s == p) {
                    break;
                }
                Map.Entry<String, Integer> tmp = data[p];
                data[p] = data[s];
                data[s] = tmp;
                p = s;
            }
            return target;
        }

        private int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
            int v = e1.getValue() - e2.getValue();
            return v == 0 ? e2.getKey().compareTo(e1.getKey()) : v;
        }
    }

    public static void main(String[] args) {
        LT692 lt692 = new LT692();
        lt692.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        lt692.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        lt692.topKFrequent(new String[]{"glarko", "zlfiwwb", "nsfspyox", "pwqvwmlgri", "qggx", "qrkgmliewc", "zskaqzwo"
                , "zskaqzwo", "ijy", "htpvnmozay", "jqrlad", "ccjel", "qrkgmliewc", "qkjzgws", "fqizrrnmif", "jqrlad"
                , "nbuorw", "qrkgmliewc", "htpvnmozay", "nftk", "glarko", "hdemkfr", "axyak", "hdemkfr", "nsfspyox"
                , "nsfspyox", "qrkgmliewc", "nftk", "nftk", "ccjel", "qrkgmliewc", "ocgjsu", "ijy", "glarko", "nbuorw"
                , "nsfspyox", "qkjzgws", "qkjzgws", "fqizrrnmif", "pwqvwmlgri", "nftk", "qrkgmliewc", "jqrlad", "nftk"
                , "zskaqzwo", "glarko", "nsfspyox", "zlfiwwb", "hwlvqgkdbo", "htpvnmozay", "nsfspyox", "zskaqzwo"
                , "htpvnmozay", "zskaqzwo", "nbuorw", "qkjzgws", "zlfiwwb", "pwqvwmlgri", "zskaqzwo", "qengse", "glarko"
                , "qkjzgws", "pwqvwmlgri", "fqizrrnmif", "nbuorw", "nftk", "ijy", "hdemkfr", "nftk", "qkjzgws", "jqrlad"
                , "nftk", "ccjel", "qggx", "ijy", "qengse", "nftk", "htpvnmozay", "qengse", "eonrg", "qengse"
                , "fqizrrnmif", "hwlvqgkdbo", "qengse", "qengse", "qggx", "qkjzgws", "qggx", "pwqvwmlgri", "htpvnmozay"
                , "qrkgmliewc", "qengse", "fqizrrnmif", "qkjzgws", "qengse", "nftk", "htpvnmozay", "qggx", "zlfiwwb"
                , "bwp", "ocgjsu", "qrkgmliewc", "ccjel", "hdemkfr", "nsfspyox", "hdemkfr", "qggx", "zlfiwwb", "nsfspyox"
                , "ijy", "qkjzgws", "fqizrrnmif", "qkjzgws", "qrkgmliewc", "glarko", "hdemkfr", "pwqvwmlgri"}, 14)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
        lt692.topKFrequent(new String[]{"rmrypv", "zgsedk", "jlmetsplg", "wnfbo", "hnnftqf", "bxlr", "sviavwoxss",
                "jdbgvc", "zddeno", "rxgw", "hnnftqf", "hdmvplne", "rlmdt", "jlmetsplg", "ous", "rmrypv", "fwxulnpit"
                , "dmhuq", "rxgw", "ledleb", "bxlr", "indbvb", "ckqqibnx", "cub", "ijww", "ehd", "hfhlfqzkcn"
                , "sviavwoxss", "rxgw", "bxjxpfp", "mgqj", "oic", "ptk", "fwxulnpit", "ijww", "sviavwoxss", "bgfvfa"
                , "zfkgsudxq", "alkq", "dmhuq", "zddeno", "rxgw", "zgsedk", "amarxpg", "bgfvfa", "wnfbo", "sviavwoxss"
                , "sviavwoxss", "alkq", "nmclxk", "zgsedk", "bwowfvira", "ous", "bxlr", "zddeno", "rxgw", "ous", "wnfbo"
                , "rmrypv", "sviavwoxss", "ehd", "zgsedk", "jlmetsplg", "abxvhyehv", "ledleb", "wnfbo", "bgfvfa"
                , "bwowfvira", "amarxpg", "wnfbo", "bwowfvira", "dmhuq", "ouy", "bxlr", "rxgw", "oic", "hnnftqf"
                , "ledleb", "rlmdt", "oldainprua", "ous", "ckqqibnx", "dmhuq", "hnnftqf", "oic", "jlmetsplg", "ppn"
                , "amarxpg", "jlgfgwb", "bxlr", "bwowfvira", "hdmvplne", "oic", "ledleb", "bwowfvira", "oic", "ptk"
                , "dmhuq", "abxvhyehv", "ckqqibnx", "indbvb", "ypzfk", "rmrypv", "bxjxpfp", "amarxpg", "dmhuq"
                , "sviavwoxss", "bwowfvira", "zfkgsudxq", "wnfbo", "rxgw", "jxkvrmajri", "cub", "abxvhyehv", "bwowfvira"
                , "indbvb", "ehd", "ckqqibnx", "oic", "ptk", "hnnftqf", "ouy", "oic", "zgsedk", "abxvhyehv", "ypzfk"
                , "ptk", "sviavwoxss", "rmrypv", "oic", "ous", "abxvhyehv", "hnnftqf", "hfhlfqzkcn", "ledleb", "cub"
                , "ppn", "zddeno", "indbvb", "oic", "jlmetsplg", "ouy", "bwowfvira", "bklij", "gucayxp", "zfkgsudxq"
                , "hfhlfqzkcn", "zddeno", "ledleb", "zfkgsudxq", "hnnftqf", "bgfvfa", "jlmetsplg", "indbvb", "ehd"
                , "wnfbo", "hnnftqf", "rlmdt", "bxlr", "indbvb", "jdbgvc", "jlmetsplg", "cub", "jlgfgwb", "ypzfk"
                , "indbvb", "dmhuq", "jlmetsplg", "zgsedk", "rmrypv", "cub", "rxgw", "ledleb", "rxgw", "sviavwoxss"
                , "ckqqibnx", "hdmvplne", "dmhuq", "wnfbo", "jlmetsplg", "bxlr", "zfkgsudxq", "bxjxpfp", "ledleb"
                , "indbvb", "ckqqibnx", "ous", "ckqqibnx", "cub", "ous", "abxvhyehv", "bxlr", "hfhlfqzkcn", "hfhlfqzkcn"
                , "oic", "ten", "amarxpg", "indbvb", "cub", "alkq", "alkq", "sviavwoxss", "indbvb", "bwowfvira"
                , "ledleb"}, 10).forEach(s -> System.out.print(s + " ")); // 9 dmhuq 10 hnnftqf
    }
}