class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        // if same tree found
        if (isSame(root, subRoot)) return true;

        // check left or right
        return isSubtree(root.left, subRoot) || 
               isSubtree(root.right, subRoot);
    }

    // helper function (same as Q100)
    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;

        return isSame(a.left, b.left) && 
               isSame(a.right, b.right);
    }
}