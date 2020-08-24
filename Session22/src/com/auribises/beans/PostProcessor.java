package com.auribises.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("-- postProcess AFTER Initialization --"+beanName);
		
		if(beanName.equals("con1")) {
			// Obtain reference to the bean objects created by IOC Container
			Connection con = (Connection)bean;
			con.password = "abc@xyz#123";
		}
		
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("-- postProcess BEFORE Initialization --"+beanName);
		return bean;
	}

}
