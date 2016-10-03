package com.usaco.combo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class combo {

	private static int count=0;
	private static int max;

	public static int modArith(int n){
		return n+=max;
	}

	public static boolean checkValidJohnMaster(int[] arr,int n,int index) {

		int remj = (n+arr[index]) % max;

		if (remj < 0)
		{
			remj += max;
		}

		if(remj<=2)
		{
			return true;
		}

		return false;
	}


	public static void generatePossiblePins(int[] jarr,int[] marr) {

		int[] larr = {49};
		for(int value: larr)
		{
			System.out.println(checkValidJohnMaster(jarr,value,0));
			System.out.println(checkValidJohnMaster(marr,value,0));
		}
		/*
		for(int i=1;i<max+1;i++)
		{
			for(int j=1;j<max+1;j++)
			{
				for(int k=1;k<max+1;k++)
				{
					if((checkValidJohnMaster(jarr, i, 0)&&checkValidJohnMaster(jarr, j, 1)&&checkValidJohnMaster(jarr, k, 2)) || (checkValidJohnMaster(marr, i, 0)&&checkValidJohnMaster(marr, j, 1)&&checkValidJohnMaster(marr, k, 2))) {

						count++;
					}
				}
			}
		}*/

	}


	public static void main(String[] args) throws IOException {

		/*		BufferedReader br = new BufferedReader(new FileReader("combo.in"));

		PrintWriter out = new PrintWriter(new FileWriter("combo.out"));
		 */
		BufferedReader br = new BufferedReader(new FileReader("D:/USACO_Learnings/Section1.3/IO/combo/combo.in"));

		PrintWriter out = new PrintWriter(new FileWriter("D:/USACO_Learnings/Section1.3/IO/combo/combo.out"));

		int[] jconfig;
		int[] mconfig;

		max = Integer.parseInt(br.readLine());

		String[] johnConfig = br.readLine().split(" ");
		jconfig = new int[johnConfig.length];
		String[] manuConfig = br.readLine().split(" ");
		mconfig = new int[manuConfig.length];

		for(int i=0;i<johnConfig.length&&i<manuConfig.length;i++)
		{
			jconfig[i] = Integer.parseInt(johnConfig[i]);
			mconfig[i] = Integer.parseInt(manuConfig[i]);
		}

		generatePossiblePins(jconfig, mconfig);


		out.println(count);

		out.close();
		br.close();


	}

}
