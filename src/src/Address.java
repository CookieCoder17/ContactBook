package src;

/**
 * Represents the address for a specific contact
 * 
 * @author Adam Khoukhi
 * @version 1.0
 */

public class Address {

    /**
     * The Street data of the contact
     */
    private String street;

    /**
     * The City data of the contact
     */
    private String city;

    /**
     * The state data of the contact
     */
    private String state;

    /**
     * The zipcode data of the contact
     */
    private String zipcode;

    /**
     * Constructs a new Address for a contact
     * 
     * @param street  A reference to the street of this contact
     * @param city    A reference to the city of this contact
     * @param state   A reference to the state of this contact
     * @param zipcode A reference to the zipcode of this contact
     */
    public Address(String street, String city, String state, String zipcode) {
        this.setStreet(street);
        this.setCity(city);
        this.setState(state);
        this.setZipcode(zipcode);
    }

    /**
     * Retuns the value of the Zipcode
     * 
     * @return zipcode the String value of the Zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Sets the value of the Zipcode
     * 
     * @param zipcode the String value of the Zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Retuns the value of the State
     * 
     * @return state the String value of the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state
     * 
     * @param state the String value of the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Retuns the value of the city
     * 
     * @return city the String value of the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city
     * 
     * @param city the String value of the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retuns the value of the street
     * 
     * @return street the String value of the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street
     * 
     * @param street the String value of the street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Retuns the String value of the Address
     * 
     * @return String value of the Address
     */
    @Override
    public String toString() {
        return this.getStreet() + " " + this.getCity() + " " + this.getState() + " " + this.getZipcode();
    }

}
