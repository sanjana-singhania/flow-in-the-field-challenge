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
}
