import java.util.ArrayList;
import java.util.List;

public class DataBank {
  private final List<Session> sessions;
  private final List<Round> rounds;
  private final List<Participant> participantInfo;

  public DataBank(List<Session> sessions, List<Round> rounds, List<Participant> participantInfo) {
    this.sessions = sessions;
    this.rounds = rounds;
    this.participantInfo = participantInfo;
  }

  public Session getSession(int sessionId) {
    for (Session s : sessions) {
      if (s.getSessionId() == sessionId) {
        return s;
      }
    }
    throw new IllegalArgumentException("No session found with id: " + sessionId);
  }

  public List<Session> getSessions() {
    List<Session> res = new ArrayList<>(this.sessions);
    return res;
  }

  public List<Round> getRounds() {
    List<Round> res = new ArrayList<>(this.rounds);
    return res;
  }

  public List<Participant> getParticipantInfo() {
    List<Participant> res = new ArrayList<>(this.participantInfo);
    return res;
  }
}
