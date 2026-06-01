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
        HashMap<Node, Node> oldToNew = new HashMap<>();
        Queue<Node> bfs = new LinkedList<>();

        oldToNew.put(node, new Node(node.val));
        bfs.add(node);
        while(!bfs.isEmpty()) {
            Node curr = bfs.poll();
            for(Node neighbor: curr.neighbors) {
                if(!oldToNew.containsKey(neighbor)) {
                    oldToNew.put(neighbor, new Node(neighbor.val));
                    bfs.add(neighbor);
                }

                oldToNew.get(curr).neighbors.add(oldToNew.get(neighbor));
            }
        }

        return oldToNew.get(node);
    }
}