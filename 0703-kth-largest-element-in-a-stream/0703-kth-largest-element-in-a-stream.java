class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;

        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {

        minHeap.offer(val);

        // keep only k elements
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // kth largest
        return minHeap.peek();
    }
}