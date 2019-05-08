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
		ArrayList<String> arrResult = new ArrayList<String>();
		String[] splitString = body.split("}");
		//TODO: Refactor me please.
		if(splitString.length > 2) {
			for (int i = 0; i < splitString.length - 1; i++) {
				arrResult.add(splitString[i] + ", \"Timestamp\" : \"" + LocalDateTime.now() + "\"}");
			}
			arrResult.add("]");
		}else {
			for (String s : splitString) {
				arrResult.add(s + ", \"Timestamp\" : \"" + LocalDateTime.now() + "\"}");
			}
		}
		
		return String.join("", arrResult);
	}
}
