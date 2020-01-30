package com.basicprogram;

public class Multi_Dimentional_Example {

	public static void main(String[] args) {
		String arr[][]=new String[2][2];
		arr[0][0]="Manual";
		arr[0][1]="Madhukar";
		arr[1][0]="Automation";
		arr[1][1]="srini";
for(int i=0;i<arr.length;i++)
{
	for(int j=0;j<arr.length;j++)
	{
		System.out.print(arr[i][j] +" ");
		
	}
	System.out.println();
}

	}

}
