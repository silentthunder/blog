package com.silentthunder.test.amqcamel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("activemq:queue:myqueue?concurrentConsumers=10&maxConcurrentConsumers=20")
			.to("log:com.silentthunder.test.amqcamel?level=DEBUG&groupInterval=10000&groupDelay=60000&groupActiveOnly=false");

	}
}
