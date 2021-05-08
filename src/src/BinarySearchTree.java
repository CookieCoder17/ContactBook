package src;

/**
 * Represents a binary search tree with additional operations
 * 
 * @author Adam Khoukhi
 * @version 1.0
 */

public class BinarySearchTree<E extends Comparable<E>> extends BaseBinaryTree<E> {

    /**
     * Constructs an emoty binary tree
     */
    public BinarySearchTree() {
        super();
    }

    /**
     * Constructs a one node binary tree
     * 
     * @param element The data of the root node
     */
    public BinarySearchTree(E element) {
        super(element);
    }

    /**
     * Returns a tree iterator that has a reference to this tree
     * 
     * @return An instance of the TreeIterator of this binary tree
     */
    public TreeIterator<E> iterator() {
        return new TreeIterator<E>(this);
    }

    /**
     * Replaces the data of the root node or creates a root node with the value
     * 
     * @param element A reference to the root's new value
     */
    @Override
    public void setRoot(E element) {
        if (this.root != null) {
            this.root.setElement(element);
        } else {
            this.root = new TreeNode<E>(element);
        }
    }

    /**
     * Inserts a new TreeNode into this tree
     * 
     * @param element A reference to the data of the new Tree Node
     */
    public void insert(E element) {
        this.root = insert(this.root, element);
    }

    /**
     * Returns the new modified binary tree and inserts the new node
     * 
     * @param treenode TreeNode to insert the new node to
     * @param element  A reference to the new node's data
     * @return TreeNode new Tree with the new tree node inserted
     */
    private TreeNode<E> insert(TreeNode<E> treenode, E element) {
        if (treenode == null) {
            return new TreeNode<E>(element); // If the root node is null
        } else {
            if (treenode.getElement().compareTo(element) > 0) {
                treenode.setLeft(insert(treenode.getLeft(), element)); // Recursive call
            } else {
                treenode.setRight(insert(treenode.getRight(), element)); // Recursive call
            }
        }
        return treenode;
    }

    public boolean contains(E element) {
        TreeNode<E> temp = this.root; // current node
        while (temp != null) {
            if (temp.getElement().compareTo(element) == 0) {
                return true;
            } else if (temp.getElement().compareTo(element) > 0) {
                temp = temp.getLeft(); // Recusrive call
            } else {
                temp = temp.getRight(); // Recusrive call
            }
        }
        return false; // If not found return false
    }

    /**
     * Remvoes a treeNode through its value
     * 
     * @param element A reference to the data of the removed Tree Node
     */
    public TreeNode<E> remove(E element) {
        return this.root = remove(this.root, element);
    }

    /**
     * Returns the new modified binary tree
     * 
     * @param treenode TreeNode to remove from the tree
     * @param element  A reference to the removed node's data
     * @return TreeNode new Tree with the specified tree node removed
     * @exception TreeException thrown when node doesn't exist
     */
    private TreeNode<E> remove(TreeNode<E> treenode, E element) throws TreeException {
        if (treenode == null) {
            throw new TreeException("TreeException: Value doesn't exist!");
        } else if (treenode.getElement().compareTo(element) > 0) {
            treenode.setLeft(remove(treenode.getLeft(), element)); // If the element is lexicographically greater
        } else if (treenode.getElement().compareTo(element) < 0) {
            treenode.setRight(remove(treenode.getRight(), element)); // If the element is lexicographically smaller
            // If neither smaller nor greater nor null
        } else {
            if (treenode.getLeft() == null) {
                return treenode.getRight(); // Node with only left child
            } else if (treenode.getRight() == null) {
                return treenode.getLeft(); // Node with only right child
            } else {
                TreeNode<E> rightMostChild = findRightMostChild(treenode.getLeft()); // Find the right most child
                swapElement(treenode, rightMostChild); // Swap the values of the right most child and the node
                treenode.setLeft(remove(treenode.getLeft(), rightMostChild.getElement())); // Remove the right most
                                                                                           // child
            }
        }
        return treenode;
    }

    /**
     * Helper Method: Traverses and returns the right most child
     * 
     * @param treenode A reference to the TreeNode whom most right child will be
     *                 returned
     * @return TreeNode the most Right Child of the given TreeNode
     */
    private TreeNode<E> findRightMostChild(TreeNode<E> treenode) {
        while (treenode.getElement() != null) {
            treenode.setRight(findRightMostChild(treenode.getRight())); // Recursive call until the right most child is
                                                                        // found
        }
        return treenode.getRight(); // Most right child
    }

    /**
     * Helper Method: Swaps the data of two given TreeNodes
     * 
     * @param a The First TreeNode
     * @param b The Second TreeNode
     */
    private void swapElement(TreeNode<E> a, TreeNode<E> b) {
        E tempElement = a.getElement(); // Temporary hold of element a
        a.setElement(b.getElement());
        b.setElement(tempElement);
    }
}
