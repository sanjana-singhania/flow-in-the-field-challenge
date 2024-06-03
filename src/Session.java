import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Represents a session in flow in the field application. A session consists of rounds
 *     played by a participant, which can range from one to many.
 */
public class Session {
  private final Integer participantId;
  private final Integer sessionId;
  private final String language;
  private final List<Integer> rounds;
  private final Long startTime;
  private final Long endTime;

  /**
   * Constructs a session object.
   * @param participantId represents the corresponding participant's id.
   * @param sessionId represents this sessions primary key, its unique identification number.
   * @param language represents the language practiced in this session.
   * @param rounds represents the id numbers of all the rounds contained in this session.
   * @param startTime represents the start time of this session.
   * @param endTime represents the end time of this session.
   */
  public Session(Integer participantId, Integer sessionId, String language,
                 List<Integer> rounds, Long startTime, Long endTime) {
    this.participantId = participantId;
    this.sessionId = sessionId;
    this.language = language;
    this.rounds = rounds;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * Gets the session id of this session.
   * @return the session id of this session.
   */
  public Integer getSessionId() {
    return sessionId;
  }

  /**
   * Gets the language of this session.
   * @return the language of this session.
   */
  public String getLanguage() {
    return language;
  }

  /**
   * Gets the rounds associated with this session by matching round id to rounds, given a list of rounds.
   * @param allRounds represents a list of all the rounds played from the databank.
   * @return a list of all the rounds associated with this session.
   */
  public List<Round> getAssociatedRounds(Collection<Round> allRounds) {
    ArrayList<Round> res = new ArrayList<>();
    for (Round r : allRounds) {
      if (r.getSessionId().equals(this.getSessionId()) && this.rounds.contains(r.getRoundId())) {
        res.add(r);
      }
    }
    return res;
  }

  /**
   * Gets the total score of this session by adding the score of all the rounds.
   * @param allRounds represents a list of all rounds played from the databank.
   * @return the total score of all of the rounds associated with this session.
   */
  public Integer getTotalScore(Collection<Round> allRounds) {
    int res = 0;
    for (Round r : this.getAssociatedRounds(allRounds)) {
      res += r.getScore();
    }
    return res;
  }

  /**
   * Gets the duration of this session.
   * @return the duration of this session.
   */
  public Long getDuration() {
    return endTime - startTime;
  }

}
