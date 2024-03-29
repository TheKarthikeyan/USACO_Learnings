package com.usaco.milk2;

/*
ID: karthik71
LANG: JAVA
TASK: milk2
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class milk2 {
	
	public static int start = 5001;
	public static int end = 0;
	
	static boolean[] activeMilking;
	
	public static void setMilking(int start,int end)
	{
		for(int i=start;i<end;i++)
		{
			activeMilking[i]=true;
		}
	}
	
	public static int getActiveMax()
	{
		int activeMax=0,localMax=0;
		
		for(int i=start;i<=end;i++)
		{
			if(activeMilking[i]==false)
			{
				if(activeMax<localMax)
				{
					activeMax = localMax;
				}
				localMax=0;
			}
			else
			{
				localMax++;
			}
		}
		return activeMax;
	}
	
	public static int getDeactiveMax()
	{
		int deactiveMax=0, localMax=0;
		
		for(int i=start;i<=end;i++)
		{
			if(activeMilking[i]==true)
			{
				if(deactiveMax<localMax)
				{
					deactiveMax= localMax;
				}
				localMax=0;
			}
			else
			{
				localMax++;
			}
		}
		
		
		
		return deactiveMax;
	}

	public static void main(String[] args) throws IOException {
		
			
/*		BufferedReader br = new BufferedReader(new FileReader("milk2.in"));

		PrintWriter out = new PrintWriter(new FileWriter("milk2.out"));*/
		
		BufferedReader br = new BufferedReader(new FileReader("D:/USACO_Learnings/Section1.2/IO/milk2/milk2.in"));

		PrintWriter out = new PrintWriter(new FileWriter("D:/USACO_Learnings/Section1.2/IO/milk2/milk2.out"));	
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] milking = new int[n][2];
		
		for(int i=0;i<n;i++)
		{
			StringTokenizer stok = new StringTokenizer(br.readLine(), " ");
			milking[i][0]=Integer.parseInt(stok.nextToken());
			milking[i][1]=Integer.parseInt(stok.nextToken());
			if(start>milking[i][0])
			{
				start=milking[i][0];
			}
			if(end<milking[i][1])
			{
				end=milking[i][1];
			}
			
		}
		activeMilking = new boolean[end+1];
		
		
		for(int i=0;i<n;i++)
		{
			setMilking(milking[i][0],milking[i][1]);
		}
		
		out.print(getActiveMax()+" "+getDeactiveMax()+"\n");
		
		br.close();
		out.close();
		

	}

}
