// LeetCode #144
// https://leetcode.com/problems/binary-tree-preorder-traversal/
//
// Given the root of a binary tree, return the preorder traversal of its nodes' values.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // The preorder traversal of a binary tree visits and processes the nodes in order of: Parent, Left, Right.
 // Because the Parent node is visited before the others, it is "pre".

 // Time: O(n)
 // Space: O(h) where h is the height of the tree
public class Solution {
    public IList<int> PreorderTraversal(TreeNode root) {
        List<int> valueList = new List<int>();
        if (root == null) return valueList;
        Traverse(root, valueList);
        return valueList;
    }

    public void Traverse(TreeNode node, List<int> valueList) {
        valueList.Add(node.val);

        if (node.left != null) {
            Traverse(node.left, valueList);
        }
        if (node.right != null) {
            Traverse(node.right, valueList);
        }
    }
}