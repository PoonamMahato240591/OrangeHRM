package com.basicprogram;

public class Elseifexample {

	public static void main(String[] args) {
		int var1=10;
		int var2=20;
		int var3=15;
		if(var1>var2 && var1>var3)
		{
			System.out.println("var1 is greater than var2 and var3");
		}
		else
			if(var2>var3)
			{
				System.out.println("var2 is greater than var1 and var3");
			}
			else
			{
				System.out.println("var3 is greater than var1 and var2");
			}
	}

}
