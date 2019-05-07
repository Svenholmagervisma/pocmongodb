package pocmongodb.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor implements Processor {

		public void process(Exchange exchange) throws Exception {
			String body = exchange.getIn().getBody(String.class);
	
			System.out.println("MyProcessor started processing: " + body);
			
			body = body.toUpperCase();
			exchange.getIn().setBody(body);
			
			System.out.println("MyProcessor result: " + body);	
		}
	
}
