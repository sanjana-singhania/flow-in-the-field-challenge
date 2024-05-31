public class Round {
  Integer roundId;
  Integer sessionId;
  Integer score;
  Long startTime;
  Long endTime;

  public Round(Integer roundId, Integer sessionId, Integer score, Long startTime, Long endTime) {
    this.roundId = roundId;
    this.sessionId = sessionId;
    this.score = score;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public Integer getSessionId() {
    return sessionId;
  }
}
