package com.Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InterviewCodesOfStreams {

	public static void main(String[] args) 
	{
		InterviewCodesOfStreams is=new InterviewCodesOfStreams();
		is.exOne();
		is.exTwo();
		is.exThree();
		is.exFour();
		is.exFive();
		is.exSix();
		is.exSeven();
		is.exEight();
		is.exNine();
	}
	public void exOne()
	{
		// 1. Given a list of integers, find out all the numbers starting with 1 using Stream functions?
		List<Integer>i=Arrays.asList(10,15,8,49,25,198,32);
		i.stream().map(n->n+"")// to convert Integre to string
		.filter(n->n.startsWith("1")).
		forEach(n->System.out.println(n));
		
		
	}
	public void exTwo()
	{
		//2.How to find duplicate elements in a given integers list in java using Stream functions?
		
		 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		 myList.stream().filter(n->Collections.frequency(myList, n)>1).distinct()
		 .forEach(n->System.out.println(n));
		 
		 Set<Integer>set=new HashSet();
		// System.out.println(set);
		// myList.stream().filter(n->!set.add(n)).forEach(n->System.out.println(n));
	}

	public void exThree()
	{
		//3. Given the list of integers, find the first element of the list using Stream functions?
		 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		 myList.stream().findFirst().ifPresent(System.out::println);
		 
		 
	}
	public void exFour()
	{
		
		// Given a list of integers, find the total number of elements present in the list using Stream functions?
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		Long c=myList.stream().count();
		System.out.println(c);
	}
	
	public void exFive()
	{
		//Given a list of integers, find the maximum value element present in it using Stream functions?
		List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		int max=myList.stream().max(Integer::compare).get();
		System.out.println(max);
	}
	public void exSix()
	{
		//Given a String, find the first non-repeated character in it using Stream functions?
		
		 String input = "Java articles are Awesome";
		 String[]str=input.split("");
		 List<String>l=Arrays.asList(str);
		 
		 l.stream().distinct().findFirst().ifPresent(System.out::println);
	}
	
	public void exSeven()
	{
		//Given a String, find the first non-repeated character in it using Stream functions?
		
		 String input = "Java articles are Awesome";
		 String[]str=input.split("");
		 List<String>l=Arrays.asList(str);
		 
		String w= l.stream().filter(n->Collections.frequency(l, n)>1).findFirst().get();
		System.out.println(w);
	}
	
	public void exEight()
	{
		// Given a list of integers, sort all the values present in it using Stream functions?
		  List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		//  myList.stream().sorted().forEach(n->System.out.println(n));
		  
		  //to print them in descending order
		  myList.stream().sorted(Collections.reverseOrder()).forEach(n->System.out.println(n));
	}
	
	public void exNine()
	{
		//Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
		int arr[]=new int[] {1,2,3,4,3};
		List<Integer>li=Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		Set<Integer>s=new HashSet(li);
		if(s.size()==li.size())
		{
			System.out.println("false");
		}
		else
		{
			System.out.println("true");
		}
		
	}
	
	
}
