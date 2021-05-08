package src;

/**
 * Implemenation of the operations of an ADT Address Book
 * 
 * @author Adam Khoukhi
 * @version 1.0
 */

public class AddressBook implements ADTAddressBook {

    /**
     * Backbone of the AddressBook, used to store the contacts
     */
    private BinarySearchTree<Contact> tree;

    /**
     * Keeps track of the number of contacts
     */
    private int count;

    /**
     * Constructs an empty Address Book
     */
    public AddressBook() {
        this.tree = new BinarySearchTree<Contact>();
    }

    /**
     * Inserts a new contact into the Address Book
     * 
     * @param contact Reference to the Contact to be inserted
     */
    public void insert(Contact contact) {
        this.tree.insert(contact);
        this.setCount(this.getCount() + 1); // Increment the count

    }

    /**
     * Returns the number of contacts in the Address Book
     * 
     * @return Integer value representing the number of contacts
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the number of contacts in the Address Book
     * 
     * @param count The new number of contacts
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Returns the Address's book tree
     * @return A reference to the binary tree
     */
    public BinarySearchTree<Contact> getTree(){
        return this.tree;
    }

    /**
     * Sets the Address's book tree to the given tree
     * @param tree A reference to the new tree
     */
    public void setTree(BinarySearchTree<Contact> tree){
        this.tree = tree;
    }
    /**
     * Removes a contact from the Address Book
     * 
     * @param name A reference to the Contact's name
     */
    public void remove(String name) {
        TreeIterator<Contact> iterator = this.tree.iterator();
        iterator.setInorder(); // Inorder traversal
        while (iterator.hasNext()) {
            Contact temp = iterator.next(); 
            if (temp.getName().equals(name)) {
                this.tree.remove(temp);
                this.setCount(this.getCount() - 1); // Decerement the count
                return;
            } else {
                continue; // Continue traversing
            }
        }
    }

    /**
     * Returns whether the Contact exists in the Address book
     * 
     * @param name A reference to the Contact's name
     * @return Boolean of whether the Contact exists
     */
    public boolean contains(String name) {
        TreeIterator<Contact> iterator = this.tree.iterator();
        iterator.setInorder(); // Inorder traversal
        while (iterator.hasNext()) {
            Contact temp = iterator.next();
            if (temp.getName().equals(name)) {
                return true; // Return true if contact matches
            } else {
                continue; // Continue traversing
            }
        }
        return false; // Contact not found
    }

    /**
     * Returns a reference to a Contact whom name is given
     * 
     * @param name A reference to the Contact's name
     * @return Contact of the given name
     */
    public Contact get(String name) {
        TreeIterator<Contact> iterator = this.tree.iterator();
        iterator.setInorder(); // Inorder traversal
        while (iterator.hasNext()) {
            Contact temp = iterator.next();
            if (temp.getName().equals(name)) {
                return temp; // If the two names match
            } else {
                continue; // Continue traversing
            }
        }
        return null; // If no contact matchs 
    }

    /**
     * Returns whether an Address Book is empty
     * 
     * @return A Boolean value of whether the Address Book is empty
     */
    public boolean isEmpty() {
        return this.tree.isEmpty();
    }

    /**
     * Removes all the contacts in an Address Book
     */
    public void makeEmpty() {
        this.setCount(0);
        this.tree.makeEmpty();

    }

    /**
     * Retuns the number of Contacts in the Address Book
     * 
     * @return Integer value represting the number of Contacts present
     */
    public int size() {
        return this.getCount();
    }

}