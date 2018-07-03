package algos.node_traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sofia on 01/03/17.
 */
public class BFS {

    public static void traverse(Node treeNode) {

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
