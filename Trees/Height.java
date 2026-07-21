class Solution {

    public int height(TreeNode root) {
        if (root == null) return -1;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public boolean isTooDeep(TreeNode root, int threshold) {
        return height(root) > threshold;
    }
}