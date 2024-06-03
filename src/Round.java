/**
 * Represents a round played by a participant in flow in the field.
 */
public class Round {
  Integer roundId;
  Integer sessionId;
  Integer score;
  Long startTime;
  Long endTime;

  /**
   * Constructs a round object.
   * @param roundId represents the identification number and primary key of a round.
   * @param sessionId represents of the id of the session this round is associated with.
   * @param score represents the score of this round.
   * @param startTime represents the start time of this round.
   * @param endTime represents the end time of this round.
   */
  public Round(Integer roundId, Integer sessionId, Integer score, Long startTime, Long endTime) {
    this.roundId = roundId;
    this.sessionId = sessionId;
    this.score = score;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * Gets the id of this round.
   * @return the id of this round.
   */
  public Integer getRoundId() {
    return this.roundId;
  }

  /**
   * Gets the session id of this round.
   * @return the session id of this round.
   */
  public Integer getSessionId() {
    return this.sessionId;
  }

  /**
   * Gets the score of this round.
   * @return the score of this round.
   */
  public Integer getScore() {
    return score;
  }

  /**
   * Gets the duration of this round.
   * @return the duration of this round.
   */
  public Long getDuration() {
    return endTime - startTime;
  }
}
