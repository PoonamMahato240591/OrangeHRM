package com.basicprogram;

public class StringCompr {

	public static void main(String[] args) {
		String var1="LiveTech";
		String var2="LiveTech";
		if(var1.equals(var2)) {
			System.out.println("Both var1 and var2 are equal");
		}
		else
		{
			System.out.println("Both var1 and var2  are not equal");
		}
      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
      String var3="Livetech";
      String var4="LiveTech";
      if(var3.equalsIgnoreCase(var4)) {
    	  System.out.println("both var3 and var4 are equal");
      }
      else
      {
    	  System.out.println("both var3 and var4 are not equal");
      }
      System.out.println("#########################################");
      String var5="LiveTech";
      int length_var5=var5.length();
      System.out.println("The length of the var5 is:"+length_var5);
      System.out.println("++++++++++++++++++++++++++");
      String var6="Live";
      String var7="LiveTech";
      if(var7.contains(var6)) {
    	  System.out.println("var6 is present in var7");
      }
      else {
    	  System.out.println("var6 is not present in var7");
      }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
	}

}
