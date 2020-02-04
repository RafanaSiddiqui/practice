package com.test;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ParentClass {
	
	static String parentStatic = "ParentStatic";
	
	ParentClass(){
		System.out.println("parent co0nstructor....");
	}
	
	{
		System.out.println(".....parent static...");
	}

	void read() throws Exception
	{
		//throw new IOException();
		System.out.println("..in parent class");
		
	}
	
	
	
	
}
