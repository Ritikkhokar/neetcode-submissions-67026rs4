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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return new ArrayList();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList();
        q1.add(root);
        while(q1.size()>0){
            List<Integer> list = new ArrayList();
            while(q1.size()>0){
              if(q1.peek().left != null){
                q2.add(q1.peek().left);
              }
              if(q1.peek().right != null){
                q2.add(q1.peek().right);
              }
              list.add(q1.remove().val);
            }
            ans.add(list);
            q1 = q2;
            q2 = new LinkedList<>();
        }
        return ans;
    }
}
