import java.util.*;

public class LT212 {

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;
        Map<Character, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int[] pos = new int[]{i, j};
                if (map.containsKey(board[i][j])) {
                    map.get(board[i][j]).add(pos);
                    continue;
                }
                map.put(board[i][j], new ArrayList<>() {{add(pos);}});
            }
        }
        List<String> result = new ArrayList<>();
        for (String word: words) {
            if (countChar(word) > map.keySet().size()) {
                continue;
            }
            if (!doFind(word, 0, null, map, new boolean[m][n])) {
                continue;
            }
            result.add(word);
        }
        return result;
    }

    private int countChar(String str) {
        Set<Character> s = new HashSet<>();
        for (int i = 0; i < str.length(); ++i) {
            s.add(str.charAt(i));
        }
        return s.size();
    }

    private boolean doFind(String word, int idx, int[] parent, Map<Character, List<int[]>> map, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }
        if (!map.containsKey(word.charAt(idx))) {
            return false;
        }
        List<int[]> points = map.get(word.charAt(idx));
        for (int[] point: points) {
            if (visited[point[0]][point[1]]) {
                continue;
            }
            if (Objects.nonNull(parent) && !isNear(parent, point)) {
                continue;
            }
            visited[point[0]][point[1]] = true;
            if (doFind(word, idx + 1, point, map, visited)) {
                visited[point[0]][point[1]] = false;
                return true;
            }
            visited[point[0]][point[1]] = false;
        }
        return false;
    }

    private boolean isNear(int[] parent, int[] point) {
        return ((parent[1] == point[1] && Math.abs(parent[0] - point[0]) == 1)
                || (parent[0] == point[0] && Math.abs(parent[1] - point[1]) == 1));
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        LT212 lt212 = new LT212();
//        lt212.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"})
//                .forEach(r -> System.out.print(r +" "));
//        System.out.println();
//        lt212.findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcb"})
//                .forEach(r -> System.out.print(r +" "));
//        System.out.println();
//        lt212.findWords(
//                new char[][]{{'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a'}
//                , {'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b'}, {'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a'}
//                , {'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b'}, {'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a'}
//                , {'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b'}, {'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a'}
//                , {'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b'}, {'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a'}
//                , {'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b', 'a', 'b'}},
//                new String[]{"ababababaa", "ababababab", "ababababac", "ababababad", "ababababae", "ababababaf"
//                        , "ababababag", "ababababah", "ababababai", "ababababaj", "ababababak", "ababababal"
//                        , "ababababam", "ababababan", "ababababao", "ababababap", "ababababaq", "ababababar"
//                        , "ababababas", "ababababat", "ababababau", "ababababav", "ababababaw", "ababababax"
//                        , "ababababay", "ababababaz", "ababababba", "ababababbb", "ababababbc", "ababababbd"
//                        , "ababababbe", "ababababbf", "ababababbg", "ababababbh", "ababababbi", "ababababbj"
//                        , "ababababbk", "ababababbl", "ababababbm", "ababababbn", "ababababbo", "ababababbp"
//                        , "ababababbq", "ababababbr", "ababababbs", "ababababbt", "ababababbu", "ababababbv"
//                        , "ababababbw", "ababababbx", "ababababby", "ababababbz", "ababababca", "ababababcb"
//                        , "ababababcc", "ababababcd", "ababababce", "ababababcf", "ababababcg", "ababababch"
//                        , "ababababci", "ababababcj", "ababababck", "ababababcl", "ababababcm", "ababababcn"
//                        , "ababababco", "ababababcp", "ababababcq", "ababababcr", "ababababcs", "ababababct"
//                        , "ababababcu", "ababababcv", "ababababcw", "ababababcx", "ababababcy", "ababababcz"
//                        , "ababababda", "ababababdb", "ababababdc", "ababababdd", "ababababde", "ababababdf"
//                        , "ababababdg", "ababababdh", "ababababdi", "ababababdj", "ababababdk", "ababababdl"
//                        , "ababababdm", "ababababdn", "ababababdo", "ababababdp", "ababababdq", "ababababdr"
//                        , "ababababds", "ababababdt", "ababababdu", "ababababdv", "ababababdw", "ababababdx"
//                        , "ababababdy", "ababababdz", "ababababea", "ababababeb", "ababababec", "ababababed"
//                        , "ababababee", "ababababef", "ababababeg", "ababababeh", "ababababei", "ababababej"
//                        , "ababababek", "ababababel", "ababababem", "ababababen", "ababababeo", "ababababep"
//                        , "ababababeq", "ababababer", "ababababes", "ababababet", "ababababeu", "ababababev"
//                        , "ababababew", "ababababex", "ababababey", "ababababez", "ababababfa", "ababababfb"
//                        , "ababababfc", "ababababfd", "ababababfe", "ababababff", "ababababfg", "ababababfh"
//                        , "ababababfi", "ababababfj", "ababababfk", "ababababfl", "ababababfm", "ababababfn"
//                        , "ababababfo", "ababababfp", "ababababfq", "ababababfr", "ababababfs", "ababababft"
//                        , "ababababfu", "ababababfv", "ababababfw", "ababababfx", "ababababfy", "ababababfz"
//                        , "ababababga", "ababababgb", "ababababgc", "ababababgd", "ababababge", "ababababgf"
//                        , "ababababgg", "ababababgh", "ababababgi", "ababababgj", "ababababgk", "ababababgl"
//                        , "ababababgm", "ababababgn", "ababababgo", "ababababgp", "ababababgq", "ababababgr"
//                        , "ababababgs", "ababababgt", "ababababgu", "ababababgv", "ababababgw", "ababababgx"
//                        , "ababababgy", "ababababgz", "ababababha", "ababababhb", "ababababhc", "ababababhd"
//                        , "ababababhe", "ababababhf", "ababababhg", "ababababhh", "ababababhi", "ababababhj"
//                        , "ababababhk", "ababababhl", "ababababhm", "ababababhn", "ababababho", "ababababhp"
//                        , "ababababhq", "ababababhr", "ababababhs", "ababababht", "ababababhu", "ababababhv"
//                        , "ababababhw", "ababababhx", "ababababhy", "ababababhz", "ababababia", "ababababib"
//                        , "ababababic", "ababababid", "ababababie", "ababababif", "ababababig", "ababababih"
//                        , "ababababii", "ababababij", "ababababik", "ababababil", "ababababim", "ababababin"
//                        , "ababababio", "ababababip", "ababababiq", "ababababir", "ababababis", "ababababit"
//                        , "ababababiu", "ababababiv", "ababababiw", "ababababix", "ababababiy", "ababababiz"
//                        , "ababababja", "ababababjb", "ababababjc", "ababababjd", "ababababje", "ababababjf"
//                        , "ababababjg", "ababababjh", "ababababji", "ababababjj", "ababababjk", "ababababjl"
//                        , "ababababjm", "ababababjn", "ababababjo", "ababababjp", "ababababjq", "ababababjr"
//                        , "ababababjs", "ababababjt", "ababababju", "ababababjv", "ababababjw", "ababababjx"
//                        , "ababababjy", "ababababjz", "ababababka", "ababababkb", "ababababkc", "ababababkd"
//                        , "ababababke", "ababababkf", "ababababkg", "ababababkh", "ababababki", "ababababkj"
//                        , "ababababkk", "ababababkl", "ababababkm", "ababababkn", "ababababko", "ababababkp"
//                        , "ababababkq", "ababababkr", "ababababks", "ababababkt", "ababababku", "ababababkv"
//                        , "ababababkw", "ababababkx", "ababababky", "ababababkz", "ababababla", "abababablb"
//                        , "abababablc", "ababababld", "abababable", "abababablf", "abababablg", "abababablh"
//                        , "ababababli", "abababablj", "abababablk", "ababababll", "abababablm", "ababababln"
//                        , "abababablo", "abababablp", "abababablq", "abababablr", "ababababls", "abababablt"
//                        , "abababablu", "abababablv", "abababablw", "abababablx", "abababably", "abababablz"
//                        , "ababababma", "ababababmb", "ababababmc", "ababababmd", "ababababme", "ababababmf"
//                        , "ababababmg", "ababababmh", "ababababmi", "ababababmj", "ababababmk", "ababababml"
//                        , "ababababmm", "ababababmn", "ababababmo", "ababababmp", "ababababmq", "ababababmr"
//                        , "ababababms", "ababababmt", "ababababmu", "ababababmv", "ababababmw", "ababababmx"
//                        , "ababababmy", "ababababmz", "ababababna", "ababababnb", "ababababnc", "ababababnd"
//                        , "ababababne", "ababababnf", "ababababng", "ababababnh", "ababababni", "ababababnj"
//                        , "ababababnk", "ababababnl", "ababababnm", "ababababnn", "ababababno", "ababababnp"
//                        , "ababababnq", "ababababnr", "ababababns", "ababababnt", "ababababnu", "ababababnv"
//                        , "ababababnw", "ababababnx", "ababababny", "ababababnz", "ababababoa", "ababababob"
//                        , "ababababoc", "ababababod", "ababababoe", "ababababof", "ababababog", "ababababoh"
//                        , "ababababoi", "ababababoj", "ababababok", "ababababol", "ababababom", "ababababon"
//                        , "ababababoo", "ababababop", "ababababoq", "ababababor", "ababababos", "ababababot"
//                        , "ababababou", "ababababov", "ababababow", "ababababox", "ababababoy", "ababababoz"
//                        , "ababababpa", "ababababpb", "ababababpc", "ababababpd", "ababababpe", "ababababpf"
//                        , "ababababpg", "ababababph", "ababababpi", "ababababpj", "ababababpk", "ababababpl"
//                        , "ababababpm", "ababababpn", "ababababpo", "ababababpp", "ababababpq", "ababababpr"
//                        , "ababababps", "ababababpt", "ababababpu", "ababababpv", "ababababpw", "ababababpx"
//                        , "ababababpy", "ababababpz", "ababababqa", "ababababqb", "ababababqc", "ababababqd"
//                        , "ababababqe", "ababababqf", "ababababqg", "ababababqh", "ababababqi", "ababababqj"
//                        , "ababababqk", "ababababql", "ababababqm", "ababababqn", "ababababqo", "ababababqp"
//                        , "ababababqq", "ababababqr", "ababababqs", "ababababqt", "ababababqu", "ababababqv"
//                        , "ababababqw", "ababababqx", "ababababqy", "ababababqz", "ababababra", "ababababrb"
//                        , "ababababrc", "ababababrd", "ababababre", "ababababrf", "ababababrg", "ababababrh"
//                        , "ababababri", "ababababrj", "ababababrk", "ababababrl", "ababababrm", "ababababrn"
//                        , "ababababro", "ababababrp", "ababababrq", "ababababrr", "ababababrs", "ababababrt"
//                        , "ababababru", "ababababrv", "ababababrw", "ababababrx", "ababababry", "ababababrz"
//                        , "ababababsa", "ababababsb", "ababababsc", "ababababsd", "ababababse", "ababababsf"
//                        , "ababababsg", "ababababsh", "ababababsi", "ababababsj", "ababababsk", "ababababsl"
//                        , "ababababsm", "ababababsn", "ababababso", "ababababsp", "ababababsq", "ababababsr"
//                        , "ababababss", "ababababst", "ababababsu", "ababababsv", "ababababsw", "ababababsx"
//                        , "ababababsy", "ababababsz", "ababababta", "ababababtb", "ababababtc", "ababababtd"
//                        , "ababababte", "ababababtf", "ababababtg", "ababababth", "ababababti", "ababababtj"
//                        , "ababababtk", "ababababtl", "ababababtm", "ababababtn", "ababababto", "ababababtp"
//                        , "ababababtq", "ababababtr", "ababababts", "ababababtt", "ababababtu", "ababababtv"
//                        , "ababababtw", "ababababtx", "ababababty", "ababababtz", "ababababua", "ababababub"
//                        , "ababababuc", "ababababud", "ababababue", "ababababuf", "ababababug", "ababababuh"
//                        , "ababababui", "ababababuj", "ababababuk", "ababababul", "ababababum", "ababababun"
//                        , "ababababuo", "ababababup", "ababababuq", "ababababur", "ababababus", "ababababut"
//                        , "ababababuu", "ababababuv", "ababababuw", "ababababux", "ababababuy", "ababababuz"
//                        , "ababababva", "ababababvb", "ababababvc", "ababababvd", "ababababve", "ababababvf"
//                        , "ababababvg", "ababababvh", "ababababvi", "ababababvj", "ababababvk", "ababababvl"
//                        , "ababababvm", "ababababvn", "ababababvo", "ababababvp", "ababababvq", "ababababvr"
//                        , "ababababvs", "ababababvt", "ababababvu", "ababababvv", "ababababvw", "ababababvx"
//                        , "ababababvy", "ababababvz", "ababababwa", "ababababwb", "ababababwc", "ababababwd"
//                        , "ababababwe", "ababababwf", "ababababwg", "ababababwh", "ababababwi", "ababababwj"
//                        , "ababababwk", "ababababwl", "ababababwm", "ababababwn", "ababababwo", "ababababwp"
//                        , "ababababwq", "ababababwr", "ababababws", "ababababwt", "ababababwu", "ababababwv"
//                        , "ababababww", "ababababwx", "ababababwy", "ababababwz", "ababababxa", "ababababxb"
//                        , "ababababxc", "ababababxd", "ababababxe", "ababababxf", "ababababxg", "ababababxh"
//                        , "ababababxi", "ababababxj", "ababababxk", "ababababxl", "ababababxm", "ababababxn"
//                        , "ababababxo", "ababababxp", "ababababxq", "ababababxr", "ababababxs", "ababababxt"
//                        , "ababababxu", "ababababxv", "ababababxw", "ababababxx", "ababababxy", "ababababxz"
//                        , "ababababya", "ababababyb", "ababababyc", "ababababyd", "ababababye", "ababababyf"
//                        , "ababababyg", "ababababyh", "ababababyi", "ababababyj", "ababababyk", "ababababyl"
//                        , "ababababym", "ababababyn", "ababababyo", "ababababyp", "ababababyq", "ababababyr"
//                        , "ababababys", "ababababyt", "ababababyu", "ababababyv", "ababababyw", "ababababyx"
//                        , "ababababyy", "ababababyz", "ababababza", "ababababzb", "ababababzc", "ababababzd"
//                        , "ababababze", "ababababzf", "ababababzg", "ababababzh", "ababababzi", "ababababzj"
//                        , "ababababzk", "ababababzl", "ababababzm", "ababababzn", "ababababzo", "ababababzp"
//                        , "ababababzq", "ababababzr", "ababababzs", "ababababzt", "ababababzu", "ababababzv"
//                        , "ababababzw", "ababababzx", "ababababzy", "ababababzz"});
        lt212.findWords(new char[][]{{'a'}, {'a'}}, new String[]{"aa"})
                .forEach(r -> System.out.print(r +" ")); // aa
        System.out.println();


        long end = System.currentTimeMillis();
        System.out.println(">>>>> cost " + (end - start) + " seconds.");
    }

}


/*

给定一个(m x n)二维字符网格board和一个单词（字符串）列表words，找出所有同时在二维网格和字典中出现的单词。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

示例 1：
如图LT212_1.jpg
输入：board = [["o", "a", "a", "n"], ["e", "t", "a", "e"], ["i", "h", "k", "r"], ["i", "f", "l", "v"]], words = ["oath", "pea", "eat", "rain"]
输出：["eat", "oath"]

示例 2：
如图LT212_2.jpg
输入：board = [["a", "b"], ["c", "d"]], words = ["abcb"]
输出：[]

提示：
m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j]是一个小写英文字母
1 <= words.length <= 3 * 10^4
1 <= words[i].length <= 10
words[i]由小写英文字母组成
words中的所有字符串互不相同

*/