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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return depth(root, subRoot) != -1;
    }

    public int depth(TreeNode root, TreeNode subRoot){
        if(root == null) return -1;

        int left = depth(root.left, subRoot);
        if(left == 0) return 0;
        
        int right = depth(root.right, subRoot);
        if(right == 0) return 0;

        return compare(root, subRoot);
    }

    public int compare(TreeNode p, TreeNode q){
        if(p == null && q == null) return 0;

        if(p == null || q == null) return -1;
        if(p.val != q.val) return -1;

        int left = compare(p.left,q.left);
        if(left == -1) return -1;

        int right = compare(p.right,q.right);
        if(right == -1) return -1;

        return 0;
    }
}