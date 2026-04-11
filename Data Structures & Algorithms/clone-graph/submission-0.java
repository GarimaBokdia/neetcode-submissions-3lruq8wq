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

/*
// Definition for a Node.
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
        if(node==null)
            return null;

        Map<Node,Node> visitedNodes = new HashMap<>(); //using this map fro trraverdsal storing original and its corresponding clone with it
        LinkedList<Node> queue = new LinkedList<>();
        
        queue.add(node);
        visitedNodes.put(node, new Node(node.val));

        while(!queue.isEmpty()){
            Node current = queue.remove();
            for(Node neighbor : current.neighbors){
                Node cloneCurrent = visitedNodes.get(current);
                if(!visitedNodes.containsKey(neighbor)){
                    visitedNodes.put(neighbor,new Node(neighbor.val));
                    queue.add(neighbor);
                }
                cloneCurrent.neighbors.add(visitedNodes.get(neighbor));
            }
        }


        return visitedNodes.get(node);
    }
}