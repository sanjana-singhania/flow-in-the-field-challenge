import java.util.List;

/**
 * Wrapper class around a list of participant statistics. Used for parsing into JSON.
 */
public class ListOfParticipantStatistics {
  List<ParticipantStatistics> stats;

  public ListOfParticipantStatistics(List<ParticipantStatistics> stats) {
    this.stats = stats;
  }

  public void sortByName() {
    for (ParticipantStatistics p : this.stats) {
      this.stats.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
    }
  }
}
