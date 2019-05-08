package pocmongodb.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class TransformationBean {
	
	public String makeUpperCase(String body) {
		String transformedBody = body.toUpperCase();
		return transformedBody;
	
	}
	
	public String addTimestamp(String body) {
		String[] splitString = body.split("}",0);
		ArrayList<String> arrResult = new ArrayList<String>();
		for (String s : splitString) {
			arrResult.add(s + ", \"Timestamp\" : \"" + LocalDateTime.now().toString() + "\"}");
		}
		return String.join(",", arrResult);
	}
}
