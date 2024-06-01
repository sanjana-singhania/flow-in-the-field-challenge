import java.util.List;

public class ParticipantStatistics {
  Integer id;
  String name;
  List<LanguageStatistics> languages;
  Double averageRoundScore;
  Double averageSessionDuration;

  public ParticipantStatistics(Participant participant, DataBank data) {
    Utils u = new Utils();
    this.id = participant.getParticipantId();
    this.name = participant.getName();
    this.languages = u.createLanguageStatistics(participant.getAllRounds(data),
            participant.getAllSessions(data));
    this.averageRoundScore = u.getAverageRoundScore(participant.getAllRounds(data).values());
    this.averageSessionDuration = u.getAverageSessionDuration(
            participant.getAllSessions(data).values());
  }

  public String getName() {
    return this.name;
  }


}
