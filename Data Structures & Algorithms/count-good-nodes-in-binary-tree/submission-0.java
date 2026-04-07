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
    static int goodNodes = 0;
    public int goodNodes(TreeNode root) {
        goodNodes = 0;
        findGoodNodes(root, Integer.MIN_VALUE);
        return goodNodes;
    }

    public static void findGoodNodes(TreeNode root, int high){
        if(root == null){
            return;
        }
        if(root.val >= high){
         goodNodes++;
         high = root.val;
        }
        // left call
        findGoodNodes(root.left, high);
        // right call
        findGoodNodes(root.right, high);
    }
}
