package com.Oops.Interface;

public class IndiaTraffic implements Centralsignal{

	public static void main(String[] args) 
	{
		Centralsignal c=new IndiaTraffic();
		c.greengo();
		c.redstop();
		c.yellow();
		
		IndiaTraffic i=new IndiaTraffic();
		i.walk();
		i.redstop();

	}

	public void walk()
	{
		System.out.println("people can cross the road");
	}
	@Override
	public void redstop() {
		// TODO Auto-generated method stub
		System.out.println("red signal implementation");
	}

	@Override
	public void greengo() {
		// TODO Auto-generated method stub
		System.out.println("Green signal implementation");
	}

	@Override
	public void yellow() {
		// TODO Auto-generated method stub
		System.out.println("yellow signal implementation");
	}
// interface means the methods defined without the body in interface class, these methods 
//can be implemented by using implements keywords , we can implement two or more interfaces at a time
}
