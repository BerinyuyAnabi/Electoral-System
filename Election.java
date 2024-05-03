import java.util.ArrayList;

/**
* This class represents an election.
* @param code: the code of the election
*@param name: the name of the election
*@param regions: the list of regions in the election
@param candidates: the list of candidates in the election
*@param voters: the list of voters in the election
*/

public class Election {
    private String code;
    private String electionName;
    private ArrayList<Candidate> candidates;
    private ArrayList<Region> regions;
    private ArrayList<Voter> voters;

 /**
 * Constructor:
 * @param code: the code of the election
 * @param name: the name of the election
 *@param regions: the list of regions in the election
 *@param candidates: the list of candidates in the election
 *@param voters: the list of voters in the election
 */

    public Election(String code, String electionName) {
        this.code = code;
        this.electionName = electionName;
        this.candidates = new ArrayList<>();
        this.regions = new ArrayList<>();
        this.voters = new ArrayList<>();
    }

  /**
  * Accessor method:
  * @return this.code
  */
    public String getCode() {
        return code;
    }


  /**
  * Getter method:
  * @return this.electionName
  */
    public String getElectionName() {
        return electionName;
    }

  /**
  * Getter method:
  * @return this.candidates
  */

    public ArrayList<Region> getRegions() {
        return this.regions;
    }


  /**
  * Getter method:
  * An ArrayList
  *return cadidates
  *@return this.candidates
  */
    public ArrayList<Candidate> getCandidates() {
        return this.candidates;
    }

  
  /**
  * getVoterByID:
  * @param id: the ID number of the voter
  * @return the voter object if found, null otherwise
  */
    public Voter getVoterByID(String voterID) {
        for (Voter voter : this.voters) {
            if (voter.getVoterID().equalsIgnoreCase(voterID)) {
                return voter;
            }
        }

        return null;
    }
// Setters
    public void setCode(String code) {
        this.code = code;
    }

    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }

  /**
  * This method adds a region to the election.
  *@param region: The region to be added.
  */
  
    public void addRegion(Region region) {
        this.regions.add(region);
    }

  /**
  * This method adds a candidate to the election.
  *@param candidate: The candidate to be added.
  */
    public void addCandidate(Candidate candidate) {
        this.candidates.add(candidate);
    }
  /**
  * This method adds a voter to the election.
  *@param voter: The voter to be added.
  */
    public void addVoter(Voter voter) {
        this.voters.add(voter);
    }

  /**
  * This method displays the candidate count for the Eolection
  *@param regionName: The name of the region to be returned.
  *@return The candidate count for the region.
  */
    public int[] displayCandidateCountForElection() {
        int[] candidateElectionVoteCount = new int[getCandidates().size()];

        System.out.println("Election: " + this.getElectionName());
        for (int index = 0; index < regions.size(); index++) {
            int[] regionalCount = regions.get(index).displayCandidateCountForRegion(this);

            for (int cIndex = 0; cIndex < getCandidates().size(); cIndex++) {
                candidateElectionVoteCount[cIndex] += regionalCount[cIndex];
            }
        }

        System.out.println();

        System.out.println("Overall Election Vote Count:");
        for (int indexe = 0; indexe < candidates.size(); indexe++) {
            System.out.println(
                    (indexe + 1) + ". " + candidates.get(indexe).getName() + ": " + candidateElectionVoteCount[indexe]);
        }
        System.out.println();
        int winnerIndex = 0;
        int winnerCounts = candidateElectionVoteCount[0];
        for (int i = 0; i < candidateElectionVoteCount.length; i++) {
            if (candidateElectionVoteCount[i] > winnerCounts) {
                winnerCounts = candidateElectionVoteCount[i];
                winnerIndex = i;
            }
        }
       //Getting the number of votes the winner receive

        if (winnerCounts != 0) {
            Candidate winner = getCandidates().get(winnerIndex);
            System.out.println(winner.getName() + " won the election with " + winnerCounts + " votes.");
        }

        return candidateElectionVoteCount;
    }

}