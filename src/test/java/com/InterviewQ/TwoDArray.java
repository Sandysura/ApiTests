package com.InterviewQ;

public class TwoDArray {

	/*2 4 5

	3 4 7

	1 2 9*/
	//Maximum number from the array

	public static void main(String[] args)
	{
	
		int[][] abc = { {1, 3, 5, 7}, {9, 11, 13, 15}, {17, 19, 21, 23} };
	  
	  
	   int min=abc[0][0];	
	   int mincoloumn = 0;


	for(int i=0;i<3;i++)
	{
		for(int j=0;j<3;j++)
		{
			if(abc[i][j]<min)//2
			{
				min=abc[i][j];
				mincoloumn=j;
			}
			}
	}
	//=1
		int max=abc[0][mincoloumn];
		int k = 0;
		while(k<3)
		{
			if(abc[k][mincoloumn]>max)
			{
				max=abc[k][mincoloumn];
			}
			k++;
		}

		System.out.println(max);	
		}
		}



