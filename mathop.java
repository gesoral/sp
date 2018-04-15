package mathoperation.java;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MathOPeration {
public static void add(){
	try{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter no1");
	int no1=Integer.parseInt(br.readLine());
	System.out.println("Enter no2");
	int no2=Integer.parseInt(br.readLine());
	System.out.println("Addition is"+(no1+no2));
	}
	catch(Exception e){System.out.println(e);}
}
public static void subtract(){
	try{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter no1");
	int no1=Integer.parseInt(br.readLine());
	System.out.println("Enter no2");
	int no2=Integer.parseInt(br.readLine());
	System.out.println("Subtraction is"+(no1-no2));
	}
	catch(Exception e){System.out.println(e);}
}
public static void multiply(){
	try{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter no1");
	int no1=Integer.parseInt(br.readLine());
	System.out.println("Enter no2");
	int no2=Integer.parseInt(br.readLine());
	System.out.println("Multiplication is"+(no1*no2));
	}
	catch(Exception e){System.out.println(e);}
}
}



