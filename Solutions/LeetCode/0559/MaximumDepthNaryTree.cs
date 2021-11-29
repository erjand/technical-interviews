// LeetCode #559
// https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
//
// Given a n-ary tree, find its maximum depth.

/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, IList<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

// This algorithm is very similar to #104 - Maximum Depth of Binary Tree.
// For the binary tree you just take the max of either the left subtree or right subtree.
// For the n-ary tree we can just take the max of all the children, or 1 if the node is a leaf with no children.

// Time: O(n)
// Space: O(h) where h is max height of the tree
public class Solution {
    public int MaxDepth(Node root) {
        if (root == null) return 0;

        int localMax = 1;
        foreach (Node node in root.children) {
            int nodeMax = MaxDepth(node) + 1;
            if (nodeMax > localMax) {
                localMax = nodeMax;
            }
        }

        return localMax;
    }
}