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
    static int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }

    public static int findMax(TreeNode node){
        if(node == null)return 0;
       int ans = node.val;
       int leftSum = findMax(node.left);
       int rightSum = findMax(node.right);
       if(leftSum>0){
        ans += leftSum;
       }
       if(rightSum>0){
        ans += rightSum;
       }
       maxSum = Math.max(ans, maxSum);
       int temp = Math.max(0,(Math.max(leftSum, rightSum)));

       return temp + node.val;
       
    }
}
