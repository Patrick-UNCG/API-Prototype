import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class NBA {
    public static void getNBAPlayerInfo(){
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://free-nba.p.rapidapi.com/players/237"))
                    .header("x-rapidapi-key", "9a659d3e09mshdcf0aed9bd9b611p1b6530jsnb0c3a2c174da")
                    .header("x-rapidapi-host", "free-nba.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject obj = new JSONObject(response.body());

            //Parsing the relevant information, including the player's name, position, height, and weight.
            String nba_player = obj.getString("first_name");
            String last_name = obj.getString("last_name");
            String position = obj.getString("position");
            String height_feet = obj.getString("height_feet");
            String height_inches = obj.getString("height_inches");
            String weight = obj.getString("weight_pounds");

            //Printing all the relevant information that was parsed.
            System.out.println("The Greatest Basketball player of all time is : " + nba_player + " "+ last_name);
            System.out.println("Position: "+ position);
            System.out.println("Height: " + height_feet+ " ft " + height_inches + " inches");
            System.out.println("Weight: "+ weight+ " lbs");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
