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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)return "";
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        String str = new String();
        while(q1.size()>0){
        while(q1.size()>0){
            if(q1.peek() != null){
                q2.add(q1.peek().left);
                q2.add(q1.peek().right);
                str += q1.remove().val + ",";
            }else{
                q1.remove();
                str +=  "null,";
            }
        }
        q1 = q2;
        q2 = new LinkedList<>();
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] arr = data.split(",");
        TreeNode node = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(node);
        int i=1;
        while(q1.size()>0){
        while(q1.size()>0){
            if(q1.peek() != null){
               if(!arr[i].equals("null")){
                q1.peek().left = new TreeNode(Integer.parseInt(arr[i]));
               }
               q2.add(q1.peek().left);
               i++;
               if(!arr[i].equals("null")){
                q1.peek().right = new TreeNode(Integer.parseInt(arr[i]));
               }
               q2.add(q1.peek().right);
               i++;
            }
            q1.remove();
        }
        q1 = q2;
        q2 = new LinkedList<>();
        }
        return node;
    }
}
