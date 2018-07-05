package biz.c24.io.route;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContentBasedRouter extends RouteBuilder {
	private static final Logger LOGGER = LoggerFactory.getLogger(ContentBasedRouter.class);

	private static final String SOURCE_FOLDER = "src/test/source-folder";
	private static final String DESTINATION_FOLDER_TXT = "src/test/destination-folder-txt";
	private static final String DESTINATION_FOLDER_OTHER = "src/test/destination-folder-other";

	@Override
	public void configure() throws Exception {
		LOGGER.info("Processing... ContentBasedFileRouter configure");
		from("file://" + SOURCE_FOLDER + "?delete=false").choice().when(simple("${file:ext} == 'txt'"))
				.to("file://" + DESTINATION_FOLDER_TXT).otherwise().to("file://" + DESTINATION_FOLDER_OTHER);
	}

}
