package biz.c24.io.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class PreProcessor implements Processor{
	 public void process(Exchange exchange) throws Exception {
		//call DB
		 exchange.getIn().setBody(" Processed Intellect.");
	}
}
