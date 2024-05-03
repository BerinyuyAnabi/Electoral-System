
/*
*The Voter class represents a voter in the election.
*@param name: the name of the voter
*@param age: the age of the voter
*@param gender: the gender of the voter
*@param citizenship: the citizenship of the voter
*@param voterID: the ID number of the voter
@param hasVoted: a boolean value indicating whether the voter has already voted
*@param stationID: the ID number of the polling station where the voter voted

* @authors Vanessa, Eric, Elizabeth, Rahinatu
*/
class Voter {
  // declaration of attributes of the voter class
  private String name;
  private int age;
  private char gender;
  private String citizenship;
  private String voterID;
  private boolean hasVoted;
  private String stationID;

  /**
   * Constructor:
   * 
   * @param name:        the name of the voter
   * @param age:         the age of the voter
   * @param gender:      the gender of the voter
   * @param citizenship: the citizenship of the voter
   * @param voterID:     the ID number of the voter
   * @param hasVoted:    a boolean value indicating whether the voter has already
   *                     voted
   * 
   */
  public Voter(String name, int age, char gender, String citizenship, String voterID, boolean hasVoted,
      String stationID) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.citizenship = citizenship;
    this.voterID = voterID;
    this.hasVoted = hasVoted;
    this.stationID = stationID;
  }

  /**
   * Accessor method:
   * 
   * @return this.name
   */
  public String getStationID() {
    return stationID;
  }

  /**
   * Mutator method:
   * sets the ID number of the voter
   * 
   * @param voterID: the ID number of the voter
   */
  public String getVoterID() {
    return voterID;
  }
}
