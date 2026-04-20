class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // both in left
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            // both in right
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            // split point → answer
            else {
                return root;
            }
        }
        return null;
    }
}