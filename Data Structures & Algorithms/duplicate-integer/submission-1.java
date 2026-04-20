class Solution {
    public boolean hasDuplicate(int[] nums) {
        if ( nums == null || nums.length == 0) return false;

        Set<Integer> uniqueElement = new HashSet<>();
        for (int n : nums) {
            if (uniqueElement.contains(n)) return true;
            uniqueElement.add(n);
        }    

        return false;
    }
}