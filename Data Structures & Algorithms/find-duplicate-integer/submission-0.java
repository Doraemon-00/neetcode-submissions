class Solution {
    public int findDuplicate(int[] nums) {
        for (int n : nums) {
            int index = Math.abs(n) - 1;
            if (nums[index] < 0) return Math.abs(n);
            nums[index] *= -1;
        }

        return -1;
    }
}
