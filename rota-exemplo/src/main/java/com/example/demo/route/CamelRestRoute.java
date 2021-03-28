package com.example.demo.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
class CamelRestRoute extends RouteBuilder {
	
	@Value("${servicoa.url}")
	private String urlServiceA;

	@Value("${servicob.url}")
	private String urlServiceB;

	@Override
	public void configure() throws Exception {
		
		restConfiguration().host("localhost:8100").component("http");
		
		from("timer:scheduler?period=12000")
        .setHeader(Exchange.HTTP_METHOD).constant(HttpMethod.GET)
        .to("http://localhost:8090/api/v1/a")
        .to("rest:post:api/v1/b")
        .log("Response : ${body}");
	}
}
