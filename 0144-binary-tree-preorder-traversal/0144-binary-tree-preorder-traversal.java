class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        preorder(root, ans);

        return ans;
    }

    public void preorder(TreeNode node,
                          List<Integer> ans) {

        if (node == null) {
            return;
        }

        // Root
        ans.add(node.val);

        // Left
        preorder(node.left, ans);

        // Right
        preorder(node.right, ans);
    }
}