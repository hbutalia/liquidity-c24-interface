package biz.c24.io.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Using a Processor in the route to invoke HelloBean.
 */
@Component
public class InvokeWithProcessorSpringRoute extends RouteBuilder {

    @Autowired
    private PreProcessor preProcessor;

    @Override
    public void configure() throws Exception {
        from("direct:hello")
            .process(new Processor() {
                public void process(Exchange exchange) throws Exception {
                    // extract the name parameter from the Camel message which we want to use
                    // when invoking the bean
                    String name = exchange.getIn().getBody(String.class);

                    // invoke the bean which should have been injected by Spring
                    String answer = preProcessor.appendCamel("Router");
                    System.out.println("answer.. "+answer);
                    // store the reply from the bean on the OUT message
                    exchange.getOut().setBody(answer);
                }
            });
    }
}
