package src;

/**
 * Specifications on the desgin of an ADT Address book
 * 
 * @author Adam Khoukhi
 * @version 1.0
 */
public interface ADTAddressBook {
    /**
     * Adds a new Contact to the Address Book
     * 
     * @param item A reference to the added Contact
     */
    public void insert(Contact contact);

    /**
     * Removes a specified Contact from the Address Book
     * 
     * @param name A reference to the removed Contact's name
     */
    public void remove(String name);

    /**
     * Returns whether a Contact is in the Address Book
     * 
     * @param name A reference to the name of the Contact
     * @return A Boolean value of whether the Contact is in the Address Book or not
     */
    public boolean contains(String name);

    /**
     * Returns the Contact of through it's name
     * 
     * @param name A reference to the Contact's name
     * @return Contact the Contact of the specified name
     */
    public Contact get(String name);

    /**
     * Returns whether an Address Book is empty
     * 
     * @return A Boolean value of whether the Address Book is empty
     */
    public boolean isEmpty();

    /**
     * Removes all the contacts in an Address Book
     */
    public void makeEmpty();

    /**
     * Retuns the number of Contacts in the Address Book
     * 
     * @return Integer value represting the number of Contacts present
     */
    public int size();

}
