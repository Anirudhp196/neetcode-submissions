class KthLargest {

    private PriorityQueue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<Integer>();
        for(int num: nums) {
            queue.offer(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
    }
    
    public int add(int val) {
        queue.offer(val);
        if(queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
