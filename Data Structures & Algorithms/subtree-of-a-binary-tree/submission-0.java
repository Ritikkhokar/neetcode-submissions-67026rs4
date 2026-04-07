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
        if(root == null){
            return false;
        }
        if(root.val == subRoot.val){
            boolean isValid = compareTree(root, subRoot);
            if(isValid){
                return true;
            }
        }
        
       boolean isLeftSubTree = isSubtree(root.left, subRoot);
       if(isLeftSubTree){
         return true;
       }
       boolean isrightSubTree = isSubtree(root.right, subRoot);
       if(isrightSubTree){
         return true;
       }
       return false;
    }

    public static boolean compareTree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if((root == null && subRoot != null) || (root != null && subRoot == null)){
            return false;
        }
        if(root.val == subRoot.val){
           boolean compareLeft = compareTree(root.left, subRoot.left);
           if(!compareLeft){
            return false;
           }
           boolean compareRight = compareTree(root.right, subRoot.right);
           if(!compareRight){
            return false;
           }
           return true;
        }else{
            return false;
        }
    }
}
