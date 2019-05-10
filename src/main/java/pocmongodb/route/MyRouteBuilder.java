package pocmongodb.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import pocmongodb.processors.MyLogProcessor;
import pocmongodb.util.*;

public class MyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
	
		
		//Set up RESTLET server on LOCALHOST:8080
		restConfiguration().component("restlet")
			.host("localhost").port("8080");
		
		
		
		//POST new CVR DATA
		rest("/api/update/cvr")
			.post()
			.route()
			.bean(new TransformationBean(), "addTimestamp")
			.unmarshal().json(JsonLibrary.Jackson)
			.to("log:mitpunkt1?showAll=true")
			.to("mongodb:myDb?database=POCDB&collection=company&operation=insert");
		
		
		//Test 
		rest("/api/update/cvr/test")
			.post()
			.route()
			.to("log:mitpunkt2?showAll=true")
			.bean(new TransformationBean(), "addTimestamp")
			.unmarshal().json(JsonLibrary.Jackson)
			.to("mongodb:myDb?database=POCDB&collection=company&operation=save");
		
		
		//Test 2 
		rest("/api/update/cvr/test2")
			.post()
			.route()
			.to("log:mitpunkt5?showAll=true")
			.split().method("MyJsonSplitterBean", "splitBody")
			.to("log:mitpunkt5?showAll=true")
			.process(new MyLogProcessor())
			.to("mongodb:myDb?database=POCDB&collection=company&operation=save");

	
		
		//GET all CVR DATA
		rest("/api/all/cvr")
			.get()
			.route()
			.marshal().json(JsonLibrary.Jackson)
			.to("log:mitpunkt3?showAll=true")
			.to("mongodb:myDb?database=POCDB&collection=company&operation=findAll");
		
		
		
		// Standard route from folder to folder
		from("file:C:/Users/X008235/Desktop/CamelTestfolder/inputFolder")
			.bean(new TransformationBean(), "makeUpperCase")
			.to("log:mitpunk4?showAll=true")
			.to("file:C:/Users/X008235/Desktop/CamelTestfolder/outputFolder");
		
	}
	
}
