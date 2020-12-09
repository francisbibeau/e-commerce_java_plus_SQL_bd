package entities;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int shipAddressId;
    private int privilege;

    public User() {
    }

    public User(int id, String name, String lastName, String email, String passWord, int shipAddressId, int privilege) {
        
        this.id = id;
        this.firstName = name;
        this.lastName = lastName;
        this.email = email;
        this.password = passWord;
        this.shipAddressId = shipAddressId;
        this.privilege = privilege;
    }
        public User( String name, String lastName, String email, String passWord, int shipAddressId, int privilege) {
        this.id = id;
        this.firstName = name;
        this.lastName = lastName;
        this.email = email;
        this.password = passWord;
        this.shipAddressId = shipAddressId;
        this.privilege = privilege;
    }

    public int getShipAddressId() {

        return this.shipAddressId;
    }

    public int getPrivilege() {
        return privilege;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassWord() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.firstName = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHotmail(String hotmail) {
        this.email = hotmail;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setShipAddressId(int shipAddressId) {
        this.shipAddressId = shipAddressId;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

}
