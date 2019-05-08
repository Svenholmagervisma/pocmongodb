package pocmongodb.route;

import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.model.dataformat.JsonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;

import com.mongodb.DBObject;
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
			.route()
			.bean(new TransformationBean(), "addTimestamp")
			.unmarshal().json(JsonLibrary.Jackson)
			.to("mongodb:myDb?database=POCDB&collection=company&operation=insert");
		
		//Test 
		rest("/api/update/cvr/test")
		.post()
		.route()
		.process(new MyLogProcessor())
		.bean(new TransformationBean(), "addTimestamp")
		.process(new MyLogProcessor())
		.unmarshal().json(JsonLibrary.Jackson)
		.to("mongodb:myDb?database=POCDB&collection=company&operation=insert");	
		
		//GET all CVR DATA
		rest("/api/all/cvr")
			.get()
			.route()
			.marshal().json(JsonLibrary.Jackson)
			.to("mongodb:myDb?database=POCDB&collection=company&operation=findAll");
		
		
		
		// Standard route from folder to folder
		from("file:C:/Users/X008235/Desktop/CamelTestfolder/inputFolder")
			.process(new MyLogProcessor())
			.bean(new TransformationBean(), "makeUpperCase")
			.process(new MyLogProcessor())
			.to("file:C:/Users/X008235/Desktop/CamelTestfolder/outputFolder");
		
	}
	
}
