package com.silentthunder.test.amqcamel;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext.xml");
		ctx.registerShutdownHook();

	}

}
