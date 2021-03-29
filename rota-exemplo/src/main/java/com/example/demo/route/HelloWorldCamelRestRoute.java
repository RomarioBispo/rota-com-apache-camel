package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.processor.TransformedHelloWorldProcessor;

@Component
class HelloWorldCamelRestRoute extends RouteBuilder {
	
	@Value("${servicoa.url}")
	private String urlServiceA;

	@Value("${servicob.url}")
	private String urlServiceB;

	@Override
	public void configure() throws Exception {
		
		 restConfiguration()
		 .host("localhost:8100")
	     .component("servlet")
	     .enableCORS(true)
	     .bindingMode(RestBindingMode.auto);
		 
		 //contexto automatico /camel -> /camel/api/hello
		 rest("/api")
		.get("/hello").to("direct:hello");
		 
		 from("direct:hello")
		 .to("rest:get:api/v1/b/hello?bridgeEndpoint=true")
		 .process(new TransformedHelloWorldProcessor());
	}
}
