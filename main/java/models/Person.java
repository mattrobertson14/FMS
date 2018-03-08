package models;

public class Person {
    private String descendant;
    private String personID;
    private String firstName;
    private String lastName;
    private String gender;
    private String father = null;
    private String mother = null;
    private String spouse = null;

    public Person(String personID, String descendant, String firstName, String lastName, String gender){
      this.personID = personID;
      this.descendant = descendant;
      this.firstName = firstName;
      this.lastName = lastName;
      this.gender = gender;
    }

    public Person(){}

    /**
     * Unique identifier for this person (non-empty string)
     * @return String representation of id
     */
    public String getId() {
        return personID;
    }

    /**
     * @param id type String
     */
    public void setId(String personID) {
        this.personID = personID;
    }

    /**
     * User (Username) to which this person belongs
     * @return String representation of descendant
     */
    public String getDescendant() {
        return descendant;
    }

    /**
     * @param descendant type String
     */
    public void setDescendant(String descendant) {
        this.descendant = descendant;
    }

    /**
     * Person’s first name (non-empty string)
     * @return String representation of first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName type String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Person’s last name (non-empty string)
     * @return String representation of last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName type String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Person’s gender (string: “f” or “m”)
     * @return String representation of gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender type String
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * ID of person’s father (possibly null)
     * @return String representation of father's id
     */
    public String getFather() {
        return father;
    }

    /**
     * @param father type String
     */
    public void setFather(String father) {
        this.father = father;
    }

    /**
     * ID of person's mother (possibly null)
     * @return String representation of mother's id
     */
    public String getMother() {
        return mother;
    }

    /**
     * @param mother type String
     */
    public void setMother(String mother) {
        this.mother = mother;
    }

    /**
     * ID of person's spouse (possibly null)
     * @return String representation of spouse's id
     */
    public String getSpouse() {
        return spouse;
    }

    /**
     * @param spouse type String
     */
    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }
}
