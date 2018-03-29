import java.util.Scanner;

public class Swapping {
	
	private static int x,y;

	public static void main(String[] args) {
		
		
		System.out.println("enter the first number: ");
		Scanner input = new Scanner(System.in);
		x = input.nextInt();
		System.out.println("enter the Second number: ");
		y = input.nextInt();
		
		
		int temp = x;
		x = y;
		y = temp;
		
		
		System.out.println(x);
		System.out.println(y);
		
		
		
		
		
		
		
		
	}

}
