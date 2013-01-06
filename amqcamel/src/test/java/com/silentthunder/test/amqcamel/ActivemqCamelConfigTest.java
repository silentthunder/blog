package com.silentthunder.test.amqcamel;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsConfiguration;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static junit.framework.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/test-applicationContext.xml"})
public class ActivemqCamelConfigTest {

	@Resource
	private CamelContext camelContext;
	
	/*
	@Before
	public void setUp() throws Exception{
		DefaultCamelContext defaultCamelContext = (DefaultCamelContext) camelContext;
		defaultCamelContext.setAutoCreateComponents(false);
		defaultCamelContext.start();
	}
	*/
	
	@Test
	public void testPooledConnectionFactoryIsUsed(){
		//ActiveMQComponent amqComponent = camelContext.getRegistry().lookup("activemq", ActiveMQComponent.class);
		ActiveMQComponent amqComponent = camelContext.getComponent("activemq", ActiveMQComponent.class);
		assertNotNull(amqComponent);
		
		JmsConfiguration jmsConfig = amqComponent.getConfiguration();
		ConnectionFactory connectionFactory = jmsConfig.getConnectionFactory();
		
		System.err.println("CF class: "+connectionFactory.getClass().getName());
		assertTrue(connectionFactory instanceof PooledConnectionFactory);
		
	}
}
