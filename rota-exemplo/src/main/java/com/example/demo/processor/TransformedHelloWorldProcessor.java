package com.example.demo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class TransformedHelloWorldProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
//    	String payload = exchange.getIn().getBody(String.class);
       exchange.getIn().setBody("Changed hello world");
    }
}
