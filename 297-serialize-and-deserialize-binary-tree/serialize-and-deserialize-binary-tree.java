/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        List<String> data = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                data.add(String.valueOf(node.val));
                q.add(node.left);
                q.add(node.right);
            } else {
                data.add("null");
            }
        }

        return String.join(",", data);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("null") || data.equals(""))
            return null;

        String[] parts = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < parts.length) {
            TreeNode parent = queue.poll();

            if (!parts[i].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(parts[i]));
                queue.add(parent.left);
            }
            i++;

            if (i < parts.length && !parts[i].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(parts[i]));
                queue.add(parent.right);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));