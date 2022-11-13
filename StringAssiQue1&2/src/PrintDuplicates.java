import java.util.Arrays;

public class PrintDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "javafullstackcourse";
		String s2 = "";
		char[] arr = s1.toCharArray();
		
//		sorting
		for(int i=0;i<arr.length;i++)

		{
			for(int j=1;j<arr.length-i;j++)
			{
				if(arr[j]< arr[j-1])
				{
					char var = arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=var;
				}
			}
		}
		
         for(int i=0;i<arr.length;i++)
         {
        	int count =1;
        	 for(int j=i+1;j<arr.length-1;j++)
        	 {
        		 if(arr[j]==arr[i])
        		 {
        			 count ++;
        			 
        		 }
        		 else
        	     break;
        			 
        	 }
        	 if(count>1)
        	 {
        	 System.out.print(arr[i]+" ");
        	 i+=count-1;
        	 }
         }

	}

}
