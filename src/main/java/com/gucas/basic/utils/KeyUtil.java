package com.gucas.basic.utils;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

import java.util.UUID;

public class KeyUtil {

	public static String generatorUUID(){
		TimeBasedGenerator timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
		return timeBasedGenerator.generate().toString(); //有时间顺序
	}

	public static String generatorUUID2(){
		return UUID.randomUUID().toString(); //无时间顺序
	}
	
	public static void main(String[] args) {
		System.err.println(generatorUUID());
		System.err.println(generatorUUID());

		System.out.println(generatorUUID2());
		System.out.println(generatorUUID2());
	}
}
