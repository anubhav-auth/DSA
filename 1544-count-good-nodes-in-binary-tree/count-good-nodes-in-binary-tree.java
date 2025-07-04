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
    int count = 0;
    public int goodNodes(TreeNode root) {
        traverse(root, Integer.MIN_VALUE);

        return count;
    }

    public void traverse(TreeNode root, int max){
        if(root == null) return;
        int curr = max;
        if(root.val >= curr) {
            count++;
            curr = root.val;
        }
        traverse(root.left, curr);
        traverse(root.right, curr);
    }
}