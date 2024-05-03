/**
 * This class represents a person in the election.
 * operations include the constructor, and accersor and mutator methods.
 * 
 * @author Vanessa, Eric, Elizabeth, Rahinatu
 */
public class Person {

  /**
   * Instance variables
   */
  protected String name;
  protected int age;
  protected char gender;
  protected String citizenship;
  protected String idNumber;

  /**
   * Constructor:
   * Builds and initializes a Person object
   * 
   * @param name:        the name of the person
   * @param age:         the age of the person
   * @param gender:      the gender of the person
   * @param citizenship: the citizenship of the person
   * @param idNumber:    the id number of the person
   */
  public Person(String name, int age, char gender, String citizenship, String idNumber) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.citizenship = citizenship;
    this.idNumber = idNumber;
  }

  /**
   * Accessor method:
   * return the name of the person
   * 
   * @return this.name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Accessor method:
   * return the age of the person
   * 
   */
  public int getAge() {
    return this.age;
  }

  /**
   * Accessor method:
   * return the gender of the person
   * 
   * @return this.gender
   */
  public char getGender() {
    return this.gender;
  }

  /**
   * Accessor method:
   * return the citizenship of the person
   * 
   * @return this.citizenship
   */
  public String getCitizenship() {
    return this.citizenship;
  }

  /**
   * Accessor method:
   * return the id number of the person
   * 
   * @return this.idNumber
   */
  public String getIdNumber() {
    return this.idNumber;
  }

  /**
   * Mutator method:
   * sets the name of the person
   * 
   * @param name: the name of the person
   */
  public void setName(String pname) {
    this.name = pname;
  }

  /**
   * Mutator method:
   * sets the age of the person
   * 
   * @param age: the age of the person
   */
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Mutator method:
   * sets the gender of the person
   * 
   * @param gender: the gender of the person
   */
  public void setGender(char gender) {
    this.gender = gender;
  }

  /**
   * Mutator method:
   * sets the citizenship of the person
   * 
   * @param citizenship: the citizenship of the person
   */
  public void setCitizenship(String citizen) {
    this.citizenship = citizen;
  }

  /**
   * Mutator method:
   * sets the id number of the person
   * 
   * @param idNumber: the id number of the person
   */
  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  /**
   * eligibleToVote method:
   * checks if the person is eligible to vote
   * 
   * @return true if the person is 18 or older and a citizen, false otherwise
   */
  public boolean eligibleToVote() {
    if (citizenship.equalsIgnoreCase("Ghanaian") && age >= 18) {
      System.out.println("You are eligible to vote!");
      return true;
    } else {
      System.out.println("You are not eligible to vote!");
    }
    return false;

  }

}
