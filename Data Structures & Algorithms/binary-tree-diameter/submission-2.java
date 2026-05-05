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
    static int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        findHeight(root);
        return diameter;
        
    }

    public static int findHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftNodeLength = findHeight(root.left);
        int rightNodeLength = findHeight(root.right);
        if(leftNodeLength + rightNodeLength > diameter){
            diameter = leftNodeLength + rightNodeLength;
        }
        return Math.max(leftNodeLength, rightNodeLength) + 1;
    } 
}
