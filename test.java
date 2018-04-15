package mathoperation.java;

//Test.java
import java.io.*;

public class Test {
public static void main(String arg[]) throws IOException{
while(true)
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("\nOperations you may perform :- \n1.ADD\n2.Mulitply\n3.Subtract\n\nEnter Operation: - ");
		
int choice = Integer.parseInt(br.readLine());

switch(choice){
	case 1: MathOPeration.add();
		break;
	case 2: MathOPeration.multiply();
		break;
	case 3: MathOPeration.subtract();
		break;
	default:System.out.println("Invalid choice") ;
		break;
}

}	
}
}

