package algos.node_traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS ago implementation using TreeNode structure
 * Created by sofia on 01/03/17.
 */
public class BFS {
    public static void traverse(Node treeNode) {
        // A queue is a FIFO, therefore the elements are polled with the same order as they are added
        // Here, the children are added as we are traversing and will be picked up with the order they are traversed
        Queue<Node> nodesToTraverse = new LinkedList<Node>();
        nodesToTraverse.add(treeNode);

        while (!nodesToTraverse.isEmpty()) {
            Node node = nodesToTraverse.poll();
            System.out.print(node.getNumber()+ " - ");

            if (node.getChildren()==null)
                continue;

            int childCount = node.getChildren().size();

            for (int i=0; i<childCount; i++) {

                nodesToTraverse.add(node.getChildren().get(i));

            }
        }
    }
}
