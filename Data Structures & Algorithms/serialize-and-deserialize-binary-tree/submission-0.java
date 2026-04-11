/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res= new StringBuilder();
        helperSerialize(root,res);
        return res.toString();
    }

    private void helperSerialize(TreeNode root,StringBuilder res){
        if(root == null){
            res.append("null,");
        }else{
            res.append(root.val).append(",");
            helperSerialize(root.left,res);
            helperSerialize(root.right,res);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helperDeserialize(queue);
    }

    private TreeNode helperDeserialize(Queue<String> queue){
        if(queue.isEmpty())
            return null;
        
        String currVal = queue.poll();

        if(currVal.equals("null"))
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(currVal));
        node.left = helperDeserialize(queue);
        node.right = helperDeserialize(queue);

        return node;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));