import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class that holds useful methods to operate upon objects.
 */
public class Utils {

  /**
   * Creates a list of language statistics through given input of rounds and sessions belonging
   * to a participant. Assumes that the sessions and rounds given as input both belong to a single participant.
   * @param myRounds represents a list of the total rounds that a certain participant has completed.
   * @param mySessions represents a list of the total sessions that a certain participant has completed.
   * @return a new list of language statistics.
   */
  public List<LanguageStatistics> createLanguageStatistics(Map<Integer, Round> myRounds,
                                       Map<Integer, Session> mySessions) {
    ArrayList<LanguageStatistics> res = new ArrayList<>();

    HashMap<String, List<Round>> roundsPerLang = new HashMap<>();
    HashMap<String, Integer> totalScorePerLang = new HashMap<>();
    //gets all the rounds associated with a session and adds them to the respective language (of the session)
    for (Session s : mySessions.values()) {
      //language : list of <session>
      roundsPerLang.computeIfAbsent(s.getLanguage(),
              k -> new ArrayList<Round>()).addAll(s.getAssociatedRounds((myRounds.values())));
      //language : sum of all session scores (totalScore)
      totalScorePerLang.put(s.getLanguage(),
              totalScorePerLang.getOrDefault(s.getLanguage(), 0)
              + s.getTotalScore(myRounds.values()));
    }

    //creates a new language statistic for each type of language
    for (String language : roundsPerLang.keySet()) {
      res.add(new LanguageStatistics(language,
              (Double) this.getAverageRoundScore(roundsPerLang.get(language)),
              this.getAverageRoundDuration(roundsPerLang.get(language)),
              totalScorePerLang.get(language)));
    }
    return res;
  }

  /**
   * Rounds the given double to two decimal places.
   * @param num the number to be rounded.
   * @return the given number rounded to two decimal places.
   */
  public double roundTwoPlaces(Double num) {
    double temp = num * 100;
    temp = Math.round(temp);
    return temp / 100;
  }

  /**
   * Gets the average round score for a given list of rounds.
   *     For an empty list of rounds, returns "N/A".
   * @param rounds represents a list of rounds to evaluate.
   * @return the average of the scores for a list of rounds, or "N/A", if the list is empty.
   */
  public Object getAverageRoundScore(Collection<Round> rounds) {
    if (rounds.isEmpty()) {
      return "N/A";
    }
    double acc = 0;
    for (Round r : rounds) {
      acc += r.getScore();
    }
    return this.roundTwoPlaces(acc / rounds.size());
  }

  /**
   * Gets the average duration for a list of sessions.
   * @param sessions the list of sessions to be evaluated.
   * @return "N/A" if the given list of sessions is empty, else the average duration of the
   *     sessions, rounded to two decimal places.
   */
  public Object getAverageSessionDuration(Collection<Session> sessions) {
    if (sessions.isEmpty()) {
      return "N/A";
    }
    double acc = 0;
    for (Session s: sessions) {
      acc += s.getDuration();
    }
    return this.roundTwoPlaces(acc / sessions.size());
  }

  /**
   * Gets the average duration for a list of rounds.
   * @param rounds the list of rounds to be evaluated.
   * @return the average duration of the list of rounds, rounded to two decimal places.
   */
  public Double getAverageRoundDuration(Collection<Round> rounds) {
    double acc = 0;
    for (Round r : rounds) {
      acc += r.getDuration();
    }
    return this.roundTwoPlaces(acc / rounds.size());
  }

  /**
   * Sorts the given list of participant statistics alphabetically by name, and returns it.
   * @param stats the list of participant statistics to be sorted.
   * @return a sorted by name list of participant statistics.
   */
  public List<ParticipantStatistics> sortByName(List<ParticipantStatistics> stats) {
    List<ParticipantStatistics> res = new ArrayList<>(stats);
    res.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    return res;
  }
}
