package com.ravi.demo1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo1Application {

	/*
	 * Even though the log output may appear as:
	 *
	 *   Started Demo1Application in 18.923 seconds (process running for 20.658)
	 *   Started Command Line Runner!!!
	 *   Application started successfully!!!
	 *
	 * ...the 'main' method is always invoked first by the JVM. This is mandated by the Java specification:
	 * the JVM starts execution at the 'public static void main(String[] args)' method.
	 *
	 * What this log order suggests is that the `System.out.println("Application started successfully!!!");`
	 * line inside 'main' is executed _after_ SpringApplication.run(...), which itself starts the Spring context,
	 * runs all initializers, and finally invokes all CommandLineRunner beans after the context is ready.
	 *
	 * The lambda for the CommandLineRunner (outputting "Started Command Line Runner!!!") is invoked
	 * as part of the Spring Boot lifecycle, after the application context is up, but _before_ the rest of code
	 * following SpringApplication.run(...) inside main is executed.
	 *
	 * This means: 'main' _always_ starts first, but 'SpringApplication.run' blocks until
	 * Spring's event hooks (such as CommandLineRunner) have finished. Only then does the line
	 * after SpringApplication.run(...) in main get executed (the one printing "Application started successfully!!!").
	 *
	 * So, execution order:
	 *   1. 'main' method entered (by JVM)
	 *   2. 'SpringApplication.run(...)' called
	 *      2.1. Spring context is created
	 *      2.2. CommandLineRunner(s) executed ("Started Command Line Runner!!!" printed)
	 *      2.3. SpringApplication.run returns
	 *   3. Next line in main after SpringApplication.run(...) ("Application started successfully!!!" printed)
	 *
	 * In summary: the 'main' method is invoked first, but due to the blocking nature of SpringApplication.run,
	 * the post-run lines in main happen after CommandLineRunner beans are executed.
	 */
	public static void main(String[] args) {
		System.out.println("Inside main() method.");
		SpringApplication.run(Demo1Application.class, args);
		System.out.println("Application started successfully!!!");
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return runner -> {
			System.out.println("Started Command Line Runner!!!");
		};
	}

}
