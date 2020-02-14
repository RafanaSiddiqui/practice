package com.test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.test.model.Innings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;



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
		
		//avergeOfPlayer();
		
		topNumberinArray();
		
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
	
	public static void topNumberinArray(){
		
		List<Integer> l =  new ArrayList(Arrays.asList( 12,44, 89, 3, 14,  5, 6, 7));
		
		Optional<Integer> opt = l.stream().max(Comparator.naturalOrder());
		System.out.println(".....optional...."+opt);
		
		
		List<Integer> sortl =  l.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		
		for (Integer i : sortl) {
			System.out.println(i);
		}
		

		Collections.reverse(l);
		
		Integer[] intReverseArray = new Integer[l.size()];
		intReverseArray = l.toArray(intReverseArray);

		for (Integer i : intReverseArray) {
			System.out.println("......reverse array.."+ i);
		}
		
		Optional<Integer> o = l.stream().max(Comparator.naturalOrder());
		System.out.println("......max no..."+ o.get());
		
		Collections.sort(l);
		System.out.println("......min no. from old java.."+ l.get(0));

		
		Collections.sort(l, Collections.reverseOrder());
		System.out.println("......max no. from old java.."+ l.get(0));
		
		
		
	}
	
	public static void avergeOfPlayer(){
		
		 Innings in1 = new Innings(100, true);
		 Innings in2 = new Innings(200, true);
		 Innings in3 = new Innings(100, false);
		 
		 List<Innings> l = new ArrayList<>();
		 l.add(in1);
		 l.add(in2);
		 l.add(in3);
		 
		 Integer sum = l.stream().map(in -> in.getRuns()).reduce(0, Integer::sum);
		 
		 System.out.println("..get sum..."+ sum);
		 
		 int count = 0;
		 
		for(Innings in : l)
		{
			if(in.isOut())
				count++;
		}
		 
		int avg = sum/count;
		
		System.out.println("....count....."+ count+ "....avg.."+avg);

	}

}
