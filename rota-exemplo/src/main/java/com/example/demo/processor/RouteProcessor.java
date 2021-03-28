package com.example.demo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RouteProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange);
    }
}
