import com.google.gson.Gson;

import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the main program that makes calls to the API to fetch and manipulate data before returning it.
 */
public class RestAPI {
  //the unique URL
  private static final String uniqueURL = "https://challenge.sandboxnu.com/s/PMRGIYLUMERDU6ZCMVWWC2LMEI5CE43JNZTWQYLONFQS443BIBXG64TUNBSWC43UMVZG4LTFMR2SELBCMR2WKIR2GE3TCNZZHEYTSOJZFQRGG2DBNRWGK3THMURDUISGNRXXOIT5FQRGQYLTNARDUITLKRCEQ6KWMRXFG43ZKFWXE5RZIZHGWPJCPU======";

  //main program that executes GET and POST requests.
  public static void main(String[] args) throws Exception {
    Utils u = new Utils();

    //get request
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest getRequest = HttpRequest.newBuilder().GET()
            .header("accept", "application/json").uri(URI.create(uniqueURL)).build();
    HttpResponse<String> response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
    Reader reader = new StringReader(response.body());
    Gson gson = new Gson();
    DataBank data = gson.fromJson(reader, DataBank.class); //saves response in a DataBank object

    //post request
    List<ParticipantStatistics> allParticipantStatistics = new ArrayList<>();
    for (Participant p : data.getParticipantInfo()) {
      allParticipantStatistics.add(new ParticipantStatistics(p, data));
    }
    String res = gson.toJson(u.sortByName(allParticipantStatistics));

    HttpRequest postRequest = HttpRequest.newBuilder().uri(URI.create(uniqueURL))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(res)).build();

    HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
    System.out.println(postResponse.body()); //response message
  }
}
