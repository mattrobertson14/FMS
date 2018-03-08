package models;

public class User {
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String id;
    private String personId;

    public User(String userName, String password, String email, String firstName, String lastName, String gender, String id, String personId){
      this.userName = userName;
      this.password = password;
      this.email = email;
      this.firstName = firstName;
      this.lastName = lastName;
      this.gender = gender;
      this.personId = personId;
    }

    public User(String userName, String password, String email, String id, String personId){
      this.userName = userName;
      this.password = password;
      this.email = email;
      this.personId = personId;
    }

    public User(){}

    /** Returns String representing User's username
     * @return User's username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the User's username
     * @param userName type String
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** Returns String representing User's password
     * @return User's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the User's password
     * @param password type String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** Returns String representing User's email
     * @return User's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the User's email
     * @param email type String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Returns String representing User's first name
     * @return User's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the User's first name
     * @param firstName type String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /** Returns String representing User's last name
     * @return User's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the User's last name
     * @param lastName type String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Returns String representing User's gender
     * The only possible values for this is "f" or "m"
     * @return User's gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the User's gender
     * @param gender type String
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    /** Returns String representing User's id
     * @return User's id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the User's id
     * @param id type String
     */
    public void setId(String id) {
        this.id = id;
    }

    public String getPersonId() {
      return personId;
    }

    public void setPersonId(String id) {
      personId = id;
    }
}
