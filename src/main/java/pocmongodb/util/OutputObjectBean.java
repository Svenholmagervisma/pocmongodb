package pocmongodb.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class OutputObjectBean {

	public List<String> CVRUnpackData(String body) {
		ArrayList<String> result = new ArrayList<String>();
		JSONArray jsonArray = new JSONArray(body);
		for(int i=0; i<jsonArray.length(); i++) {
		    JSONObject jsonObject = jsonArray.getJSONObject(i);
		    String dataObject = jsonObject.getJSONObject("data").toString();
		    result.add(dataObject);
		}		
		
		return result;
	}
}
