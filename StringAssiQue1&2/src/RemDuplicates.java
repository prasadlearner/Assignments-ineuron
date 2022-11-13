import java.util.Arrays;

public class RemDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String s1 = "javafullstack";
      String s2 = "";
      char[] arr = s1.toCharArray();
      Arrays.sort(arr);
      for(int i=0;i<arr.length-1;i++)
      {
    	 if(arr[i] != arr[i+1]) 
    	 {
    		 s2=s2+arr[i];
    	 }
    	 
      }
      s2 =s2+arr[arr.length-1];
      
      System.out.println(s2);
	}

}
