class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;

        for (int n : nums) {
            if (!mp.containsKey(n)) {
                mp.put(n, mp.getOrDefault(n - 1, 0) + mp.getOrDefault(n + 1, 0) + 1);
                mp.put(n - mp.getOrDefault(n - 1, 0), mp.get(n));
                mp.put(n + mp.getOrDefault(n + 1, 0), mp.get(n));

                res = Math.max(res, mp.get(n));
            }
        }

        return res;

    }
}
