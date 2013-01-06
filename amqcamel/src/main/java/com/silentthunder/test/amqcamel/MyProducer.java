package com.silentthunder.test.amqcamel;

import javax.annotation.Resource;

import org.apache.camel.ProducerTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyProducer {

	@Resource
	private ProducerTemplate producerTemplate;

	@Scheduled(fixedDelay = 1)
	@Async
	public void produce() {
		producerTemplate.sendBody(
				"activemq:queue:myqueue?deliveryPersistent=false",
				"Hello World !");
	}
}
