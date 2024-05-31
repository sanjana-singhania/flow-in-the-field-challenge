import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParticipantStatistics {
  Integer id;
  String name;
  List<LanguageStatistics> languages;
  Double averageRoundScore;
  Double averageSessionDuration;

  public ParticipantStatistics(Integer id, String name, List<LanguageStatistics> languages,
                               Double averageRoundScore, Double averageSessionDuration) {
    this.id = id;
    this.name = name;
    this.languages = languages;
    this.averageRoundScore = averageRoundScore;
    this.averageSessionDuration = averageSessionDuration;
  }

  public List<LanguageStatistics> createLanguageStatistics(List<Round> myRounds,
                                                           List<Session> mySessions) {
    ArrayList<LanguageStatistics> res = new ArrayList<>();
    HashMap<String, List<Round>> roundsPerLang = new HashMap<>();
    for (Session s : mySessions) {
      roundsPerLang.computeIfAbsent(s.getLanguage(),
              k -> new ArrayList<Round>()).addAll(s.getAssociatedRounds(myRounds));
    }
  }



}
