package pocmongodb.util;

import java.time.Instant;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CVRObjectBean {

	public String CVRDataToObject(String body) throws JsonProcessingException {
		JSONObject json = new JSONObject(body);
		int cvr = json.getInt("CVR");

		CVRObject newObj = new CVRObject();
		
		newObj.set_id(cvr);
		newObj.setData(body);		
		newObj.setTimestamp(Instant.now().getEpochSecond());
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(newObj);
		System.out.println("jsonstring out: " + jsonInString );
		
		return jsonInString;
	}
}
