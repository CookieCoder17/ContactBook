package src;

/**
 * Represents a node in a binary tree. Each tree node contains a data value and
 * and two references, one for the left child and the other for the right child
 * 
 * @author Adam Khoukhi
 * @version 1.0
 */

public class TreeNode<E> {
    /**
     * The data of this node
     */
    private E element;

    /**
     * The reference to the left child of this node
     */
    private TreeNode<E> left;

    /**
     * The reference to the right child of this node
     */
    private TreeNode<E> right;

    /**
     * Constructs a node with an element and two descendant nodes.
     * 
     * @param element A reference to the data of this node
     * @param left    A Reference to the left child of this node
     * @param right   A reference to the right child of this node
     */
    public TreeNode(E element, TreeNode<E> left, TreeNode<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    /**
     * Constructs a node with a given element
     * 
     * @param element A reference to data of this node
     */
    public TreeNode(E element) {
        this(element, null, null);
    }

    /**
     * Constructs a default node
     */
    public TreeNode() {
        this(null, null, null);
    }

    /**
     * Returns the element of this node.
     * 
     * @return A reference to the element of this node
     */
    public E getElement() {
        return element;
    }

    /**
     * Returns the right child of this node.
     * 
     * @return A reference to the tight child of this node
     */
    public TreeNode<E> getRight() {
        return right;
    }

    /**
     * Changes the right child of this node.
     * 
     * @param rightChild A reference to the right child of this node
     */
    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    /**
     * Returns the left child of this node.
     * 
     * @return A reference to the left child of this node
     */
    public TreeNode<E> getLeft() {
        return left;
    }

    /**
     * Changes the left child of this node.
     * 
     * @param leftChild A reference to the left child of this node
     */
    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    /**
     * Changes the element of this node.
     * 
     * @param element The element of this node
     */
    public void setElement(E element) {
        this.element = element;
    }
}
