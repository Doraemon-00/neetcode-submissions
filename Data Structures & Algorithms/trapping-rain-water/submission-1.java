class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = 0, maxR = 0;
        int res = 0;

        while (l < r) {
            if (height[l] <= height[r]) {
                maxL = Math.max(maxL, height[l]);
                res += maxL - height[l];
                l++;
            } else {
                maxR = Math.max(maxR, height[r]);
                res += maxR - height[r];
                r--;
            }
        }

        return res;
    }
}
