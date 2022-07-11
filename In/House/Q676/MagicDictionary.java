package In.House.Q676;

import java.util.*;

class MagicDictionary {

    private Map<Integer, List<String>> map;

    public MagicDictionary() {
        this.map = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String word: dictionary) {
            int len = word.length();
            this.map.putIfAbsent(len, new ArrayList<>());
            this.map.get(len).add(word);
        }
    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        List<String> list = this.map.get(len);
        if (Objects.isNull(list)) {
            return false;
        }
        for (String word: list) {
            boolean flag = true;
            int idx = 0;
            for (; idx < len; ++idx) {
                if (searchWord.charAt(idx) == word.charAt(idx)) {
                    continue;
                }
                if (flag) {
                    flag = false;
                } else {
                    break;
                }
            }
            if (!flag && idx == len) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[] {"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello")); // 返回False
        System.out.println(magicDictionary.search("hhllo")); // 将第二个'h'替换为'e'可以匹配"hello"，所以返回True
        System.out.println(magicDictionary.search("hell")); // 返回False
        System.out.println(magicDictionary.search("leetcoded")); // 返回False
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */