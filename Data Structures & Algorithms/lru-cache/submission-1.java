public class Node {
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val) {
        this.prev = null;
        this.next = null;
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    private Map<Integer, Node> map;
    private int cap;
    private Node dummyLeft;
    private Node dummyRight;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
        this.dummyLeft = new Node(0,0);
        this.dummyRight = new Node(0,0);
        this.dummyRight.prev = dummyLeft;
        this.dummyLeft.next = dummyRight;
    }

    public void insert(Node node) { //Inserting into front of linked list
        Node next = dummyLeft.next;
        node.prev = dummyLeft;
        next.prev = node;
        dummyLeft.next = node;
        node.next = next;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
        if(map.size() > cap) {
            Node lru = dummyRight.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
