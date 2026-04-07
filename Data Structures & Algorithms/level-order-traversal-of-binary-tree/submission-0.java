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
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList();
        List<Integer> temp = new ArrayList<>();
        q1.add(root);
        while(q1.size()>0){
          TreeNode t = q1.remove();
          if(t.left != null){
            q2.add(t.left);
          }
          if(t.right != null){
            q2.add(t.right);
          }
          temp.add(Integer.valueOf(t.val));
          if(q1.size() == 0){
            ans.add(temp);
            temp = new ArrayList<>();
            q1 = q2;
            q2 = new LinkedList<>();
          }
        }
        return ans;
    }
}
