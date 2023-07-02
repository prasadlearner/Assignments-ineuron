import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		  System.out.println("Enter the Array size  :: ");
		  
		  int n =  scan.nextInt();
		  
		  int [] arr = new int[n];
		  System.out.println("Enter " +n+ " Array elements ::");
		  
	      int i = 0;
		  int sum = 0;
		  do
		  {
			  arr[i]=scan.nextInt();
			  sum+=arr[i];
			i++;
		  } 
		  while(i<arr.length);
		  float avg = sum/n;
		  
		  System.out.println(avg);

	}

}
