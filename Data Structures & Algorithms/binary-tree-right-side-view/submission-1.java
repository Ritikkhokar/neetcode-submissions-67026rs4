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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return new ArrayList();
        Deque<TreeNode> dq1 = new ArrayDeque<>();
        Deque<TreeNode> dq2 = new ArrayDeque<>();
        List<Integer> ans = new ArrayList();
        dq1.offerLast(root);
        ans.add(dq1.peekLast().val);
        while(dq1.size()>0){
            while(dq1.size()>0){
              if(dq1.peekFirst().left != null){
                dq2.offerLast(dq1.peekFirst().left);
              }
              if(dq1.peekFirst().right != null){
                dq2.offerLast(dq1.peekFirst().right);
              }
              dq1.pollFirst();
            }
            if(dq2.size()>0){
               ans.add(dq2.peekLast().val);
            }
            
            dq1 = dq2;
            dq2 = new LinkedList<>();
        }
        return ans;
    }
}
