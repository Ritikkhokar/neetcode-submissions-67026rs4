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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       if(root == null && subRoot == null)return true;
       if(root == null && subRoot != null)return false;
       if(root != null && subRoot == null)return false;

       boolean compareTree = false;
       if(root.val == subRoot.val){
           compareTree = compareTree(root, subRoot);
       }
       if(compareTree) return true;
       boolean leftSubTreeCheck = isSubtree(root.left, subRoot);
       boolean rightSubTreeCheck = isSubtree(root.right, subRoot);

       return leftSubTreeCheck || rightSubTreeCheck;
    }
   
    public boolean compareTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null)return true;
        if(root == null && subRoot != null)return false;
        if(root != null && subRoot == null)return false;

        return root.val == subRoot.val && 
        compareTree(root.right, subRoot.right) && 
        compareTree(root.left, subRoot.left);
    }
    
}
