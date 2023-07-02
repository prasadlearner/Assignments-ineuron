import java.util.Scanner;

public class Program4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] arr = new int[3];

		System.out.println("enter any three Numbers :: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		if (arr[0] > arr[1]) {
			if (arr[0] > arr[2]) {
				System.out.println(arr[0] + " is grater");
			} else {
				System.out.println(arr[2] + " is grater");
			}
		} else {
			
			if(arr[1]>arr[2]) {
				System.out.println(arr[1] + " is grater");
			}
			else
			{
				System.out.println(arr[2] + " is grater");
			}
		}
		
	}

}
