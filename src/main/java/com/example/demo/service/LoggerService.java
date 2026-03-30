
package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class LoggerService {

	public void init(String msg) {
        System.out.println("Logger Service Created");
    }
	
    public void log(String msg) {
        System.out.println("[LoggerService] " + msg);
    }
}
