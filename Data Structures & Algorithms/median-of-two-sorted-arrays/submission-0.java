class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] small = nums1, big = nums2;
        if (big.length <= small.length) {
            int[] temp = small;
            small = big;
            big = temp;
        }

        int total = small.length + big.length;
        int half = (total + 1) / 2;

        int l = 0, r = small.length;
        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = half - i;

            int smallLeft = i > 0 ? small[i - 1] : Integer.MIN_VALUE;
            int smallRight = i < small.length ? small[i] : Integer.MAX_VALUE;
            int bigLeft = j > 0 ? big[j - 1] : Integer.MIN_VALUE;
            int bigRight = j < big.length ? big[j] : Integer.MAX_VALUE; 

            if (smallLeft <= bigRight && bigLeft <= smallRight) {
                if (total % 2 == 1) {
                    return Math.max(smallLeft, bigLeft);
                }
                return (Math.max(smallLeft, bigLeft) + Math.min(smallRight, bigRight)) / 2.0;
            } else if (smallLeft > bigRight) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return -1;

    }
}
