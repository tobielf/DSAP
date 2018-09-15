/**
 * Analysis,
 * This problem very like put the constraints in a certain order during the recursive search.
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean traverse(TreeNode s, TreeNode t) {
        // 1. Reached the end, must be a subtree.
        if (s == null && t == null)
            return true;
        // 2. Otherwise, either one reminds some tree node, not a subtree.
        if (s == null || t == null)
            return false;
        // 3. Values of these nodes are different, not a subtree.
        if (s.val != t.val)
            return false;
        // 4. Values are equal, and two children are subtrees.
        return traverse(s.left, t.left) && traverse(s.right, t.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // Walk on the source tree only.
        // 1. Reached the end, didn't find a valid subtree.
        if (s == null)
            return false;

        // 2. Values of these "roots" are equal, start checking.
        if (s.val == t.val && traverse(s, t))
            return true;

        // 3. Otherwise, the subtree could be in either left child or right child.
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
}