import java.util.Scanner;

public class MultiplicationTable {
			
	
	private static int i,n;
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("enter the multiplication number");
		
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		
		
		
		for(i = 1;i<=10;i++)
		{
			
			System.out.println(n+"*"+i+"="+n*i);
			
			
			
		}
		
		
		
		
		
		
		
		
	}

}
