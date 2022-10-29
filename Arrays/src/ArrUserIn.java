import java.util.*;
public class ArrUserIn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner dp = new Scanner(System.in);
		
		int [] arr = new int [5];
		
		 
     for(int i =0; i <arr.length; i++)
     {
    	 System.out.println("Enter Marks  for "+ i + " student");  
    	 arr[i]=dp.nextInt();
     }
     
     System.out.println("the students marks are :");
     
     for(int i =0; i<arr.length;i++)
     {
    	 System.out.println(arr[i]);
     }
	}

}
