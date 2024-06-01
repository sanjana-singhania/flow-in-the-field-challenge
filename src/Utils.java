import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

  public List<LanguageStatistics> createLanguageStatistics(Map<Integer, Round> myRounds,
                                       Map<Integer, Session> mySessions) {
    ArrayList<LanguageStatistics> res = new ArrayList<>();
    HashMap<String, List<Round>> roundsPerLang = new HashMap<>();
    HashMap<String, Integer> totalScorePerLang = new HashMap<>();
    //gets all the rounds associated with a session and adds them to the respective language (of the session)
    for (Session s : mySessions.values()) {
      roundsPerLang.computeIfAbsent(s.getLanguage(),
              k -> new ArrayList<Round>()).addAll(s.getAssociatedRounds((myRounds.values())));
      totalScorePerLang.put(s.getLanguage(),
              totalScorePerLang.getOrDefault(s.getLanguage(), 0)
              + s.getTotalScore(myRounds.values()));
    }

    //creates a new language statistic for each type of language
    for (String language : roundsPerLang.keySet()) {
      res.add(new LanguageStatistics(language, this.getAverageRoundScore(roundsPerLang.get(language)),
              this.getAverageRoundDuration(roundsPerLang.get(language)), totalScorePerLang.get(language)));
    }

    return res;
  }

  public double roundTwoPlaces(Double num) {
    double temp = num * 100;
    temp = Math.round(temp);
    return temp / 100;
  }

  public Double getAverageRoundScore(Collection<Round> rounds) {
    double acc = 0;
    for (Round r : rounds) {
      acc += r.getScore();
    }
    return this.roundTwoPlaces(acc / rounds.size());
  }

  public Double getAverageSessionDuration(Collection<Session> sessions) {
    double acc = 0;
    for (Session s: sessions) {
      acc += s.getDuration();
    }
    return this.roundTwoPlaces(acc / sessions.size());
  }

  public Integer getAverageRoundDuration(Collection<Round> rounds) {
    double acc = 0;
    for (Round r: rounds) {
      acc += r.getDuration();
    }
    return (int) (acc / rounds.size());
  }
}
