public class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private int cap;
    private HashMap<Integer, Node> cache;
    private Node dummyLeft;
    private Node dummyRight;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new HashMap<>();
        this.dummyLeft = new Node(0,0);
        this.dummyRight = new Node(0,0);
        this.dummyLeft.next = dummyRight;
        this.dummyRight.prev = dummyLeft;
    }

    private void remove(Node node) {
        Node tempLeft = node.prev;
        Node tempRight = node.next;
        tempLeft.next = tempRight;
        tempRight.prev = tempLeft;
    }

    private void insert(Node node) {
        Node tempLeft = dummyRight.prev;
        dummyRight.prev = node;
        node.prev = tempLeft;
        tempLeft.next = node;
        node.next = dummyRight;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
        } 
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);
        if(cache.size() > cap) {
            Node lru = this.dummyLeft.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */