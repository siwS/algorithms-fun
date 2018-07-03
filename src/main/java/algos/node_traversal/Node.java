package algos.node_traversal;

import java.util.List;

/**
 * Created by sofia on 01/03/17.
 */
public class Node {


    int number;
    List<Node> children;


    public Node(int number, List<Node> children) {
        this.number = number;
        this.children = children;
    }


    public int getNumber() {
        return number;
    }

    public List<Node> getChildren() {
        return children;
    }

}
