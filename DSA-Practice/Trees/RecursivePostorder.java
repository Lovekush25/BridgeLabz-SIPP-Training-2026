class Solution {

    public void deleteFolderTree(TreeNode root) {
        if (root == null) return;

        deleteFolderTree(root.left);
        deleteFolderTree(root.right);

        System.out.print(root.val + " ");
    }
}