package sdaLibrary;


public class User {

    private int Id;
    private String name;
    private String surname;
    private Address address;
    private Nationality nationality;
    private String pesel;
    private String passportNumber;


    public User(){
    }

    public User(String name, String surname, Address address, Nationality nationality, String pesel, String passportNumber) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.nationality = nationality;
        this.pesel = pesel;
        this.passportNumber = passportNumber;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }
}
