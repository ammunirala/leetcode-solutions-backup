class Solution {

    List<TreeNode> list = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {

        inorder(root);

        return buildBalanced(0, list.size() - 1);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }

    private TreeNode buildBalanced(int start, int end) {

        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode root = list.get(mid);

        root.left = buildBalanced(start, mid - 1);
        root.right = buildBalanced(mid + 1, end);

        return root;
    }
}
