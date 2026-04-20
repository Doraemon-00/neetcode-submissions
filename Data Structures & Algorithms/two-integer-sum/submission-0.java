class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> need = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            if(need.containsKey(curr)) {
                return new int[]{need.get(curr), i};
            }

            need.put(target - curr, i);
        }

        return new int[0];
    }
}
