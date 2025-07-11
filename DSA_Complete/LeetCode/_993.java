/*
package LeetCode;

import javax.swing.tree.TreeNode;

public class _993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return(
                (level(root,xx,0) == level(root,yy,0)) && (!isSibling(root,xx,yy))
                )
    }

    TreeNode findNode(TreeNode node, int x){
        if(node == null) return null;
        if(node.val == x) return node;

        TreeNode n = findNode(node.left, x);
        if(n != null){
            return n;
        }
        return findNode(node.right, x);
    }

    boolean isSibling(TreeNode node, TreeNode x,TreeNode y){
        if(node == null) return false;

        return(node.left == x && node.right == y) || (node.left == y && node.right == x)
                || isSibling(node.left, x, y) || isSibling(node.right, x, y);
    }

    int level(TreeNode node, TreeNode x, int lev){
        if(node == null) return 0;

        if(node == x) return lev;

        int l = level(node.left,x,lev + 1);
        if(l != 0) return l;
        return level(node.right,x,lev + 1);
    }
}
*/

package LeetCode;

public class _993 {

    public static void main(String[] args) {
        // Constructing this binary tree:
        //         1
        //        / \
        //       2   3
        //      /
        //     4
        //
        // 4 and 3 are NOT cousins (different levels)
        // 4 and 5 (if 5 added under node 3) WOULD be cousins

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        _993 solution = new _993();
        boolean result = solution.isCousins(root, 4, 3);
        System.out.println("Are 4 and 3 cousins? " + result); // Expected: false
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy));
    }

    TreeNode findNode(TreeNode node, int x) {
        if (node == null) return null;
        if (node.val == x) return node;

        TreeNode n = findNode(node.left, x);
        if (n != null) return n;

        return findNode(node.right, x);
    }

    boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) return false;

        return (node.left == x && node.right == y) || (node.left == y && node.right == x)
                || isSibling(node.left, x, y) || isSibling(node.right, x, y);
    }

    int level(TreeNode node, TreeNode x, int lev) {
        if (node == null) return 0;
        if (node == x) return lev;

        int l = level(node.left, x, lev + 1);
        if (l != 0) return l;
        return level(node.right, x, lev + 1);
    }

    // Your static TreeNode class here
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }
}
