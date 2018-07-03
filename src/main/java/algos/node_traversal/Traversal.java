package algos.node_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sofia on 01/03/17.
 * Creates a graph and then traverses it with DFS and BFS
 *
 *                1
 *             /    \
 *            2     3
 *         /| \ \
 *        4 5 6 7
 *            /\
 *           8  9
 *
 */
public class Traversal {
    public static void main(String[] args) {
        List<Node> nodeList3 = new ArrayList<Node>();
        nodeList3.add(new Node(8,null));
        nodeList3.add(new Node(9,null));

        List<Node> nodeList2 = new ArrayList<Node>();
        nodeList2.add(new Node(4,null));
        nodeList2.add(new Node(5,null));
        nodeList2.add(new Node(6,nodeList3));
        nodeList2.add(new Node(7,null));

        List<Node> nodeList1 = new ArrayList<Node>();
        nodeList1.add(new Node(2,nodeList2));
        nodeList1.add(new Node(3,null));

        Node tree = new Node(1,nodeList1);

        System.out.println("Traversing DFS:");
        traverseDFS(tree);
        System.out.println();
        System.out.println("Traversing BFS:");
        traverseBFS(tree);
    }

    private static void traverseBFS(Node tree){
        BFS.traverse(tree);
    }

    private static void traverseDFS(Node tree){
        DFS.traverse(tree);
    }
}
