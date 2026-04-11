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
      Map<Integer,Integer> indexMap = new HashMap<>();
      int preOrderIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        
        //creating hashmap using inorder
      
        for(int i=0;i < inorder.length; i++){
            indexMap.put(inorder[i],i);
        }
        return createTree(preorder,0,preorder.length-1);
    }

    private TreeNode createTree(int[] preorder,int left, int right){
        if(left>right)
            return null;
        
        int rootVal = preorder[preOrderIndex++];
        int rootIndex = indexMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = createTree(preorder,left,rootIndex-1);
        root.right = createTree(preorder,rootIndex+1,right);
        return root;
    }
}
