class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // if leaf node → check sum
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // reduce sum and go deeper
        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining) || 
               hasPathSum(root.right, remaining);
    }
}