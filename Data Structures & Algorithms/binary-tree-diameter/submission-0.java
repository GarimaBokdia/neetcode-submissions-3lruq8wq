
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
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
       
        calcDiameter(root);
       return diameter;
       
    }

    private int calcDiameter(TreeNode node){
        if(node==null)
            return 0;
        
        int leftLen = calcDiameter(node.left);
        int rightLen = calcDiameter(node.right);

         diameter = Math.max(leftLen+rightLen , diameter);
        
        return (1 + Math.max(leftLen,rightLen));
    }

}