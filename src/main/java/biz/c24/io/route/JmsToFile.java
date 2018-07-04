package biz.c24.io.route;

import org.apache.camel.builder.RouteBuilder;

public class JmsToFile extends RouteBuilder {

	public void configure() {
		// Set up the route — from the input JMS broker, to
		// the output directory, via a log operation
		// Note that we're specifying the log class as JMSToFile, and
		// the log level as DEBUG. We will use these parameters in
		// the log configuration file log4j.properties to control
		// logging from the program.
		// Note also that the specific destination we consume from is
		// test_queue. To exercise this program, we must place messages
		// in that destination using a JMS client
		from("activemq:foo").to("log:JmsToFile?level=DEBUG").to("file://tmp/out");
	}

}