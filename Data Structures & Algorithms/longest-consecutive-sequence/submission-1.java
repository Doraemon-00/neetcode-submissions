class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> inputSet = new HashSet<>();
        for (int n : nums) {
            inputSet.add(n);
        }

        int res = 0;
        for (int i : inputSet) {
            if (!inputSet.contains(i - 1)) {
                int length = 1;
                while (inputSet.contains(i + length)) {
                    length++;
                }

                res = Math.max(res, length);
            }
        }

        return res;
    }
}
