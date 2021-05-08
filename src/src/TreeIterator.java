package src;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * An iterator over a binary tree
 * 
 * @author Adam Khoukhi
 * @version 1.0
 */

public class TreeIterator<E> implements Iterator<E> {

    /**
     * The collection traversed by the iterator
     */
    private BaseBinaryTree<E> tree;

    /**
     * Ordered List of nodes traversed by the iterator
     */
    private LinkedList<TreeNode<E>> list;

    /**
     * Constructs a new iterator over a binary tree
     * 
     * @param tree A reference to the binary tree
     */
    public TreeIterator(BaseBinaryTree<E> tree) {
        this.tree = tree;
        this.list = new LinkedList<TreeNode<E>>();

    }

    /**
     * Returns whether the iteration has more elements
     * 
     * @return A boolean value of whether more elements exist
     */
    @Override
    public boolean hasNext() {
        return !this.list.isEmpty();
    }

    /**
     * Returns the next element in the iteration
     * 
     * @return E the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() throws NoSuchElementException {
        return this.list.removeFirst().getElement();
    }

    /**
     * Removes from the underlying binary tree the last element returned by this iterator.
     * @throws UnsupportedOperationException if the remove operation is not supported by this iterator
     */
    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Clears the list and sets the traversal type to preorder
     */
    public void setPreorder() {
        this.list.clear();
        this.preorder(this.tree.root);
    }

    /**
     * Clears the list and sets the traversal type to inorder
     */
    public void setInorder() {
        this.list.clear();
        this.inorder(this.tree.root);
    }

    /**
     * Clears the list and sets the traversal type to postorder
     */
    public void setPostorder() {
        this.list.clear();
        this.postorder(this.tree.root);
    }

    /**
     * Helper method: Traverses in preorder
     * 
     * @param treeNode A reference to the treeNode
     */
    private void preorder(TreeNode<E> treeNode) {
        if (treeNode != null) {
            this.list.add(treeNode);
            preorder(treeNode.getLeft());
            preorder(treeNode.getRight());
        }
    }

    /**
     * Helper method: Traverses in inorder
     * 
     * @param treeNode A reference to the treeNode
     */
    private void inorder(TreeNode<E> treeNode) {
        if (treeNode != null) {
            inorder(treeNode.getLeft());
            this.list.add(treeNode);
            inorder(treeNode.getRight());
        }
    }

    /**
     * Helper method: Traverses in postorder
     * 
     * @param treeNode A reference to the treeNode
     */
    private void postorder(TreeNode<E> treeNode) {
        if (treeNode != null) {
            postorder(treeNode.getLeft());
            postorder(treeNode.getRight());
            this.list.add(treeNode);
        }
    }
}
