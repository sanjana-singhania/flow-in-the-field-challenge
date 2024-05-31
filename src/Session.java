import java.util.ArrayList;
import java.util.List;

public class Session {
  private final Integer participantId;
  private final Integer sessionId;
  private final String language;
  private final List<Integer> rounds;
  private final Long startTime;
  private final Long endTime;

  public Session(Integer participantId, Integer sessionId, String language,
                 List<Integer> rounds, Long startTime, Long endTime) {
    this.participantId = participantId;
    this.sessionId = sessionId;
    this.language = language;
    this.rounds = rounds;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public Integer getSessionId() {
    return sessionId;
  }

  public String getLanguage() {
    return language;
  }

  public List<Round> getAssociatedRounds(List<Round> allRounds) {
    ArrayList<Round> res = new ArrayList<>();
    for (Round r : allRounds) {
      if (r.getSessionId().equals(this.getSessionId())) {
        res.add(r);
      }
    }
    return res;
  }
}