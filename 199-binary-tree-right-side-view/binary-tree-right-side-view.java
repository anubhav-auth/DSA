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
        List<Integer> l = new ArrayList<>();
        if(root == null) return l;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            TreeNode node = new TreeNode();

            for(int i = 0; i < size; i++){
                node = q.poll();

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            l.add(node.val);
        }

        return l;

    }
}