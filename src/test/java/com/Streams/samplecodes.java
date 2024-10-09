package com.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class samplecodes {

	//@Test
	public void t1()
	{
		
		ArrayList<String>names=new ArrayList<String>();
		names.add("Arun");
		names.add("Anirudh");
		names.add("Arjun");
		names.add("nanda");
		names.add("akash");
		int count=0;
		for(int i=0;i<names.size();i++)
		{
			String actual=names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
        System.out.println(count);
        
        
	 }
		
		// @Test
		public void t2()
		{
		
		ArrayList<String>names=new ArrayList<String>();
		names.add("Arun");
		names.add("Anirudh");
		names.add("Arjun");
		names.add("nanda");
		names.add("akash");
		
		Long c=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		}
		
		//@Test
		public void t3()
		{
	      // names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
	     Stream.of("arun","don","akashss").filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	 
		}
		
		//@Test
		public void map()
		{
			//print elements endswith
			Stream.of("sandeep","suman","shiva","yadhubhai","rakhi").filter(s->s.endsWith("i")).map(s->s.toUpperCase())
			.forEach(s->System.out.println(s));
			
			//sort and print in uppercase
			List<String>names=Arrays.asList("sandeep","suman","shiva","yadhubhai","rakhi");
			names.stream().sorted().map(s->s.toUpperCase())
			.forEach(s->System.out.println(s));
			
		    //merge two lits and sort and print
			List<String>surnames=Arrays.asList("sura","palvai","kodamagundla","chinthakayala","salla");
		    Stream<String> finalstream= Stream.concat(names.stream(), surnames.stream());
		  //  finalstream.sorted().forEach(s->System.out.println(s));
		    
		   boolean flag= finalstream.anyMatch(s->s.equalsIgnoreCase("shura"));
		   Assert.assertTrue(flag);
		}
		
		@Test
		public void streamCollectors()
		{
			List<String>l=Stream.of("sandeep","suman","shiva","yadhubhai","rakhi").filter(s->s.endsWith("i"))
			.map(s->s.toUpperCase()).collect(Collectors.toList());
			System.out.println(l);
			
			List<Integer>values=Arrays.asList(3,2,4,2,1,7,9);
			List<Integer>li=values.stream().distinct().sorted().collect(Collectors.toList());
			System.out.println(li);
		}
	}


