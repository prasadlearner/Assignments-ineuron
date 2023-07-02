import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number :: ");
		int n = scan.nextInt();
		if(n==0)
		{
			System.out.println("given number is Zero ");
		}
		else if(n>=1)
		{
			System.out.println(n + " is positive number ");
		}
		else
		{
			System.out.println(n + " is negative number");
		}
		
	}

}
