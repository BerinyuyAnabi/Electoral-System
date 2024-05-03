import java.util.ArrayList;

/**
 * PollingStation class:
 * Operations include the constructor, accessor, mutator methods, hasVoted
 * method, and displayCandidateCountForStation method.
 * 
 * @authors Rahinatu, Elizabeth, Vanessa, Eric
 */
public class PollingStation {

  /**
   * Instance variables:
   */
  private String stationID;
  private String districtID;
  private String nameOfStation;
  private int[] votesCount;
  private ArrayList<String> alreadyVotedIds;

  /**
   * Constructor:
   * 
   * @param stationID:       the ID number of the polling station
   * @param districtID:      the ID number of the district
   * @param nameOfStation:   the name of the polling station
   * @param votesCount:      the vote count for each candidate
   * @param alreadyVotedIds: the list of voter IDs that have already voted
   */
  PollingStation(String stationID, String districtID, String nameOfStation, int numCandidates) {
    this.stationID = stationID;
    this.districtID = districtID;
    this.nameOfStation = nameOfStation;
    this.votesCount = new int[numCandidates];
    this.alreadyVotedIds = new ArrayList<>();
  }

  /**
   * Accessor method:
   * 
   * @return this.stationID
   */
  public String getStationID() {
    return stationID;
  }

  /**
   * Mutator method:
   * 
   * @return this.districtID
   */
  public void setStationID(String stationID) {
    this.stationID = stationID;
  }

  /**
   * Accessor method:
   * @return this.districtID
   */
  public String getDistrictID() {
    return districtID;

  }

  /**
  * Mutator method:
  * @param districtID: the ID number of the district
  */
  public void setDistrictID(String districtID) {
    this.districtID = districtID;
  }


  /**
  * Accessor method:
  * @return this.nameOfStation
  */
  public String getNameOfStation() {
    return nameOfStation;
  }


  /**
  * Mutator method:
  * @param nameOfStation: the name of the polling station
  */
  public void setNameofStation(String nameOfStation) {
    this.nameOfStation = nameOfStation;
  }


  /**
  *increaseCandidateVoteCount method:
  *@param candidateIndex: the index of the candidate in the candidates array
  */
  public void increaseCandidateVoteCount(int candidateIndex) {
    this.votesCount[candidateIndex]++;
  }


  /**
 * Accessor Method
 *@return this.votesCount
  */

  public int getCandidateVoteCount(int candidateIndex) {
    return this.votesCount[candidateIndex];
  }


  /**
  * Accessor Method
  *@return this.alreadyVotedIds
  */
  public void markAsVoted(String voterId) {
    this.alreadyVotedIds.add(voterId);
  }

 /**
 * hasVoted method:
 * checks if the voter has already voted
 * @param voterId: the ID number of the voter
 * @return true if the voter has already voted, false otherwise
 */
  public boolean hasVoted(String voterId) {
    for (String voterID : this.alreadyVotedIds) {
      if (voterID.equalsIgnoreCase(voterId)) {
        return true;
      }
    }

    return false;
  }


  /**
  *displayCandidateStationCount method:
  *@param election: the election object
  *@return candidateCount: the candidate count for the polling station
  */
  public void displayCandidateStationCount(Election election) {
    ArrayList<Candidate> candidates = election.getCandidates();

    System.out.println("Polling Station: " + this.getNameOfStation());
    System.out.println("The count for the various candidates are: ");
    for (int index = 0; index < candidates.size(); index++) {
      System.out.println((index + 1) + ". " + candidates.get(index).getName() + ": " + getCandidateVoteCount(index));
    }
    System.out.println();
  }
}
