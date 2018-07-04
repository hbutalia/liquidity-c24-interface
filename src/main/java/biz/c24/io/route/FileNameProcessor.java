package biz.c24.io.route;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileNameProcessor implements Processor {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileNameProcessor.class);

	public void process(Exchange exchange) throws Exception {
		
		String originalFileName = (String) exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String changedFileName = dateFormat.format(date) + originalFileName;
		LOGGER.info("Processing... FileNameProcessor changedFileName");
		exchange.getIn().setHeader(Exchange.FILE_NAME, changedFileName);
	}

}
