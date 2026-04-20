class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int res = 0;
        
        while (l < r) {
            if (heights[l] <= heights[r]) {
                res = Math.max(heights[l] * (r - l), res);
                l++;
            } else {
                res = Math.max(heights[r] * (r - l), res);
                r--;
            }
        }

        return res;
    }
}
