package algos.node_traversal;

import java.util.Stack;

/**
 * DFS ago implementation using TreeNode structure
 * Created by sofia on 01/03/17.
 */
public class DFS {
    public static void traverse(Node treeNode) {
        // A stack is LIFO which means that the last element that was added will be picked up.
        // Therefore, we always first check the last child that was added in the Stack
        Stack<Node> nodesToTraverse = new Stack<Node>();
        nodesToTraverse.push(treeNode);

        while (!nodesToTraverse.isEmpty()) {
            Node node = nodesToTraverse.pop();
            System.out.print(node.getNumber()+ " - ");

            if (node.getChildren()==null)
                continue;

            int childCount = node.getChildren().size();

            // they are in a stack which means that the last one we will add
            // will be picked up first (we want the left most to be picked up first)
            for (int i=childCount-1; i>=0; i--) {

                nodesToTraverse.push(node.getChildren().get(i));

            }
        }
    }
}
