import java.util.Scanner;

public class Program2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        System.out.println("Enter number :: ");
		int n = scan.nextInt();
		int n1 = 0;
		int n2 = 1;
		System.out.print(n1+" "+n2+" ");
		for(int i=2;i<n;i++)
		{
         
          int n3 = n1+n2;
          System.out.print(n3+" ");
          
          n1 = n2;
          n2 = n3;
          
		}
		
		
	}

}
