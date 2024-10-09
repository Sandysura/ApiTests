package com.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class YoutubeExamples {

	public static void main(String[] args) 

	{
		List<Integer>al=Arrays.asList(10,20,13,23,40);
		List<Integer>fl=al.stream().filter(n->n%2==0).collect(Collectors.toList());
		System.out.println(fl);
		
		List<String>k=Arrays.asList("monalisa","sandeep","shekar","kalyang");
		k.stream().filter(n->(n.length()>6&&n.length()<8)).forEach(n->System.out.println(n));

	    
	}

}
