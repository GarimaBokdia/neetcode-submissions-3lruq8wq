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

//Recursive solution
// class Solution {
//     TreeNode prev = null;
//     public boolean isValidBST(TreeNode root) {
//         if(root == null)
//         return true;

//         if(!isValidBST(root.left))
//             return false;
        
//         if(prev != null && prev.val >= root.val)
//             return false;

//         prev=root;

//         return isValidBST(root.right);

//     }

// }
//Iterative
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null,current = root;

        while (current != null || !stack.isEmpty()) {
            // 1. Go as far left as possible
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 2. Process the node (Simulate the "bottom" of recursion)
            current = stack.pop();

            // Check if current value violates the strictly increasing order
            if (prev != null && prev.val >= current.val) {
                return false;
            }

            // Update prev to the current node
            prev = current;

            // 3. Move to the right subtree
            current = current.right;
        }

        return true;
    }
}