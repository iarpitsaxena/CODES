package LeetCode;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class _333_Largest_BST_Subtree {

    private TreeNode previous;

    private Boolean isValidBST(TreeNode root){
        if(root == null) return true;

        if(!isValidBST(root.left)) return false;
        if(previous!= null && previous.val >= root.val) return false;

        previous = root;
        return isValidBST(root.right);
    }

    private int countNodes(TreeNode root){
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int largestBSTSubtree(TreeNode root){
        if(root == null) return 0;

        previous = null;

        if(isValidBST(root)){
            return countNodes(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
}
