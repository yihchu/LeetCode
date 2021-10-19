import java.util.*;
import java.util.stream.Collectors;

//// 超时
//public class LT211 {
//
//    private Set<String> dictionary;
//
////    public WordDictionary() {
//    public LT211() {
//        this.dictionary = new HashSet<>();
//    }
//
//    public void addWord(String word) {
//        this.dictionary.add(word);
//    }
//
////    // 超时
////    public boolean search(String word) {
////        if (this.dictionary.contains(word)) {
////            return true;
////        }
////        int len = word.length();
////        Set<String> lefts = this.dictionary.stream().filter(s -> s.length() == len).collect(Collectors.toSet());
////        for (int i = 0; i < len; ++i) {
////            int idx = i;
////            lefts = lefts.stream()
////                    .filter(s -> word.charAt(idx) == '.' || word.charAt(idx) == s.charAt(idx))
////                    .collect(Collectors.toSet());
////        }
////        return !lefts.isEmpty();
////    }
//
////    // 超时
////    public boolean search(String word) {
////        if (this.dictionary.contains(word)) {
////            return true;
////        }
////        int len = word.length();
////        for (String s: this.dictionary) {
////            if (s.length() != len) {
////                continue;
////            }
////            boolean flag = true;
////            for (int i = 0; i < len; ++i) {
////                if (word.charAt(i) != '.' && word.charAt(i) != s.charAt(i)) {
////                    flag = false;
////                    break;
////                }
////            }
////            if (flag) {
////                return true;
////            }
////        }
////        return false;
////    }
//
//    public static void main(String[] args) {
//        LT211 lt211 = new LT211();
//        lt211.addWord("bad");
//        lt211.addWord("dad");
//        lt211.addWord("mad");
//        System.out.println(lt211.search("pad")); // return False
//        System.out.println(lt211.search("bad")); // return True
//        System.out.println(lt211.search(".ad")); // return True
//        System.out.println(lt211.search("b..")); // return True
//    }
//
//}

class LT211Node {

    boolean isLeaf;
    HashMap<Character, LT211Node> children;

    public LT211Node(boolean isLeaf) {
        this.isLeaf = isLeaf;
        this.children = new HashMap<>();
    }
}

public class LT211 {

    private LT211Node root;

    //    public WordDictionary() {
    public LT211() {
        this.root = new LT211Node(false);
    }

    public void addWord(String word) {
        int len = word.length();
        Map m = this.root.children;
        for (int i = 0; i < len; ++i) {
            char c = word.charAt(i);
            if (!m.containsKey(c)) {
                m.put(c, new LT211Node(false));
            }
            LT211Node tmp = (LT211Node) m.get(c);
            if (i == len - 1) {
                tmp.isLeaf = true;
            }
            m = ((LT211Node) m.get(c)).children;
        }
    }

    public boolean search(String word) {
        return search(word.toCharArray(), 0, this.root);
    }

    private boolean search(char[] chars, int idx, LT211Node node) {
        int len = chars.length;
        if (idx == len) {
            return node.isLeaf ? true : false;
        }
        if (chars[idx] == '.') {
            return node.children.values().stream().anyMatch(n -> search(chars, idx + 1, n));
        } else if (node.children.containsKey(chars[idx])) {
            return search(chars, idx + 1, node.children.get(chars[idx]));
        }
        return false;
    }

    public static void test1() {
        LT211 lt211 = new LT211();
        lt211.addWord("bad");
        lt211.addWord("dad");
        lt211.addWord("mad");
        System.out.println(lt211.search("pad")); // return False
        System.out.println(lt211.search("bad")); // return True
        System.out.println(lt211.search(".ad")); // return True
        System.out.println(lt211.search("b..")); // return True
    }

    public static void test2() {
        LT211 lt211 = new LT211();
        lt211.addWord("at");
        lt211.addWord("and");
        lt211.addWord("an");
        lt211.addWord("add");
        lt211.addWord("a");
        System.out.println(lt211.search("a")); //
        System.out.println(lt211.search(".at")); //
        lt211.addWord("bat");
        System.out.println(lt211.search(".at")); //
        System.out.println(lt211.search("an.")); //
        System.out.println(lt211.search("a.d.")); //
        System.out.println(lt211.search("b.")); //
        System.out.println(lt211.search("a.d")); //
        System.out.println(lt211.search(".")); //
    }
    public static void main(String[] args) {
//        test1();
        test2();
    }

}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/**
Link: https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/

请你设计一个数据结构，支持添加新单词和查找字符串是否与任何先前添加的字符串匹配。
实现词典类WordDictionary：
WordDictionary()初始化词典对象
void addWord(word)将word添加到数据结构中，之后可以对它进行匹配
bool search(word)如果数据结构中存在字符串与word匹配，则返回true；否则，返回false。word中可能包含一些'.'，每个. 都可以表示任何一个字母。

示例：
输入：
["WordDictionary", "addWord", "addWord", "addWord", "search", "search", "search", "search"]
[[], ["bad"], ["dad"], ["mad"], ["pad"], ["bad"], [".ad"], ["b.."]]
输出：
[null, null, null, null, false, true, true, true]
解释：
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True

提示：
1 <= word.length <= 500
addWord中的word由小写英文字母组成
search中的word由'.'或小写英文字母组成
最多调用50000次addWord和search

*/