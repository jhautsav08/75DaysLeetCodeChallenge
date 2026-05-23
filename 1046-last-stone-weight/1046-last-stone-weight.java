class Solution {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);

        // add all stones
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {

            int y = maxHeap.poll(); // largest
            int x = maxHeap.poll(); // second largest

            // if not equal
            if (y != x) {

                maxHeap.offer(y - x);
            }
        }

        // if empty return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}