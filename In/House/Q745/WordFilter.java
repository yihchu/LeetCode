package In.House.Q745;

import java.util.*;

//// 这个方法不管怎么调，都超时
//// 看来就是思路不对
//class WordFilter {
//
//    private Map<String, Integer> idxes;
//    private List<String> words;
//    private Map<Character, Integer> poses;
//    private Map<Character, Set<Character>> map;
//
//    public WordFilter(String[] words) {
//        int len = words.length;
//        this.idxes = new HashMap<>(len);
//        this.words = new ArrayList<>(len);
//        this.poses = new HashMap<>();
//        this.map = new HashMap<>();
//        for (int i = 0; i < len; ++i) {
//            this.idxes.put(words[i], i);
//            this.words.add(words[i]);
//        }
//        Collections.sort(this.words);
//        for (int i = 0; i < len; ++i) {
//            String word = this.words.get(i);
//            char start = word.charAt(0), end = word.charAt(word.length() - 1);
//            if (!this.poses.containsKey(start)) {
//                this.poses.put(start, i);
//                this.map.putIfAbsent(start, new HashSet<>());
//            }
//            this.map.get(start).add(end);
//        }
//    }
//
//    public int f(String pref, String suff) {
//        int idx = -1;
//        char p = pref.charAt(0), s = suff.charAt(suff.length() - 1);
//        if (!this.poses.containsKey(p) || !this.map.get(p).contains(s)) {
//            return idx;
//        }
//        int start = this.poses.get(p);
//        int end = this.words.size();
//        for (char c = (char)(p + 1); c <= 'z'; ++c) {
//            if (this.poses.containsKey(c)) {
//                end = this.poses.get(c);
//                break;
//            }
//        }
//        for (int i = start; i < end; ++i) {
//            String word = this.words.get(i);
//            if (word.charAt(word.length() - 1) != s) {
//                continue;
//            }
//            if (word.startsWith(pref) && word.endsWith(suff)) {
//                idx = Math.max(idx, this.idxes.get(word));
//            }
//        }
//        return idx;
//    }
//
//    public static void main(String[] args) {
//        WordFilter filter = new WordFilter(new String[]{"apple"});
//        System.out.println(filter.f("a", "e")); // 0
//    }
//
//}

// CV 大法
class WordFilter {

    private Map<String, Integer> dictionary;

    public WordFilter(String[] words) {
        this.dictionary = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            int len = word.length();
            for (int prefixLen = 1; prefixLen <= len; ++ prefixLen) {
                for (int suffixLen = 1; suffixLen <= len; ++ suffixLen) {
                    this.dictionary.put(word.substring(0, prefixLen) + "#" + word.substring(len - suffixLen), i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        return this.dictionary.getOrDefault(pref + "#" + suff, -1);
    }

}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */