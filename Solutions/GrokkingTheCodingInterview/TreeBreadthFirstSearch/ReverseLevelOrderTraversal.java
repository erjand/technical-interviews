// From the educative.io course "Grokking the Coding Interview".
// Pattern: Tree Breadth First Search
// Problem: Reverse Level Order Traversal (easy)
// Related LeetCode Problem: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

// Problem Statement:
// Given a binary tree, populate an array to represent its level-by-level traversal in reverse order, 
// i.e., the lowest level comes first. 
// You should populate the values of all nodes in each level from left to right in separate sub-arrays.

// Solution Notes:
// This problem uses the standard level-order traversal algorithm, but just needs to reverse the levels
// in the result. This can be accomplished with a Stack by popping all of the elements at the end,
// or with a LinkedList by adding each level to the beginning of the LinkedList.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

// Time: O(n) to visit all nodes in the tree.
// Space: O(n) to populate result with the value of each node in the tree.
public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    
    // Input validation.
    if (root == null) {
        return result;
    }

    // We solve this problem in the same way as the normal level-order traversal,
    // but will use a Stack to reverse the levels at the end.
    Stack<List<Integer>> levelStack = new Stack<List<Integer>>();
    
    // Queue is an Interface in Java, with LinkedList being the implementation.
    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>(); 

    // Populate our queue with the provided root.
    nodeQueue.offer(root);
    
    // Continue traversing the tree while our queue has items.
    while (!nodeQueue.isEmpty()) {

        // The number of items in the queue determines how many nodes are in this level.
        int levelNodeCount = nodeQueue.size();
        List<Integer> levelValueList = new ArrayList<Integer>();

        // Process all of the nodes in this level; adding their children to the queue as we go.
        for (int i = 0; i < levelNodeCount; i++) {
            TreeNode currentNode = nodeQueue.poll();
            levelValueList.add(currentNode.val);

            if (currentNode.left != null) {
                nodeQueue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                nodeQueue.offer(currentNode.right);
            }
        }

        // Push our new levelValueList onto the stack.
        levelStack.push(levelValueList);
    }

    // Pop all of the items in our stack into our result: the reverse level-order traversal.
    while (!levelStack.isEmpty()) {
        result.add(levelStack.pop());
    }

    return result;
}