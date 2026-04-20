class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diffMap = new HashMap<>(); //map:[diff, index]

        for (int i = 0; i < nums.length; i++) {
            if (diffMap.containsKey(nums[i])) {
                return new int[]{diffMap.get(nums[i]), i};
            } 
            diffMap.put(target - nums[i], i);
        }

        return new int[0];        
    }
}
