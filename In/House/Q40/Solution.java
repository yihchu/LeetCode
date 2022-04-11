package In.House.Q40;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

//    // 超时
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Set<List<Integer>> result = new HashSet<>();
//        List<Integer> combine = new ArrayList<>();
//        Arrays.sort(candidates);
//        dfs(candidates, target, result, combine, 0);
//        return result.stream().collect(Collectors.toList());
//    }
//
//    private void dfs(int[] candidates, int target, Set<List<Integer>> result, List<Integer> combine, int idx) {
//        if (target == 0) {
//            result.add(new ArrayList<>(combine));
//            return ;
//        }
//        if (idx == candidates.length) {
//            return;
//        }
//        dfs(candidates, target, result, combine, idx + 1);
//        if (target - candidates[idx] >= 0) {
//            combine.add(candidates[idx]);
//            dfs(candidates, target - candidates[idx], result, combine, idx + 1);
//            combine.remove(combine.size() - 1);
//        }
//    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int candidate: candidates) {
            map.put(candidate, map.getOrDefault(candidate, 0) + 1);
        }
        candidates = map.keySet().stream().mapToInt(a -> a).toArray();
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        dfs(0, target, result, new ArrayList<>(), map, candidates);
        return result.stream().collect(Collectors.toList());
    }

    private void dfs(int idx, int target, Set<List<Integer>> result, List<Integer> combine, Map<Integer, Integer> map, int[] candidates) {
        if (target == 0) {
            result.add(new ArrayList<>(combine));
            return ;
        }
        if (idx == candidates.length || target < candidates[idx]) {
            return;
        }
        dfs(idx + 1, target, result, combine, map, candidates);
        int most = Math.min(target / candidates[idx], map.get(candidates[idx]));
        for (int i = 1; i <= most; ++i) {
            combine.add(candidates[idx]);
            dfs(idx + 1, target - i * candidates[idx], result, combine, map, candidates);
        }
        for (int i = 1; i <= most; ++i) {
            combine.remove(combine.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution slt = new Solution();
        System.out.println(slt.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8)); // [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
        System.out.println(slt.combinationSum2(new int[] {2, 5, 2, 1, 2}, 5)); // [[1, 2, 2], [5]]
    }

}

