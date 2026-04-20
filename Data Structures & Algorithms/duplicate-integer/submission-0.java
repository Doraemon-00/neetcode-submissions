class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> uniqueSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(uniqueSet.contains(nums[i])) return true;
            uniqueSet.add(nums[i]);
        }

        return false;
    }
}

