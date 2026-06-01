/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Map<Node, Node> oldToNew = new HashMap<>();
        oldToNew.put(node, new Node(node.val));
        Queue<Node> bfs = new LinkedList<>();
        bfs.add(node);

        while(!bfs.isEmpty()) {
            Node curr = bfs.poll();
            for(Node n: curr.neighbors) {
                if(!oldToNew.containsKey(n)) {
                    oldToNew.put(n, new Node(n.val));
                    bfs.add(n);
                }
                oldToNew.get(curr).neighbors.add(oldToNew.get(n));
            }
        }

        return oldToNew.get(node);
    }
}