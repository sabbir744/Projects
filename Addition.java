import java.util.Scanner;

public class Addition {
	int z;
	public Addition(int x, int y) {
		
		z = x+y;
		System.out.println(z);
		
	}




	
	
	

	public static void main(String[] args) {
		
		
		Scanner input  = new Scanner(System.in);
		
		int x = input.nextInt();
		int y = input.nextInt();
		
		Addition a = new Addition(x,y);
		

	}

}
