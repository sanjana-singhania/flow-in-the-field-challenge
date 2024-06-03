import java.util.ArrayList;
import java.util.List;

/**
 * Represents all data from flow in the field on participants, sessions, and rounds played.
 */
public class DataBank {
  private final List<Session> sessions;
  private final List<Round> rounds;
  private final List<Participant> participantInfo;

  /**
   * Constructs a new DataBank object.
   * @param sessions represents a list of all sessions played.
   * @param rounds represents a list of all rounds played.
   * @param participantInfo represents a list of all users/participants of the program.
   */
  public DataBank(List<Session> sessions, List<Round> rounds, List<Participant> participantInfo) {
    this.sessions = sessions;
    this.rounds = rounds;
    this.participantInfo = participantInfo;
  }

  /**
   * Gets the corresponding session to the given sessionId.
   * @param sessionId represents the primary identifier for a session.
   * @return the session matching the given id.
   */
  public Session getSession(int sessionId) {
    for (Session s : sessions) {
      if (s.getSessionId() == sessionId) {
        return s;
      }
    }
    throw new IllegalArgumentException("No session found with id: " + sessionId);
  }

  /**
   * Gets the list of rounds held in this databank.
   * @return a list of all rounds played on flow in the field.
   */
  public List<Round> getRounds() {
    List<Round> res = new ArrayList<>(this.rounds);
    return res;
  }

  /**
   * Gets the list of participants held in this databank.
   * @return a list of all participants who used flow in the field.
   */
  public List<Participant> getParticipantInfo() {
    List<Participant> res = new ArrayList<>(this.participantInfo);
    return res;
  }
}
