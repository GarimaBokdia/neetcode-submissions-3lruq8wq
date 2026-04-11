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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        if(isLeaf(root))
            return 1;

         int depth = 0 ; 
         if(root.left != null)
            depth = Math.max(depth, maxDepth(root.left));
         if(root.right != null)
            depth = Math.max(depth, maxDepth(root.right));

        return depth + 1; //adding 1 for current level     
    }

    private boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }
}