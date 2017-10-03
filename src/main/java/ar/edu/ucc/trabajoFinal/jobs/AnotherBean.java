package ar.edu.ucc.trabajoFinal.jobs;

import org.springframework.stereotype.Component;

@Component("anotherBean")
public class AnotherBean {
	
	public void printAnotherMessage(){
		System.out.println("I am called by Quartz jobBean using CronTriggerFactoryBean");
	}
	
}
