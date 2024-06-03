/**
 * Represents the statistics of a participant associated with a specific language.
 */
public class LanguageStatistics {
  String language;
  Double averageScore;
  Double averageRoundDuration;
  transient Integer totalScore;

  /**
   * Constructs a new language statistics object.
   * @param language represents the language that these statistics correspond to.
   * @param averageScore represents the average score per round played of this language.
   * @param averageRoundDuration represents the average duration of each round played for this language.
   * @param totalScore represents the total score of all the rounds played corresponding to this language.
   */
  public LanguageStatistics(String language, Double averageScore, Double averageRoundDuration, Integer totalScore) {
    this.language = language;
    this.averageScore = averageScore;
    this.averageRoundDuration = averageRoundDuration;
    this.totalScore = totalScore;
  }

  /**
   * Gets the total score for this language statistic.
   * @return the total score of this language statistic, of all the rounds played.
   */
  public Integer getTotalScore() {
    return totalScore;
  }
}
