package com.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueUsingStreams {

	public static void main(String[] args)
	
	{
		
		String s="testings";
		String[]str=s.split("");
		List<String> list1 = Arrays.asList(str);
		List<String> list3 = Arrays.asList(str);
		
		list1.stream().distinct().forEach(n->System.out.println(n));
		System.out.println("    ");
		
	     list3.stream().filter(n->Collections.frequency(list3, n)>1).distinct().forEach(n->System.out.println(n));
	     System.out.println("    ");
	     
		ArrayList<String>temp=new ArrayList();
		for(int i=0;i<s.length();i++)
		{
			temp.add(Character.toString(s.charAt(i)));
		}
		
		Set<String>set=new HashSet<String>(temp);
		for(String k:set)
		{
			System.out.println(k+"-->"+Collections.frequency(temp, k));
		}
		System.out.println("    ");
		
		int arr[]=new int[] {1,2,3,4,3,2,5};
		List<Integer>list4=Arrays.stream(arr).boxed().collect(Collectors.toList());
		list4.stream().distinct().forEach(n->System.out.println(n));
		System.out.println("    ");
		
		List<Integer>list2=Arrays.stream(arr).boxed().collect(Collectors.toList());
		list2.stream().filter(n->Collections.frequency(list2, n)>1).distinct().forEach(n->System.out.println(n));
	}

}
