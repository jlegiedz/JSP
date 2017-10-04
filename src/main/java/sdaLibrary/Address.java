package sdaLibrary;


public class Address {

    private String street;
    private String city;
    private String country;
    private String postalCode;
    private String telephoneNumber;

    public Address(){
    }

    public Address(String street, String city, String country, String postalCode, String telephoneNumber) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.telephoneNumber = telephoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
