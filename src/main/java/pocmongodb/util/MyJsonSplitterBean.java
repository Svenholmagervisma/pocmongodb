package pocmongodb.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class MyJsonSplitterBean {

	    public List<String> splitBody(String body) {
	    	List<String> answer = new ArrayList<String>();
	    	JSONArray jsonArray = new JSONArray(body);
			for(int i=0; i<jsonArray.length(); i++) {
			    JSONObject jsonObject = jsonArray.getJSONObject(i);
			    String jsonObjectAsString = jsonObject.toString();
			    answer.add(jsonObjectAsString);
			}
			System.out.println(answer);
	        return answer;
	    }
}