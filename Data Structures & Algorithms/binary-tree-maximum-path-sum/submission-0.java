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
    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       
        helperPathSum(root);
        return globalMax;
    }

    private int helperPathSum(TreeNode node){
        if(node == null)
            return 0;
        
        int rightChildSum = Math.max(0, helperPathSum(node.right));
        int leftChildSum = Math.max(0,helperPathSum(node.left));

        int currSum = node.val + leftChildSum + rightChildSum ;

        globalMax = Math.max(currSum,globalMax);

        return node.val + Math.max(rightChildSum,leftChildSum);
    }
}