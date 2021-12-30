// From the educative.io course "Grokking the Coding Interview".
// Pattern: Tree Breadth First Search
// Problem: Zigzag Traversal (medium)
// Related LeetCode Problem: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

// Problem Statement:
// Given a binary tree, populate an array to represent its zigzag level order traversal. 
// You should populate the values of all nodes of the first level from left to right, 
// then right to left for the next level and keep alternating in the same manner for the following levels.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        
    }
};

// Time: O(n) to visit every node in the tree.
// Space: O(n) to store the value of every node in the tree.
public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    // Input validation.
    if (root == null) {
        return result;
    }

    // We can use the standard level-order traversal to go from level-to-level, and for the L->R zig.
    // For the R->L zag: we can just use a stack again for the nodes with a flag for swapping.
    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    nodeQueue.offer(root);
    boolean reverseNextLevel = false;

    while (!nodeQueue.isEmpty()) {
        int nodeLevelCount = nodeQueue.size();
        List<Integer> levelValueList = new ArrayList<Integer>();
        Stack<TreeNode> levelNodeStack = new Stack<TreeNode>();
        reverseNextLevel = !reverseNextLevel;

        for (int i = 0; i < nodeLevelCount; i++) {
            TreeNode currentNode = nodeQueue.poll();
            levelValueList.add(currentNode.val);

            // If the next level will be reversed, we need to add left before right,
            // as the Stack will then put the nodes in R -> L order.
            if (reverseNextLevel) {

                if (currentNode.left != null) {
                levelNodeStack.push(currentNode.left);
                }
                if (currentNode.right != null) {
                    levelNodeStack.push(currentNode.right);
                }
            } else {
                if (currentNode.right != null) {
                    levelNodeStack.push(currentNode.right);
                }
                if (currentNode.left != null) {
                    levelNodeStack.push(currentNode.left);
                }
            }
        }

        while (!levelNodeStack.isEmpty()) {
            nodeQueue.offer(levelNodeStack.pop());
        }

        result.add(levelValueList);
    }

    return result;
}