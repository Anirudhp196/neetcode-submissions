class MedianFinder {

    private int size;
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a));
        right = new PriorityQueue<Integer>();
        size = 0;
    }
    
    public void addNum(int num) {
        if(left.size() <= right.size()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
        size++;
    }
    
    public double findMedian() {
        if(size % 2 == 0) {
            return (double) (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}
