package com.test;


import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.io.IOException;
import java.util.*;


public abstract class Test {
	


	 abstract void read();
	
	public static void main(String... args) {
		// TODO Auto-generated method stub
	/*	System.out.println("hello" + 5/10);
		
		System.out.println(reverse(123));
		
		System.out.println(Objects.hash("ram"));
		
		int[] iArr = {1,1,2,4,4,5,3,3,8,7};
		
		  HashMap<String, String> codenames = new HashMap<String, String>();
        
        codenames.put("JDK 1.1.4", "dSparkler");
        codenames.put("J2SE 1.2", "ePlayground");
        codenames.put("J2SE 1.3", "aKestrel");
        codenames.put("J2SE 1.4", "bMerlin");
        codenames.put("J2SE 5.0", "fTiger");
        codenames.put("Java SE 6", "cMustang");
        
       //sortMapbyValue(codenames);
        
        
        comparingExample();
    
         
         
        String str = "hello";
        char[] tgt = str.toCharArray();
        
        for (char ci : tgt){
        	System.out.println("..char.."+ci);
        }
        
        Deque<String> dq = new ArrayDeque<>();
        dq.add("D");
        dq.add("B");
        dq.add("C");
  
        System.out.println("...dq..."+dq.poll());
        System.out.println("...dq..."+dq.pollLast());
      */
      		
/*		Demo job = new Demo();
		Thread t1 = new Thread(job);
		Thread t2 = new Thread(job);
		
		t1.start();
		t2.start();*/
		/*
		List<Integer> lnlist= new LinkedList<Integer>();
		
		lnlist.add(1);
		lnlist.add(2);
		lnlist.add(3);
		lnlist.add(4);
		lnlist.add(5);
		
		for(int i =0; i<lnlist.size(); i++)
		{
				System.out.println("elements in list...."+lnlist.get(i));
		}
		
		int middleIndex = lnlist.size()/2;
		System.out.println("mid elements in list...."+lnlist.get(middleIndex));*/

		
		//comparingExample();
		//findNthLongestElmt();
		//ListIteratorFailFast();
		
		//testStream();
		
		//testStaticCall();
		
		boolean b1=false;
		boolean b2= false;
		System.out.println(b1^b2);
		
		char[] chars = new char[] {'\u0097'};
        String str = new String(chars);
        System.out.println("..str.."+str);
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
		
		

	}
	
	public static int reverse(int num)
	{
		String reverse = "";
		 String number = String.valueOf(num);
		 System.out.println(" number.." + number);
		 String str = (new StringBuilder(number)).reverse().toString();
		
		 System.out.println(" reverse number.." + str);
		 
		return Integer.parseInt(str);
	}
	
	
	
	public static Map<String,String> sortMapbyValue(HashMap<String, String> hm){
		
		
		Set<Entry<String, String>> entryset = hm.entrySet();
		Map<String, String> sortedMap = new LinkedHashMap<String, String>(); 

		
		
		List<Entry<String, String>> ls = new ArrayList<>(entryset);
		 
		
		
		Comparator<Entry<String, String>> comp = new Comparator<Map.Entry<String,String>>() {
			
			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				// TODO Auto-generated method stub
				
				return (o1.getValue().compareTo(o2.getValue()));
			}
		};
		
		Comparator<Entry<String, String>> complambda = (Entry<String, String> o1, Entry<String, String> o2) -> o1.getValue().compareTo(o2.getValue());
		
		ls.sort(complambda);
		
		for(Entry e: ls){
			 System.out.println(" sorted list.." + e.getValue());
			 sortedMap.put((String)e.getKey(),(String) e.getValue());
		}
		
		sortedMap.forEach((Key, Value) ->  System.out.println(" ha ha."+ Key +"..."+Value) );
		

		
		
		/* System.out.println("HashMap after sorting entries by values ");
	        Set<Entry<String, String>> entrySetSortedByValue = sortedMap.entrySet();
	        
	        for(Entry<String, String> mapping : entrySetSortedByValue){
	            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
	        }*/
		
		return sortedMap;
	}
	
	
	public static void playPriorityQ(){
		  
        Queue<String> pq = new PriorityQueue<String>(new Comparator<String>() { 
        	
        	@Override
        	public int compare(String o1, String o2) {
        		// TODO Auto-generated method stub
        		return o2.compareTo(o1);
        	}
        	
		});
        
        pq.add("B");
        pq.add("C");
        pq.add("A");
        pq.add("F");
        
        Iterator<String> i = pq.iterator();
        while (!pq.isEmpty())
        {
        	System.out.println("pq..."+pq.poll());
        }
	}
	
	
	
	
	public static void comparingExample(){

	    ParentClass parent = new Child("She", 12);  
	 
	    
	    try {
			parent.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Child> ls = new ArrayList<>();
        Child c1 = new Child ("Harry", 12);
        Child c2 = new Child ("Amy", 13);
        Child c3 = new Child ("lily", 10);
        Child c4 = new Child ("lily", 14);
        Child c5 = new Child ("Dan", 10);
        
        ls.add(c1);
        ls.add(c2);
        ls.add(c3);
        ls.add(c4);
        ls.add(c5);
        Comparator<Child> comp = Comparator.comparing(Child::getName).thenComparing(Child::getAge);
        ls.sort(comp);
        
        for(Child c: ls)
        {
        	System.out.println("..c.."+ c.getName()+"..c age.."+ c.getAge());
        }
        
       Optional<Integer> opt = ls.stream()
					        	.map(Child::getAge)
					        	.filter(age -> age >10)
					        	.min(Comparator.naturalOrder()); 
       
       System.out.println(".........opt......."+ opt);
        
        Set<Child> s = new HashSet<>();
       s.add(c1);
       s.add(c2);
       s.add(c3);
       
      for(Child c : s){
    	  System.out.println("  set size.."+ c.getName());
      }
      
     Set su= Collections.unmodifiableSet(s);
    // su.add(new Child("hini",14));
	}
	
	 public static void findNthLongestElmt()
	 {
		 List<String> l = new ArrayList<String>();
		 l.add("Harry");
		 l.add("Tommy");
		 l.add("Lii");
		 l.add("pony");
		 
		 
		 Map<Integer, List<String>> m = new TreeMap<>();
		
		 
		 for(String s : l)
		 {
			 List<String> ls = new ArrayList<String>();
			 int length = s.length();
			
			 if(null != m.get(length))
			 {
				 ls = m.get(length);
				 ls.add(s);
				 
				 m.put(length,ls );
			 }
			 else{
				 ls.add(s);
				 m.put(length,ls );
			 }
		 }
		 
 
		 m.forEach((key, value) -> {
			 
		
			 
			 System.out.println(key+"..."+value);
			 
			 
	});
		 
		 
	 }
	 
	 
	public static void listReverseNReverseOrder(){
		
		Integer[] nums = {1,2,6,8,3,4};
		//Use Arrays utility class
		List numsList = Arrays.asList(nums);
		
		Collections.reverse(numsList);
		//Collections.sort(numsList,	Collections.reverseOrder());
		
		System.out.println(numsList);
	}

	
public static void ListIteratorFailFast(){
		
		Integer[] nums = {1,2,6,8,3,4};
		//Use Arrays utility class
		List numsList = Arrays.asList(nums);
		
		List l = new ArrayList<Integer>(numsList);
		
		System.out.println(numsList);
		
		ListIterator<Integer> i = l.listIterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
			l.add(10);
		}
				
	}

	public static void testStream(){
		
		Stream<String> str = Stream.of("one", "two","three", "five", "nine");
		
		
		//str.forEach(s-> System.out.println(s)); // foreach performed on same stream
		
		//str.filter(p -> p.length() >3).forEach(s-> System.out.println(s));
		
		//Stream<String> filtrStream = str.filter(p -> p.length() >3);  /// filter returns a new Stream
		
		// Can apply multiple filters on a stream.
		str.filter(p -> p.length() >3)
			.filter(Predicate.isEqual("nine").or(Predicate.isEqual("five")))  /// called predicate chaining
			.forEach(s-> System.out.println(s));
		
	}

	public static void testStaticCall(){
		
		Child child = new Child("heml",2);
		
		Interface1 i1 = child;
		
		i1.sameMethod();
		
		Interface2 i2 = new Child();
		i2.sameMethod();
		
		Child ch1 = (Child) i1;
		try {
			ch1.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	


}
