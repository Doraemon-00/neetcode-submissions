class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, boolean[] picked, List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!picked[i]) {
                curr.add(nums[i]);
                picked[i] = true;
                dfs(nums, picked, curr);
                curr.remove(curr.size() - 1);
                picked[i] = false;
            }
        }

    }
}
