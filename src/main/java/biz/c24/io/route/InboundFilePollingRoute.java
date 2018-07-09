package biz.c24.io.route;

import static biz.c24.io.camel.c24io.CamelC24IO.c24io;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import biz.c24.io.gettingstarted.purchaseorder.Purchase_orderElement;

public class InboundFilePollingRoute extends RouteBuilder {
	private static final Logger LOGGER = LoggerFactory.getLogger(InboundFilePollingRoute.class);

	@Override
	public void configure() throws Exception {

		onException(Exception.class).maximumRedeliveries(1).handled(false);
		LOGGER.info("@@@@@@@ Processing... InboundFilePollingRoute configure");

		// from("file://{{inbound.read.path}}?idempotent=true&delay={{inbound.file.poller.fixed.delay}}&move={{inbound.processed.path}}&moveFailed={{inbound.failed.path}}")
		// .routeId("inboundFilePollingRoute")
		// .unmarshal(c24io(Purchase_orderElement.class));
		from("file://{{inbound.read.path}}?idempotent=true&delay={{inbound.file.poller.fixed.delay}}&move={{inbound.processed.path}}&moveFailed={{inbound.failed.path}}")
				.routeId("inboundFilePollingRoute").unmarshal(c24io(Purchase_orderElement.class))
				.to("direct:inboundMessageHandling");

	}

}
