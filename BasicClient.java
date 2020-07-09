package com.apex.client;



import com.apex.server.BasicCalc;

public class BasicClient {
	
	public static void main(String args[]) {
		BasicCalc calc= new BasicCalc();
		int var1= calc.add(10,20);
		int var2= calc.sub(10, 20);
		int var3= calc.prod(10,20);
		int var4= calc.div(10, 20);
	}

}
