package biz.c24.io.processor;

import org.apache.camel.Exchange;
import org.apache.camel.util.ExchangeHelper;

import biz.c24.io.api.data.ComplexDataObject;
import biz.c24.io.api.data.ValidationEvent;
import biz.c24.io.api.java8.C24;
import biz.c24.io.camel.c24io.C24IOValidator;

public class LMSC24IOValidator extends C24IOValidator {


	@Override
	public void process(Exchange exchange) throws Exception {
		@SuppressWarnings("deprecation")
		ComplexDataObject object = (ComplexDataObject) ExchangeHelper.getMandatoryInBody(exchange,
				ComplexDataObject.class);

			final ValidationEvent[] validationEvents = C24.validateFully(object);

            if (validationEvents == null) {
               System.out.printf("VALID%n");
            } else {
               for (ValidationEvent event : validationEvents) {
                  System.out.printf("INVALID %s: %s%n", event.getLocation(), event.getMessage());
               }
            }
		
	}

}