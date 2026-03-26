class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        // first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // slide window
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }
}