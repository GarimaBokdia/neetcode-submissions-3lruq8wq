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
class Solution {
     List<Integer> result;
    public List<Integer> preorderTraversal(TreeNode root) {
            result = new ArrayList<>();
        preorder(root);
        return result;
    }

    private void preorder(TreeNode node){
        if(node==null)
          return;

        result.add(node.val);
        preorder(node.left);
        preorder(node.right);
        
        
    }
}