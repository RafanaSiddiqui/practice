package com.test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.test.model.*;


public class StremTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Student student1 = new Student(
	            "Jayesh",
	            20,
	            new Address("1234"),
	            Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
	 
	        Student student2 = new Student(
	            "Khyati",
	            10,
	            new Address("1235"),
	            Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
	 
	        Student student3 = new Student(
	            "Jason",
	            40,
	            new Address("1236"),
	            Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
		
	        
	        List<Student> students = Arrays.asList(student1, student2, student3);
	        
	        //  Get student with exact match name "jayesh"
	       Optional<Student> opt =  students.stream()
	        .filter(s -> s.getName().equalsIgnoreCase("Jayesh"))
	        .findFirst();
	       
	       System.out.println(opt.isPresent() ? opt.get().getName() : "No result");
	       
	       // Get student with matching address "1235"
	       Optional<Student> opt1=  students.stream()
	   	        .filter(s -> s.getAddress().getZipcode().equalsIgnoreCase("1234"))
	   	        .findFirst();
	       System.out.println(opt.isPresent() ? opt1.get().getName() +".."+ opt1.get().getAddress().getZipcode()  : "No result");
	       
	       //  Get all student having mobile numbers 3333.
		      List<Student> lst =  students.stream()
			   	        .filter(s -> s.getMobileNumbers().stream().anyMatch(num -> num.getNumber().equalsIgnoreCase("3333")))
			   	        .collect(Collectors.toList());
		       System.out.println(lst.size()>0 ? lst.stream().map(s -> s.getName()).collect(Collectors.joining(","))  : "No result");
			       
		       
		       //  Get all student having mobile numbers 1233 and 1234.
			      List<Student> lst1 =  students.stream()
			    		  .filter(s-> s.getMobileNumbers().stream().allMatch(n -> n.getNumber().equalsIgnoreCase("1233") || n.getNumber().equalsIgnoreCase("1234")))
			    		  .collect(Collectors.toList());
			       System.out.println(lst1.size()>0 ? lst1.stream().map(s -> s.getName()).collect(Collectors.joining(","))  : "No result");


			       
			       
	       /*****************************************************
	         Create a List<Student> from the List<TempStudent>
	        *****************************************************/
	        TempStudent tmpStud1 = new TempStudent(
	            "Jayesh11111",
	            201,
	            new Address("12341"),
	            Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));
	 
	        TempStudent tmpStud2 = new TempStudent(
	            "Khyati1111",
	            202,
	            new Address("12351"),
	            Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));
	 
	        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);
	        
	        
	        List<Student> lst3 =tmpStudents.stream()
	        					.map(tmp -> new Student(tmp.getName(), tmp.getAge(), tmp.getAddress(), tmp.getMobileNumbers()))
	        					.collect(Collectors.toList());
	        					
	        System.out.println(lst3.size()> 0 ? lst3.stream().map(Student::getName).collect(Collectors.joining(",")) : "No result");

	        
	        ///Convert List<students> to String
	        String strstudents = students.stream()
	        					.map(Student::getName).collect(Collectors.joining(",", "[", "]"));
	        System.out.println("...strstudents.."+strstudents);
	        
	        
	        /*****************************************************
	         Sort List<String>
	         *****************************************************/
	        List<String> namesList =
	            Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");
	        
	        namesList.stream().sorted().forEach(System.out::println);
	        
	        
	        students.stream().sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
	        
	}

}
