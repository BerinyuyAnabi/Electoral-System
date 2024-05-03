import java.util.ArrayList;
import java.util.Scanner;

/**
 * Helper class
 * Operations include the constructor, accessor, mutator methods, getVoterByID,
 * getPollingStation,
 * hasVoted, and increaseCandidateVoteCount methods.
 *
 * @authors Vanessa, Eric, Elizabeth, Rahinatu
 * 
 */

public class Helper {

  public static void vote(Election election) {
    Scanner input = new Scanner(System.in);

    System.out.println("Welcome to the voting application. Your vote counts!");
    System.out.println("Kindly enter your voter ID to vote: ");
    String idOfVoter = input.nextLine();

    /**
     * Get the registered voters by their voter ID numbers
     * 
     * @param idOfVoter represents the ID number of the voters
     *
     */
    Voter voter = election.getVoterByID(idOfVoter);
    if (voter == null) {
      System.out.println("Voter ID " + idOfVoter + " is invalid.");
      return;
    }

    /**
     *
     * Get the voter's polling station
     * 
     * @param election represents the instance of the election class
     * @param voter    represents the voter object
     */
    PollingStation voterStation = getPollingStation(election, voter);
    if (voterStation == null) {
      System.out.println("The voter's Station ID " + voter.getStationID() + " is not registered for this election.");
      return;
    }

    /*
     *
     *
     * check if the voter has already voted
     * 
     * @param idOfvoter represents the ID number of the voter
     */
    if (voterStation.hasVoted(idOfVoter)) {
      System.out.println("Voter with ID " + idOfVoter + " has already voted. Be a responsible citizen.");
      return;
    }

    // print eligible candidates
    ArrayList<Candidate> candidates = election.getCandidates();
    System.out.println("Below are the eligible candidates for the elections: ");
    for (int index = 0; index < candidates.size(); index++) {
      System.out.println((index + 1) + ". " + candidates.get(index).getName() + " - " +
          candidates.get(index).getPoliticalParty());
    }

    System.out.println();
    System.out.println("Please cast your vote by entering the number of your preferred candidate: ");
    int vote = input.nextInt();
    input.nextLine(); // consume newline

    // ensure vote is within range
    while (!(vote >= 1 && vote <= candidates.size())) {
      System.out.println("Invalid number. Enter a valid candidate number!");
      System.out.println("Please cast your vote by entering the number of your preferred candidate: ");
      vote = input.nextInt();
      input.nextLine(); // consume newline
    }

    // get the candidate being voted for
    Candidate votedCandidate = candidates.get(vote - 1);

    // increment the vote count for the candidate
    voterStation.increaseCandidateVoteCount(vote - 1);
    int candidateVoteCount = voterStation.getCandidateVoteCount(vote - 1);

    System.out.println("You have successfully voted. " + votedCandidate.getName() + " now has " + candidateVoteCount
        + " votes for the " + votedCandidate.getPoliticalParty() + ".");
    System.out.println();

    // marking the voter as voted
    voterStation.markAsVoted(idOfVoter);

    // printing the vote count of candidates
    voterStation.displayCandidateStationCount(election);

  }

  /**
   * getPollingStation method
   * 
   * @param election represents the instance of the election class
   * @param voter    represents the voter object
   * 
   */
  public static PollingStation getPollingStation(Election election, Voter voter) {
    // iterate through every region
    for (Region region : election.getRegions()) {
      // iterate through every district
      for (District district : region.getDistricts()) {
        // iterate through every polling station
        for (PollingStation pollingStation : district.getPollingStations()) {
          if (pollingStation.getStationID().equalsIgnoreCase(voter.getStationID())) {
            return pollingStation;
          }
        }
      }
    }

    return null;
  }
}
