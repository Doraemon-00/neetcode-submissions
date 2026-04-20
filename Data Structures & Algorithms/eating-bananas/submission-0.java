class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int p : piles) {
            r = Math.max(r, p);
        }
        int res = r;

        while (l <= r) {
            int mid = l + ((r - l) / 2);

            long timeRequired = 0;
            for (int p : piles) {
                //another way of writing Math.ceil((double) p / mid)
                timeRequired += ((long)p + mid - 1) / mid;
            }

            if (timeRequired <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
