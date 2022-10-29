// 3d jagged array

import java.util.Scanner;
public class ArrUserIn2 {

	public static void main(String[] args) {
	Scanner obj = new Scanner(System.in);
	String [][][] arr = new String[3][][];
    arr[0] = new String[3][];
    arr[1] = new String[1][];
    arr[2]= new String[2][];
    arr[0][0] = new String[4];
    arr[0][1] = new String[3];
    arr[0][2] = new String[2];
    arr[1][0] = new String[3];
    arr[2][0] = new String[5];
    arr[2][1] = new String[2];
    for(int i =0;i<arr.length;i++)
    {
    	for(int j =0;j<arr[i].length;j++) 
    		
    	{
    		for(int k=0;k<arr[i][j].length;k++)
    		{
    			
    			System.out.println("Enter Courses offered in " + i + " District " + j + " college ");
    			arr[i][j][k] = obj.nextLine();
    		}
    	}
    		
    	
    }
  
    
    for(int i =0;i<arr.length;i++)
    {
    	for(int j =0;j<arr[i].length;j++) 
    		
    	{ 
    		  System.out.println( "In " + i + " District  The courses offered by The " + j + " college are " );
    		for(int k=0;k<arr[i][j].length;k++)
    		{
    			
    			System.out.print(arr[i][j][k] + " ");
    			
    		}
    		System.out.println();
    	}
    		
    	
    }
    
	}

}
