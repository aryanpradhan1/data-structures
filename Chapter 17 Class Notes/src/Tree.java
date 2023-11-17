import java.util.List;
import java.util.ArrayList;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    
    private Node root;

    static class Node
    {
        public Object data;
        public List<Node> children;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int sum = 1;
            for (Node child: this.children) {
                sum += child.size();
            }
            return sum;
        }
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        this.root = new Node();
        this.root.data = rootData;
        this.root.children = new ArrayList();

    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        this.root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() 
    {
        return this.root.size();
    }

    // Additional methods will be added in later sections.
public interface  Visitor {
        // The visit method id called for each visited node.
        // @param data: the data of the node being visited
        void visit(Object data);
    }

    /*
     * Traverse this tree in preorder.
     * @param v: the visitor to be invoked at each node
     */
    public void preorder(Visitor v) {
        Tree.preorder(this.root, v);
    }

    /*
     * Traverse the tree with a given root in preorder
     * @param n: The root of the tree to traverse
     * @param v: The visitor to be invoked at each node
     */
    private static void preorder(Node n, Visitor v) {
        if (n == null) {
            return;
        }

        v.visit(n.data);

        for (Node child: n.children) {
            Tree.preorder(child, v);
        }
    }
}