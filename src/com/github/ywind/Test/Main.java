package com.github.ywind.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	@Autowired
	private Test test;
	
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    	Test test = appContext.getBean(Test.class);
    	System.out.print(test.get("11").toString());
	}

}
