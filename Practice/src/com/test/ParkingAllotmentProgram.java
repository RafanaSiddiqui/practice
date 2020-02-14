package com.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.omg.CORBA.portable.ValueOutputStream;

import com.test.model.*;

public class ParkingAllotmentProgram {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Parking> listpr = getAllParking();
		
		Map<ParkingSize, BlockingQueue<String>> m =  getParkingMap( listpr);
		

		for(int i = 0 ; i<3;i++){
			
		String allotedParkingId  =( m.get(ParkingSize.MEDIUM)).poll();
		
			if(null != allotedParkingId && !"".equalsIgnoreCase(allotedParkingId))
			System.out.println("Hello....you parking is "+allotedParkingId);
			else
				System.out.println("Sorry no parking at moment");
			}
		
	}
	
	
	public static Map<ParkingSize, BlockingQueue<String>> getParkingMap( List<Parking> list){
		
		List<Parking> listAll = list;
		
		// Create Map against size
		
		Map<ParkingSize, BlockingQueue<String>> map
					=	listAll.stream().collect(Collectors.groupingBy(Parking::getSize,Collectors.mapping(Parking::getId, 
																				Collectors.toCollection(LinkedBlockingDeque::new))));
													
			System.out.println("......map ...."+map);
		//getting parking ticket for that size
		
		Queue<String> q = new LinkedBlockingDeque<>();
		q.add(null);
		
		return map;
		
	}
	
	
	
	public static List<Parking> getAllParking()
	{
		List<Parking> list = new ArrayList<>();
		
	/*	list.add(new Parking(ParkingSize.SMALL,"A"));
		list.add(new Parking(ParkingSize.SMALL,"B"));
		list.add(new Parking(ParkingSize.MEDIUM,"C"));
		list.add(new Parking(ParkingSize.MEDIUM,"D"));
		list.add(new Parking(ParkingSize.HEAVY,"E"));*/
		
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(ParkingAllotmentProgram.class.getResourceAsStream("ParkingSpace.txt")));
		
		Stream<String> str = bf.lines();
		/*
		str.map(line -> {
			String[] s = line.split(" ");
			Parking p = new Parking(ParkingSize.valueOf(s[0].trim()), s[1].trim());
			list.add(p);
			return p;
		}).forEach(System.out::println);
		*/
		str.map(line -> {
			String[] s = line.split(" ");
			Parking p = new Parking(ParkingSize.valueOf(s[0].trim()), s[1].trim());
			list.add(p);
			return p;
		}).collect(Collectors.toList());
		
		System.out.println(".......getting listr "+list);
		return list;
		
	}

}
