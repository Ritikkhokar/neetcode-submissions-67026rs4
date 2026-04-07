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
    static int ans;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;;
        findMaxSum(root);
        return ans;
    }

    public static int findMaxSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSum = findMaxSum(root.left);
        int rightSum = findMaxSum(root.right);
        int maxSum = Math.max(leftSum, rightSum);
        if(maxSum + root.val>ans){
            ans = maxSum + root.val;
        }
        if(leftSum + rightSum + root.val> ans){
            ans = leftSum + rightSum + root.val;
        }
        if(root.val>ans){
         ans = root.val;
        }
        return Math.max(maxSum + root.val, root.val);
    }
}
