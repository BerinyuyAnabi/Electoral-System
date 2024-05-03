import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
*Main class used to run the program
* it creates instances of the District, Region and the election classes
*
*/
public class Main {
  public static void main(String[] args) {

    // create an election
    Election presidentialElection = new Election("PE2024", "Presidential Election");

    // create regions for that election and add it to the election
    Region centralRegion = new Region("001", "Central");
    Region northernRegion = new Region("002", "Northern");
    Region southernRegion = new Region("003", "Southern");

    presidentialElection.addRegion(centralRegion);
    presidentialElection.addRegion(northernRegion);
    presidentialElection.addRegion(southernRegion);

    // create districts for that election and add it to the regions
    District cenDistrict1 = new District("D001", "D");
    District cenDistrict2 = new District("D002", "D1");
    District norDistrict1 = new District("D003", "D3");
    District norDistrict2 = new District("D004", "D4");
    District souDistrict1 = new District("D005", "D5");
    District souDistrict2 = new District("D006", "D6");

    District districts[] = { cenDistrict1, cenDistrict2, norDistrict1, norDistrict2, souDistrict1, souDistrict2 };

    centralRegion.addDistricts(cenDistrict1);
    centralRegion.addDistricts(cenDistrict2);
    northernRegion.addDistricts(norDistrict1);
    northernRegion.addDistricts(norDistrict2);
    southernRegion.addDistricts(souDistrict1);
    southernRegion.addDistricts(souDistrict2);


    // Using a file system to get voter instannces 
    
    try (BufferedReader reader = new BufferedReader(new FileReader("voters.txt"))) {
      String line;

      while ((line = reader.readLine()) != null) {
        String[] voterDetails = line.split(",");
        String name = voterDetails[0];
        int age = Integer.parseInt(voterDetails[1]);
        char gender = voterDetails[2].charAt(0);
        String citizenship = voterDetails[3];
        String voterID = voterDetails[4];
        boolean hasVoted = Boolean.parseBoolean(voterDetails[5]);
        String stationID = voterDetails[6];

        // Creating a Voter object for each record
        Voter voter = new Voter(name, age, gender, citizenship, voterID, hasVoted, stationID);

        // Adding voters to the election
        presidentialElection.addVoter(voter);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // create candidates for the election
    Candidate candidate1 = new Candidate("Nana Addo", 80, 'M', "Ghanaian", "NARTY2376N", "NPP", 0);
    Candidate candidate2 = new Candidate("John Mahama", 76, 'M', "Ghanaian", "JJIMA2675J", "NDC", 1);
    Candidate candidate3 = new Candidate("Akua Donkor", 67, 'F', "Ghanaian", "AKJU279683A", "ADP", 2);
    Candidate candidate4 = new Candidate("Alan Kyeremanteng", 56, 'M', "Ghanaian", "ALKNH237Y3A", "BMP", 3);
    Candidate candidate5 = new Candidate("Kennedy Agyapong", 72, 'M', "Ghanaian", "KAIJD869997K", "NPP", 4);

    /**
     * Adding candidates to the election
     */
    presidentialElection.addCandidate(candidate1);
    presidentialElection.addCandidate(candidate2);
    presidentialElection.addCandidate(candidate3);
    presidentialElection.addCandidate(candidate4);
    presidentialElection.addCandidate(candidate5);

    PollingStation pollingStation;

    // Getting the polling from a file 
    try (BufferedReader reader = new BufferedReader(new FileReader("pollingStations.txt"))) {
      String line;

      while ((line = reader.readLine()) != null) {
        String[] stations = line.split(",");
        String stationID = stations[0];
        String districtID = stations[1];
        String stationName = stations[2];
        int candidateSize = Integer.parseInt(stations[3]);

        // Creating a polling station object for each record
        pollingStation = new PollingStation(stationID, districtID, stationName, candidateSize);

        // Adding polling stations to the districts
        for (int i = 0; i < districts.length; i++) {
          if (districts[i].getDistrictId().equals(districtID)) {
            districts[i].addPollingStation(pollingStation);
          }
        }

      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    // User interaction
    while (true) {
      // Display voting menu and allow voters to cast their votes
      Helper.vote(presidentialElection);

      // Displaying candidate counts after each round of voting
      presidentialElection.displayCandidateCountForElection();
    }
  }
}
