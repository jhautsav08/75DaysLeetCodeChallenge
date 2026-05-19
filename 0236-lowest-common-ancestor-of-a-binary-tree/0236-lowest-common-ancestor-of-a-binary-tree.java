class Solution {

    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        // base case
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left =
                lowestCommonAncestor(root.left, p, q);

        TreeNode right =
                lowestCommonAncestor(root.right, p, q);

        // both sides found
        if (left != null && right != null) {
            return root;
        }

        // return whichever side found node
        if (left != null) {
            return left;
        }

        return right;
    }
}