package biz.c24.io.route;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileRouter extends RouteBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileRouter.class);

	private static final String SOURCE_FOLDER = "src/test/source-folder";
	private static final String DESTINATION_FOLDER = "src/test/destination-folder";

	@Override
	public void configure() throws Exception {
		LOGGER.info("Processing... FileRouter configure");

		from("file://" + SOURCE_FOLDER + "?delete=false").process(new FileNameProcessor())
				.to("file://" + DESTINATION_FOLDER);
	}

}
