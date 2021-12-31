// From the educative.io course "Grokking the Coding Interview".
// Pattern: Tree Depth First Search
// Problem: All Paths for a Sum (medium)
// Related LeetCode Problem: https://leetcode.com/problems/path-sum-ii/

// Problem Statement:
// Given a binary tree and a number ‘S’, find all paths from root-to-leaf 
// such that the sum of all the node values of each path equals ‘S’.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

// Time: O(n logn)
// Space: O(n logn)
public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> currentPath = new ArrayList<Integer>();
    
    // Because our recursive method returns void, we take advantage of passing allPaths by reference.
    findAllPaths(root, sum, allPaths, currentPath);
    return allPaths;
}

public static void findAllPaths(TreeNode node, int sum, List<List<Integer>> allPaths, List<Integer> currentPath) {
    // If we made it to a null node, then there was no valid path.
    if (node == null) {
        return;
    }

    currentPath.add(node.val);

    // If we are on a leaf node, check for the targetSum.
    if (node.left == null && node.right == null && node.val == sum) {
        allPaths.add(new ArrayList<Integer>(currentPath));
    } 
    // Otherwise, continue recursing the tree.
    else {
        findAllPaths(node.left, sum - node.val, allPaths, currentPath);
        findAllPaths(node.right, sum - node.val, allPaths, currentPath);
    }

    // Remove the node from our current path and go back up a level.
    currentPath.remove(currentPath.size() - 1);
}