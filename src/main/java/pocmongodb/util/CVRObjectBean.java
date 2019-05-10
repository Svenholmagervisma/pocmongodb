package pocmongodb.util;

import java.time.Instant;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CVRObjectBean {

	public String CVRDataToObject(String body) throws JsonProcessingException {
		//System.out.println("body1: " + body);
		JSONObject json = new JSONObject(body);
		int cvr = json.getInt("CVR");

		CVRObject newObj = new CVRObject();		
		newObj.set_id(cvr);
		newObj.setTimestamp(Instant.now().getEpochSecond());
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(newObj);	
		
		String newString = jsonInString.replace(jsonInString.substring(jsonInString.length() - 1), ",\"data\":"+ body + "}");
		System.out.println("parsedresult out: " + newString );
		
		return newString;
	}
}
