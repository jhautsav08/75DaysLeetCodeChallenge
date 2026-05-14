class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // find maximum pile
        for (int bananas : piles) {
            right = Math.max(right, bananas);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            long hours = 0;

            // calculate hours needed
            for (int bananas : piles) {

                hours += (bananas + mid - 1) / mid;
            }

            // can finish
            if (hours <= h) {

                right = mid;
            }
            else {

                left = mid + 1;
            }
        }

        return left;
    }
}