class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void dfs(int[] candidates, int target, int i, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            if (target < candidates[j]) {
                return;
            }
            curr.add(candidates[j]);
            dfs(candidates, target - candidates[j], j + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
