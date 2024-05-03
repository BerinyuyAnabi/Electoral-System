import java.util.ArrayList;

/**
 * Region class
 * Operations include the constructor, accessor , mutator methods, addDistricts,
 * and displayCandidateCountForRegion methods.
 *
 * @authors Vanessa, Eric, Elizabeth, Rahinatu
 * 
 */

public class Region {
  // declare attributes of the region class
  private String regionId;
  private String regionName;
  private ArrayList<District> districts;

  /*
   * constructor
   * *@param regionID: the ID of a particular region
   * 
   * @param regionName: the name of the regions
   */
  public Region(String regionId, String regionName) {
    this.regionName = regionName;
    this.regionId = regionId;
    this.districts = new ArrayList<>();
  }

  /*
   * Accessor methods
   * 
   * @return regonName
   * 
   * @ return regionId
   * 
   * @ return districts
   */
  public String getRegionName() {
    return regionName;
  }

  public String getRegionId() {
    return regionId;
  }

  public ArrayList<District> getDistricts() {
    return this.districts;
  }

  /*
   * mutator methods
   * 
   * @ param regionalName represents the names of the regions
   * 
   * @ param regionalId represents the IDs of the regions
   */

  public void setRegionName(String regionalName) {
    this.regionName = regionalName;
  }

  public void setRegionId(String regionalId) {
    this.regionId = regionalId;
  }

  /*
   * a method to add districts to the district list
   * 
   * @param district represents the district instances to be added to the district
   * list
   */
  public void addDistricts(District districts) {
    this.districts.add(districts);
  }

  /*
   * a method to display the vote counts for each candidate at the regional level
   * 
   * @param election represents the election object
   */
  public int[] displayCandidateCountForRegion(Election election) {
    int[] candidateRegionVoteCount = new int[election.getCandidates().size()];
    ArrayList<Candidate> candidates = election.getCandidates();

    System.out.println("Region: " + this.getRegionName());
    for (int index = 0; index < districts.size(); index++) {
      int[] districtCount = districts.get(index).displayCandidateCountForDistrict(election);

      for (int cIndex = 0; cIndex < election.getCandidates().size(); cIndex++) {
        candidateRegionVoteCount[cIndex] += districtCount[cIndex];
      }
    }
    System.out.println();

    System.out.println("Overall Region Vote Count:");
    for (int indexc = 0; indexc < candidates.size(); indexc++) {
      System.out
          .println((indexc + 1) + ". " + candidates.get(indexc).getName() + ": " + candidateRegionVoteCount[indexc]);
    }
    System.out.println();

    return candidateRegionVoteCount; // return the vote counts for each candidate from the regional level
  }
}
