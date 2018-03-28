import java.util.Scanner;

public class Ifelse {

	private static int passmark;
	private static int obtainmark;

	public static void main(String[] args) {
		
		passmark = 40;
		
		System.out.println("enter your obtain mark: ");
		Scanner input  = new Scanner(System.in);
		obtainmark = input.nextInt();
		
		
		if (obtainmark >= passmark)
		{
			System.out.println("you passed");
			
			
		}
		else
		{
			System.out.println("you fail");
			System.out.println(input.nextLine());
		}
	
		
		
		
		
		
		
		
		
		
	
		

	}

}
