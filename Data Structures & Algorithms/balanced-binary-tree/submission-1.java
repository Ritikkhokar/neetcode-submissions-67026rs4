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

class Pair {
    int height;
    boolean isBalanced;

    Pair(int height, boolean isBalanced){
        this.height = height;
        this.isBalanced = isBalanced;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root).isBalanced;
    }

    public Pair checkBalance(TreeNode root){
        if(root == null)return new Pair(0, true);
       Pair leftRootBalance = checkBalance(root.left);
       Pair rightRootBalance = checkBalance(root.right);

       boolean balance =  (leftRootBalance.isBalanced == true  && rightRootBalance.isBalanced == true) ? true : false;
       if(Math.abs(leftRootBalance.height - rightRootBalance.height)>1){
           balance = false;
       }
       int height = Math.max(leftRootBalance.height, rightRootBalance.height) + 1;
       return new Pair(height, balance);     
    }
}
