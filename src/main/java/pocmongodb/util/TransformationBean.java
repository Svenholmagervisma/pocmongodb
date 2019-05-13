package pocmongodb.util;

import java.time.Instant;
import java.util.ArrayList;

import org.json.JSONObject;
import org.json.JSONArray;

public class TransformationBean {
	
	/*
	 * public String makeUpperCase(String body) { String transformedBody =
	 * body.toUpperCase(); return transformedBody;
	 * 
	 * }
	 * 
	 * public String addTimestamp(String body) { ArrayList<String> arrResult = new
	 * ArrayList<String>(); String changedCVRBody = body.replace("CVR", "_id");
	 * String[] splitString = changedCVRBody.split("}"); //TODO: Refactor me please.
	 * if(splitString.length >= 3) { for (int i = 0; i < splitString.length - 1;
	 * i++) { arrResult.add(splitString[i] + ", \"Timestamp\" : \"" +
	 * Instant.now().getEpochSecond() + "\"}"); } arrResult.add("]"); }else { for
	 * (String s : splitString) { arrResult.add(s + ", \"Timestamp\" : \"" +
	 * Instant.now().getEpochSecond() + "\"}"); } }
	 * 
	 * return String.join("", arrResult); }
	 */
}
