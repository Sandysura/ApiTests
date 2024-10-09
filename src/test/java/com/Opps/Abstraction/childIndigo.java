package com.Opps.Abstraction;

public class childIndigo extends MainAircraft {

	public static void main(String[] args)
	{
		
		childIndigo c=new childIndigo();
		c.colour();
		c.engine();
		c.safteyInstructions();
		
		//MainAircraft m=new MainAircraft(); we cannot instantiate object for abstract class
		//child classes are forced to implememnt the abstract methods of parent class
	}

	@Override
	public void colour()
	{
		System.out.println("red colour");
	}

}
