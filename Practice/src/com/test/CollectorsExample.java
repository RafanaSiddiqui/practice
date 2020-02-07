package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.test.model.Person;

/**
 *
 * @author José
 */
public class CollectorsExample {

    public static void main(String... args)  {
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(CollectorsExample.class.getResourceAsStream("people.txt")));
    	
    	
    	List<Person> ls = new ArrayList<>();
			Stream<String> inputData = reader.lines();
			
			//inputData.forEach(System.out::println);
			
			inputData.map(line ->{
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(),Integer.parseInt(s[1]) );
				ls.add(p);
				return p;				
			}).forEach(System.out::println);
			
			
			
			
			Optional<Person> opt = ls.stream()
				.filter(Person -> Person.getAge() >20)
				.min(Comparator.comparing(Person::getAge));
			
			System.out.println(".....1st filter......"+opt);
				
			
			Map<Integer, List<Person>> map = ls.stream()
					.filter(Person -> Person.getAge() >33)
					.collect(Collectors.groupingBy(Person::getAge));
			
			
			System.out.println(".....2nd filter......"+map);

			
			
			Map<Integer, String> mapString = ls.stream()
					.filter(Person -> Person.getAge() >25)
					.collect(Collectors.groupingBy(Person::getAge,
								Collectors.mapping(Person::getName, Collectors.joining(","))));
			
			
			System.out.println(".....3rd filter......"+mapString);
			
			
			Map<Integer, Long> mapCount = ls.stream()
					.filter(Person -> Person.getAge() >25)
					.collect(Collectors.groupingBy(Person::getAge,
								Collectors.mapping(Person::getName, Collectors.counting())));
			
			
			System.out.println("....4th filter......"+mapCount);

			
			
			Map<Integer, Collection<String>> mapSet = ls.stream()
					.filter(Person -> Person.getAge() >25)
					.collect(Collectors.groupingBy(Person::getAge,
								Collectors.mapping(Person::getName, Collectors.toCollection(TreeSet::new))));
			
			
			System.out.println("....5th filter......"+mapSet);
	
			
			
			Map<Integer, Collection<String>> mapQue = ls.stream()
					.filter(Person -> Person.getAge() >25)
					.collect(Collectors.groupingBy(Person::getAge,
								Collectors.mapping(Person::getName, Collectors.toCollection(LinkedBlockingDeque::new))));
			
			
			System.out.println("...6th filter......"+mapQue);
			
		 List lst = ls.stream()
			.filter(Person -> Person.getAge()>25).collect(Collectors.toList());

			System.out.println("..7th filter......"+lst);


				
				 
				 
				List<String> countries = new ArrayList<String>();
				countries.add("india");
				countries.add("japan");
				countries.add("china");
				countries.add("indonesia");
				countries.parallelStream().forEach((country) -> {
				    System.out.println(country);
				});
				 
    	
    }
}
