import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonExtractor {
  public static List<String> extractValues(String filePath) throws IOException {
    String content = new String(Files.readAllBytes(Paths.get(filePath)));
    JSONArray jsonArray = new JSONArray(content);
    List<String> values = new ArrayList<>();

    for (int i = 0; i < jsonArray.length(); i++) {
      JSONObject jsonObject = jsonArray.getJSONObject(i);
      JSONArray stringListData = jsonObject.getJSONArray("string_list_data");

      for (int j = 0; j < stringListData.length(); j++) {
        JSONObject stringData = stringListData.getJSONObject(j);
        values.add(stringData.getString("value"));
      }
    }

    return values;
  }

  public static List<String> extractFollowingValues(String filePath) throws IOException {
    String content = new String(Files.readAllBytes(Paths.get(filePath)));
    JSONObject jsonObject = new JSONObject(content);
    JSONArray relationshipsFollowing = jsonObject.getJSONArray("relationships_following");
    List<String> values = new ArrayList<>();

    for (int i = 0; i < relationshipsFollowing.length(); i++) {
      JSONObject relationship = relationshipsFollowing.getJSONObject(i);
      JSONArray stringListData = relationship.getJSONArray("string_list_data");

      for (int j = 0; j < stringListData.length(); j++) {
        JSONObject stringData = stringListData.getJSONObject(j);
        values.add(stringData.getString("value"));
      }
    }

    return values;
  }
}
