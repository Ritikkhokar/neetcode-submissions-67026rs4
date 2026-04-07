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
    static Integer previous = null;
    public boolean isValidBST(TreeNode root) {
        previous = null;
        return isValid(root);
    }

    public static boolean isValid(TreeNode root){
        if(root == null){
            return true;
        }
        boolean l = isValid(root.left);
        if(previous != null && root.val<= previous){
            return false;
        }
        previous = root.val;
        boolean r = isValid(root.right);
        return l&&r;
    }

}
