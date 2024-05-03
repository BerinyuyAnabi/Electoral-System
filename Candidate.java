import java.util.ArrayList;

//import the scanner class to receive user input when casting a vote for their preferred candidate.
import java.util.Scanner;

/**
 * This class represents a candidate in an election.
 * Candidate has an "is a" relatioship with Person class.
 * It has a name, age, gender, citizenship, and ID number.
 * Operations include the constructor, and accersor and mutator methods.
 * 
 * @authors Vanessa, Eric, Elizabeth, Rahinatu
 */

public class Candidate extends Person {
  // declare the political party attribute of the candidates
  private String politicalParty;

  /**
   * Contructor:
   * 
   * @param name:           the name of the candidate
   * @param age:            the age of the candidate
   * @param gender:         the gender of the candidate
   * @param citizenship:    the citizenship of the candidate
   * @param idNumber:       the ID number of the candidate
   * @param politicalParty: the political party of the candidate
   */
  public Candidate(String name, int age, char gender, String citizenship, String candidateID, String politicalParty,
      int index) {
    super(name, age, gender, citizenship, candidateID);
    this.politicalParty = politicalParty;
  }

  /**
   * returns the political party of the candidate
   * 
   * @return this.politicalParty
   * 
   */
  public String getPoliticalParty() {
    return this.politicalParty;
  }

}