import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Participant {
  Integer participantId;
  String name;
  Integer age;
  List<Integer> sessions;

  public Participant(Integer participantId, String name, Integer age, List<Integer> sessions) {
    this.participantId = participantId;
    this.name = name;
    this.age = age;
    this.sessions = sessions;
  }

  public Map<Integer, Session> getAllSessions(DataBank data) {
    HashMap<Integer, Session> res = new HashMap<>();
    for (Integer sessionId : sessions) {
      res.put(sessionId, data.getSession(sessionId));
    }
    return res;
  }
}
