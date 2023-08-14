package com.natan.bootcamp.cleanarchitecture.movement.domain.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

public class Initializer {

	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
	
	public static String getCreationDate() {
		long millis = System.currentTimeMillis();
		return new Date(millis).toString()+":"+new Time(millis).toString();
	}
}
