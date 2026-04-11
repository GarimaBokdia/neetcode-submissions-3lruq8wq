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
    public List<Integer> inorderTraversal(TreeNode root) {
            result = new ArrayList<>();
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node){
        if(node==null)
          return;

        inorder(node.left);
        result.add(node.val);

        inorder(node.right);
        
        
    }
}