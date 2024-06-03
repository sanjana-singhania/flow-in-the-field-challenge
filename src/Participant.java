import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the details of a user/participant of the application, flow in the field.
 */
public class Participant {
  private final Integer participantId;
  private final String name;
  private final Integer age;
  private final List<Integer> sessions;

  /**
   * Constructs a new participant object.
   * @param participantId represents the unique identification number of a participant.
   * @param name represents the name of a participant.
   * @param age represents the age of a participant.
   * @param sessions represents a list of the ids of the sessions a participant has completed.
   */
  public Participant(Integer participantId, String name, Integer age, List<Integer> sessions) {
    this.participantId = participantId;
    this.name = name;
    this.age = age;
    this.sessions = sessions;
  }

  /**
   * Gets this participants id.
   * @return the id of this participant.
   */
  public Integer getParticipantId() {
    return participantId;
  }

  /**
   * Gets the name of this participant.
   * @return the name of this participant.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets all the sessions corresponding to this participant,
   *     given a databank containing all sessions.
   * @param data represents a databank that contains all sessions, rounds, and participants.
   * @return a hashmap of session id to corresponding session.
   */
  public Map<Integer, Session> getAllSessions(DataBank data) {
    HashMap<Integer, Session> res = new HashMap<>();
    for (Integer sessionId : sessions) {
      res.put(sessionId, data.getSession(sessionId));
    }
    return res;
  }

  /**
   * Gets all the rounds associated with this participant.
   * @param data databank consisting of all participants, sessions, and rounds.
   * @return a mapping consisting of roundId to its round for all the rounds that this user
   *      participated in.
   */
  public Map<Integer, Round> getAllRounds(DataBank data) {
    HashMap<Integer, Round> res = new HashMap<>();
    //goes through every session of this user
    // and adds the associated rounds with every session to the map
    for (Session s : this.getAllSessions(data).values()) {
      for (Round r : s.getAssociatedRounds(data.getRounds())) {
        res.put(r.getRoundId(), r);
      }
    }
    return res;
  }


}
