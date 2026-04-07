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
    public boolean isBalanced(TreeNode root) {
        int ans = getHeight(root);
        if(ans == -1){
         return false;
        }else{
         return true;
        }
    }

    public static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
       int leftLength = getHeight(root.left);
       if(leftLength == -1 ){
        return -1;
       }
       int rightLength = getHeight(root.right);
       if(rightLength == -1){
        return -1;
       }
       if(Math.abs(leftLength - rightLength)>1){
        return -1;
       }
       return Math.max(leftLength , rightLength) + 1;

    }
}
