package pocmongodb;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonDataFormat;

import Processors.*;

public class MyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		JsonDataFormat jsonDataFormat = new JsonDataFormat();
		
		CVRObject c1 = new CVRObject();
		c1.setCvrNumber(1234);
		c1.setTimestamp(1111);
		
		//Set up RESTLET server on LOCALHOST:8080
		restConfiguration().component("restlet")
			.host("localhost").port("8080");
		
		
		
		//POST new CVR DATA
		rest("/api/update/cvr")
			.post()
			.to("file:C:/Users/X008235/Desktop/CamelTestfolder/outputFolder");	
		
		
		
		//GET all CVR DATA
		rest("/api/all/cvr")
			.get()
			.route()
			//.setBody(constant("21131231, 123123123, 12314511"))
			.setBody(jsonDataFormat(c1))
			.to("file:C:/Users/X008235/Desktop/CamelTestfolder/outputFolder");
		
		
		
		// Standard route from folder to folder
		from("file:C:/Users/X008235/Desktop/CamelTestfolder/inputFolder")
			.process(new MyLogProcessor())
			.bean(new TransformationBean(), "makeUpperCase")
			.process(new MyLogProcessor())
			.to("file:C:/Users/X008235/Desktop/CamelTestfolder/outputFolder");
		
	}
	
}
