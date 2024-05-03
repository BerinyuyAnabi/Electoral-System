import java.util.ArrayList;

/**
 * District class
 * Operations include the constructor, and accessor , mutator methods and
 * displayCandidateCountForDistrict method.
 *
 * @authors Vanessa, Eric, Elizabeth, Rahinatu
 * 
 */
public class District {

  /**
   * Instance variables
   */
  private String districtId;
  private String districtName;
  private ArrayList<PollingStation> pollingStations;

  /**
   * Constructor:
   * 
   * @param districtId:      the ID number of the district
   * @param districtName:    the name of the district
   * @param pollingStations: the polling stations of the district
   *
   */
  public District(String districtId, String districtName) {
    this.districtId = districtId;
    this.districtName = districtName;
    this.pollingStations = new ArrayList<>();
  }

  /**
   * Accessor method:
   * 
   * @return this.districtId
   */
  public String getDistrictId() {
    return districtId;
  }

  /**
   * Accessor method:
   * 
   * @return this.districtName
   */
  public String getDistrictName() {
    return districtName;
  }

  public ArrayList<PollingStation> getPollingStations() {
    return this.pollingStations;
  }

  /**
   * Mutator method:
   * 
   * @param districtId: the ID number of the district
   */
  public void setDistrictId(String districtId) {
    this.districtId = districtId;
  }

  /**
   * Mutator method:
   * 
   * @param districtName: the name of the district
   */
  public void setDistrictName(String districtName) {
    this.districtName = districtName;
  }

  /**
   * Mutator method:
   * 
   * @param pollingStation: the polling station of the district
   */
  public void addPollingStation(PollingStation pollingStation) {
    this.pollingStations.add(pollingStation);
  }

  /**
   * Accesors method:
   * 
   * @return this.pollingStations
   */
  public ArrayList<PollingStation> getPollingStation() {
    return this.pollingStations;
  }

  /**
   * displayCandidateCountForDistrict method:
   * 
   * @param election: the election object
   * @return candidateCount: the candidate count for the district
   * 
   */
  public int[] displayCandidateCountForDistrict(Election election) {
    int[] candidateDistrictVoteCount = new int[election.getCandidates().size()];
    ArrayList<Candidate> candidates = election.getCandidates();

    System.out.println("District: " + this.getDistrictName());
    for (int index = 0; index < pollingStations.size(); index++) {
      pollingStations.get(index).displayCandidateStationCount(election);

      for (int cIndex = 0; cIndex < election.getCandidates().size(); cIndex++) {
        candidateDistrictVoteCount[cIndex] += pollingStations.get(index).getCandidateVoteCount(cIndex);
      }
    }
    System.out.println();

    System.out.println("Overall District Vote Count:");
    for (int indexd = 0; indexd < candidates.size(); indexd++) {
      System.out
          .println((indexd + 1) + ". " + candidates.get(indexd).getName() + ": " + candidateDistrictVoteCount[indexd]);
    }
    System.out.println();
    return candidateDistrictVoteCount;
  }

}