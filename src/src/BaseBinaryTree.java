package src;

/**
 * Represents a binary tree with basic operations
 * 
 * @author Adam Khoukhi
 * @version 1.0
 */
public abstract class BaseBinaryTree<E> {

    /**
     * The root of this tree
     */
    protected TreeNode<E> root;

    /**
     * Creates an empty binary tree
     */
    public BaseBinaryTree() {
        this.root = null;
    }

    /**
     * Creates a one-node binary tree whose root contains the element
     * 
     * @param element the data of the root
     */
    public BaseBinaryTree(E element) {
        this.root = new TreeNode<E>(element);
    }

    /**
     * Returns whether the tree is empty or not
     * 
     * @return A boolean specifying if the tree is empty
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * Removes all nodes from the tree.
     */
    public void makeEmpty() {
        this.root = null;
    }

    /**
     * Returns the tree's root element
     * 
     * @return A reference to the element of the root
     * @throws TreeException thrown if the tree is empty
     */
    public E getRoot() throws TreeException {
        if (this.root == null) {
            throw new TreeException("TreeException: The tree is empty");
        } else {
            return this.root.getElement();
        }
    }

    /**
     * Replaces the data of the root node or creates a root node with the value
     * 
     * @param element A reference to the root's new value
     */
    public abstract void setRoot(E element) throws UnsupportedOperationException;
}
