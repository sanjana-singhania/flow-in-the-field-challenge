import com.google.gson.Gson;

import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestAPI {

  private static final String uniqueURL = "https://challenge.sandboxnu.com/s/PMRGIYLUMERDU6ZCMVWWC2LMEI5CE43JNZTWQYLONFQS443BIBXG64TUNBSWC43UMVZG4LTFMR2SELBCMR2WKIR2GE3TCNZZHEYTSOJZFQRGG2DBNRWGK3THMURDUISGNRXXOIT5FQRGQYLTNARDUITLKRCEQ6KWMRXFG43ZKFWXE5RZIZHGWPJCPU======";

  public static void main(String[] args) throws Exception {

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest getRequest = HttpRequest.newBuilder().GET()
            .header("accept", "application/json").uri(URI.create(uniqueURL)).build();
    HttpResponse<String> response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());

    Reader reader = new StringReader(response.body());
    System.out.println(response.body());
    Gson gson = new Gson();
    DataBank data = gson.fromJson(reader, DataBank.class);

    ParticipantStatistics test = new ParticipantStatistics(data.getParticipantInfo().get(0), data);

    String res = gson.toJson(test);
    //System.out.println(res);


    HttpRequest postRequest = HttpRequest.newBuilder().uri(URI.create(uniqueURL))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(res)).build();

  }
}
