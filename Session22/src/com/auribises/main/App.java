package com.auribises.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.auribises.beans.Connection;

public class App {

	public static void main(String[] args) {
		
		// Traditional Way of creating Java Objects
		// Object Construction Way:
		
		/*Connection con1 = new Connection();
		con1.setUrl("jdbc:mysql://localhost/aurdb");
		con1.setUser("root");
		con1.setPassword("pass1223");
		
		Connection con2 = new Connection("mongodb://cluster0.zbc.xyz.com", "atpl", "atpl123");
		
		System.out.println(con1);
		System.out.println(con2);*/
		
		// We as developers, create objects in memory and manage them with reference variables

		// Challenge:
		// In case DB Connection URL or password is modified
		// We will have to change our source code and hence re compile the project and than give the solution again to the client :)

		// We may have an object which demands configuration.
		// For such objects if we code them in java files, it may be a case where updating data in the objects needs re-work
		
		// Solution:
		// INVERSION OF CONTROL [IOC]
		// The way we create objects will be inverted
		// Spring FW will create objects for us and will also manage the same for us
		// We as developers will configure the data of object in an XML file and Spring FW parses the XML file for us and creates/manages objects
		
		// IOC Procedure:
		// 1. Link the project with Spring Jars by Configuring the Build Path
		// mvnrepository
		// spring.io
		
		// 2. Create a Bean Object
		
		// 3. Copy XML file into src directory and configure the object over thr
		
		// 4. In main class, write Spring IOC Code
		//    IOC Container
		//		1. BeanFactory
		//      2. ApplicationContext
		
		// IOCContainer is the one which is responsible to create/manage objects by parsing XML file for us
		// In SpringFW Core layer means IOC Container
		
		/*
		Resource resource = new ClassPathResource("beans.xml");	// Parse the XML File
		BeanFactory factory = new XmlBeanFactory(resource);		// Construct the Objects for Program | IOC Container
		// BeanFactory constructs the Objects on Demand i.e. when we execute getBean method
		
		// from IOC Container request for Objects
		Connection c1 = (Connection)factory.getBean("con1");
		Connection c2 = factory.getBean("con2", Connection.class);
		Connection c3 = factory.getBean("con1", Connection.class);
		
		// Above Statements we will have the references to the objects configured in XML File
		System.out.println("c1 is: "+c1+" HashCode: "+c1.hashCode());
		System.out.println("c2 is: "+c2+" HashCode: "+c2.hashCode());
		System.out.println("c3 is: "+c3+" HashCode: "+c3.hashCode());
		*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// ApplicationContext constructs the Objects before hand i.e. whenever ApplicationContext is conctructed
		
		
		Connection c1 = (Connection)context.getBean("con1");
		Connection c2 = context.getBean("con2", Connection.class);
		//Connection c3 = context.getBean("con1", Connection.class);
		
		// Above Statements we will have the references to the objects configured in XML File
		System.out.println("c1 is: "+c1+" HashCode: "+c1.hashCode());
		System.out.println("c2 is: "+c2+" HashCode: "+c2.hashCode());
		//System.out.println("c3 is: "+c3+" HashCode: "+c3.hashCode());
		
		// Close the ApplicationContext i.e. shutting down the IOC Container
		((ClassPathXmlApplicationContext)context).close();
	}

	// ApplicationContext is built on top of BeanFactory
	// So, we must use ApplicationContext in our Apps :)
}
