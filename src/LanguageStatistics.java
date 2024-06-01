public class LanguageStatistics {
  String language;
  Double averageScore;
  Integer averageRoundDuration;
  transient Integer totalScore;

  public LanguageStatistics(String language, Double averageScore, Integer averageRoundDuration, Integer totalScore) {
    this.language = language;
    this.averageScore = averageScore;
    this.averageRoundDuration = averageRoundDuration;
    this.totalScore = totalScore;
  }


}
