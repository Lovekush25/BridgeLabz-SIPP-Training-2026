class Solution {

    public boolean search(TreeNode root, int target) {

        TreeNode current = root;

        while (current != null) {

            if (target == current.val)
                return true;

            if (target < current.val)
                current = current.left;
            else
                current = current.right;
        }

        return false;
    }
}