package src;

/**
 * Represents a Contact in an AddressBook.
 * 
 * @author Adam Khoukhi
 * @version 1.0
 */

public class Contact implements Comparable<Contact> {

    /**
     * The name of the contact
     */
    private String name;

    /**
     * The address data of the contact
     */
    private Address address;

    /**
     * The phone number of the contact
     */
    private String phone;

    /**
     * Constructs a new Contact from the given input
     * 
     * @param name    A reference to the contact's name
     * @param address A reference to the contact's address
     * @param phone   A reference to the contacts's phone number
     */
    public Contact(String name, Address address, String phone) {
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
    }

    /**
     * Retuns the value of the phone
     * 
     * @return phone the String value of the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone
     * 
     * @param phone the String value of the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Retuns the value of the Address
     * 
     * @return address the Address value of the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address
     * 
     * @param address the Address value of the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Retuns the value of the name
     * 
     * @return name the String value of the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name
     * 
     * @param name the String value of the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Compares two Contact's names
     * 
     * @param o the contact to be compared with
     * @return An Integer representing the comparison
     */
    @Override
    public int compareTo(Contact o) {
        return this.name.compareTo(o.name); // compares by the name
    }

    /**
     * Retuns the String value of the Contact
     * 
     * @return String value of the Contact
     */
    @Override
    public String toString() {
        return this.getName() + "\n" + this.getAddress() + "\n" + this.getPhone();
    }
}
