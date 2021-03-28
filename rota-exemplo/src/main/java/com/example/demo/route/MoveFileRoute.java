package com.example.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MoveFileRoute extends RouteBuilder {

	@Value("${route.input.file}")
	private String inputFile;

	@Value("${route.output.file}")
	private String outputFile;

	@Override
	public void configure() throws Exception {

		from("file:" + inputFile + "?noop=true").to("file:" + outputFile);

	}
}
