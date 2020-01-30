package com.basicprogram;

public class Objectarray_Example {

	public static void main(String[] args) {
		Object arr[][]=new Object[2][2];
		arr[0][0]="Manual";
		arr[0][1]='z';
		arr[1][0]=10;
		arr[1][1]=10.35;
		
for(int i=0;i<arr.length;i++)

	{
	for(int j=0;j<arr.length;j++)
	{
		System.out.print(arr[i][j]+"     ");
	
}
System.out.println();
	}


	}
}
