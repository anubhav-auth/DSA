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
    int prePtr = 0;
    int[] preorder, inorder;
    Map<Integer, Integer> idxMap = new HashMap<>();

    TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++)
            idxMap.put(inorder[i], i);
        return helper(0, inorder.length - 1);
    }

    TreeNode helper(int inLeft, int inRight) {
        if (inLeft > inRight)
            return null;

        int rootVal = preorder[prePtr++];
        TreeNode root = new TreeNode(rootVal);

        int mid = idxMap.get(rootVal);
        root.left = helper(inLeft, mid - 1);
        root.right = helper(mid + 1, inRight);
        return root;
    }

}