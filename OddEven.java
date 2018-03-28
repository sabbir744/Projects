import java.util.Scanner;

public class OddEven {
				private static int i;
	public static void main(String[] args) {
		
		
		System.out.println("Enter The Value");
		Scanner input = new Scanner (System.in);
		
		i = input.nextInt();
		
		if(i%2==0)
		{
			System.out.println(i+" is even");
		}
		
		else
		{
			System.out.println(i+" is odd");
		}
		
		
	}

}
