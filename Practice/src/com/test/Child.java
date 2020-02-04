package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class Child extends ParentClass /*implements Comparable<Child>*/ {
	
	
	static String childStatic = "childStatic";
	static int iChild ;
	static int jChild ;
	
	Child(){
			System.out.println("...child co0nstructor...."+iChild+"..."+childStatic);
		}
	
	
	public Child(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	{
		System.out.println(".start ..child static ...."+iChild+ "..."+childStatic);
		iChild = 12;
		jChild = 34;
		System.out.println("...child static ...."+iChild+"..."+childStatic);
	}

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	void read() throws IOException
	{
		//throw new IOException();
		System.out.println("in child");
		
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Child other = (Child) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Child o) {
		// TODO Auto-generated method stub
		return this.getName().compareToIgnoreCase(o.getName());
	}*/
	
	
	
}
