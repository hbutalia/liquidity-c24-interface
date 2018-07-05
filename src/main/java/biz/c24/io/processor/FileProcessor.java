package biz.c24.io.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class FileProcessor implements Processor {
	private static final Logger LOGGER =   LoggerFactory.getLogger(FileProcessor.class);

    public void process(Exchange exchange) throws Exception {
    	 LOGGER.info("$$$$$$$$$$$$$$$ FileProcessor....");
    
        String originalFileContent = exchange.getIn().getBody(String.class);
        String upperCaseFileContent = originalFileContent.toUpperCase();
        LOGGER.info("$$$$$$$$$$$$$$$ FileProcessor upperCaseFileContent "+upperCaseFileContent);
        exchange.getIn().setBody(upperCaseFileContent);
    }

}
