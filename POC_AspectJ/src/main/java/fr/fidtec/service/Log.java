package fr.fidtec.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Log {

	public void info(String message) {
		// log.info(message);
		System.out.println("LOG : " + message);
	}
}
