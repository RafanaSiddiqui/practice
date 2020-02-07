package com.test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class TestJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//testLocalDate();
		
		String name = "hello";
		Runnable r1 = () -> System.out.println(name);
		
		//String name2 = "";
		 String name2 = name.toUpperCase();
		Runnable r2 = () -> System.out.println(name2);
		r1.run();	
		
	}
	
	public static void testLocalDate(){
		
		LocalDate date = LocalDate.now();
        System.out.println(date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        
        LocalTime time = LocalTime.now();
        System.out.println(time.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
        
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
	
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate customDate = LocalDate.parse("01/01/2016", dateFormatter);
        System.out.println("Parsed date is "+ customDate);
        
        DateTimeFormatter dateTimeformatter = DateTimeFormatter.ofPattern("MMMM dd yyyy hh':'mm a");
        LocalDateTime customDateTime = LocalDateTime.parse("June 01 2015 12:01 AM",dateTimeformatter);
        System.out.println("Parsed datetime is "+ customDateTime);
	
        
        
        LocalDate dateCalc = LocalDate.now();
        System.out.println("Today = " + date);
        System.out.println("Today + 7 days = " + dateCalc.plusDays(7));
        System.out.println("Today + 2 weeks = " + dateCalc.plusWeeks(2));
        
        LocalTime timeCalc = LocalTime.now();
        System.out.println("\nCurrent time = " + time);
        System.out.println("Current Time +  2 hours = " + timeCalc.plusHours(2));
        System.out.println("Current Time + 15 mins = " + timeCalc.plusMinutes(15));
	}
	
	

}
