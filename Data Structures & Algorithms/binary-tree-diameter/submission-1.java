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
    static int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        getHeight(root);
        return diameter;
    }

    public static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
       int leftLength = getHeight(root.left);
       int rightLength = getHeight(root.right);
       if(leftLength + rightLength>diameter){
        diameter = leftLength + rightLength;
       }
       return Math.max(leftLength , rightLength) + 1;

    }
}
