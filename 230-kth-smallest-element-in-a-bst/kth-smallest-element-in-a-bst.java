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
    int kthVal = -1;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        search(root);
        return kthVal;
    }

    public void search(TreeNode root){
        if(root == null) return;
        search(root.left);
        k--;
        if(k == 0) {
            kthVal = root.val;
            k--;
            return;
        }
        else if(k < 0){
            return;
        }
        search(root.right);
    }
}