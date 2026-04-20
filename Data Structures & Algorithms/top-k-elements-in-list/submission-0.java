class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        List<int[]> sortedCount = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
            sortedCount.add(new int[] {entry.getValue(), entry.getKey()});
        }
        sortedCount.sort((a, b) -> b[0] - a[0]);

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = sortedCount.get(i)[1];            
        }

        return ans;
    }
}


/*
HashMap <K, V>
K -> element
V -> count
*/