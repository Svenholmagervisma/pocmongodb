package pocmongodb.util;

import java.util.ArrayList;
import java.util.List;

public class MyJsonSplitterBean {

	    public List<String> splitBody(String body) {
	    	System.out.println("body: " + body);
	        List<String> answer = new ArrayList<String>();
	        String[] parts = body.split(",");
	        for (String part : parts) {
	            answer.add(part);
	            
	        }
	        System.out.println("splitBodypart: " + answer);
	        return answer;
	    }
}