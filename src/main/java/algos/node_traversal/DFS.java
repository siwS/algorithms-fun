package algos.node_traversal;

import java.util.Stack;

/**
 * Created by sofia on 01/03/17.
 */
public class DFS {


    public static void traverse(Node treeNode) {

        Stack<Node> nodesToTraverse = new Stack<Node>();
        nodesToTraverse.push(treeNode);


        while (!nodesToTraverse.isEmpty()) {

            Node node = nodesToTraverse.pop();
            System.out.print(node.getNumber()+ " - ");

            if (node.getChildren()==null)
                continue;

            int childCount = node.getChildren().size();

            for (int i=childCount-1; i>=0; i--) {

                nodesToTraverse.push(node.getChildren().get(i));

            }
        }

    }
}
