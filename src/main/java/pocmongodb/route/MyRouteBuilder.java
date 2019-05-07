package pocmongodb.route;

import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.model.dataformat.JsonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;

import com.mongodb.util.JSON;

import pocmongodb.processors.*;
import pocmongodb.util.CVRObject;
import pocmongodb.util.TransformationBean;

public class MyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		//JsonDataFormat jsonDataFormat = new JsonDataFormat();
		
		CVRObject c1 = new CVRObject();
		c1.setCvrNumber(1234);
		c1.setTimestamp(1111);
		
		//Set up RESTLET server on LOCALHOST:8080
		restConfiguration().component("restlet")
			.host("localhost").port("8080");
		
		
		
		//POST new CVR DATA
		rest("/api/update/cvr")
			.post()
			.to("mongodb:myDb?database=mongodb&collection=jacob&operation=insert");	
		
		
		
		//GET all CVR DATA
		rest("/api/all/cvr")
			.get()
			.route()
			.setBody(constant(c1))
			.marshal().json(JsonLibrary.Jackson)
			.to("file:C:/Users/jacob.hansen/Documents/Test/testoutput");
		
		
		
		// Standard route from folder to folder
		from("file:C:/Users/X008235/Desktop/CamelTestfolder/inputFolder")
			.process(new MyLogProcessor())
			.bean(new TransformationBean(), "makeUpperCase")
			.process(new MyLogProcessor())
			.to("file:C:/Users/X008235/Desktop/CamelTestfolder/outputFolder");
		
	}
	
}
