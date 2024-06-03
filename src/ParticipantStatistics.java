import java.util.List;

/**
 * Represents a participant's overall statistics in using the flow in the field application.
 */
public class ParticipantStatistics {
  Integer id;
  String name;
  List<LanguageStatistics> languages;
  Object averageRoundScore;
  Object averageSessionDuration;

  /**
   * Constructs a new participant statistic object using a participant and the data from JSON.
   * @param participant represents a participant and is used to
   *                    retrieve a participants personal identification information.
   * @param data represents the data retrieved from GET request of all participants, rounds,
   *             and sessions, and is used to iterate through and find the given
   *             participants languages, average round score, and average session duration.
   */
  public ParticipantStatistics(Participant participant, DataBank data) {
    Utils u = new Utils();
    this.id = participant.getParticipantId();
    this.name = participant.getName();
    this.languages = u.createLanguageStatistics(participant.getAllRounds(data),
            participant.getAllSessions(data));
    this.averageRoundScore = u.getAverageRoundScore(participant.getAllRounds(data).values());
    this.averageSessionDuration = u.getAverageSessionDuration(
            participant.getAllSessions(data).values());
    this.sortLanguageStatistics();
  }

  /**
   * Gets the name of the participant in this participant statistics.
   * @return the name of the participant involved in this statistic.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Sorts the language statistics of this participant statistic
   *     in descending order by total score of each language.
   */
  private void sortLanguageStatistics() {
    this.languages.sort((l1, l2) -> l2.getTotalScore().compareTo(l1.getTotalScore()));
  }

}
