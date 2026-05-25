class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // count frequencies
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        int maxFreq = 0;

        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // count tasks with max frequency
        int maxCount = 0;

        for (int f : freq) {

            if (f == maxFreq) {
                maxCount++;
            }
        }

        int partCount = maxFreq - 1;

        int partLength = n + 1;

        int answer =
                partCount * partLength + maxCount;

        return Math.max(answer, tasks.length);
    }
}