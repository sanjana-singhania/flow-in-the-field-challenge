import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Participant {
  private final Integer participantId;
  private final String name;
  private final Integer age;
  private final List<Integer> sessions;

  public Participant(Integer participantId, String name, Integer age, List<Integer> sessions) {
    this.participantId = participantId;
    this.name = name;
    this.age = age;
    this.sessions = sessions;
  }

  public Integer getParticipantId() {
    return participantId;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public List<Integer> getSessions() {
    return sessions;
  }

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
