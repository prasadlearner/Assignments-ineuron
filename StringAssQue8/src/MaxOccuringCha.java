
public class MaxOccuringCha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s1 = "world football champion";
       s1=s1.replace(" ", "");
       char[] m1 =s1.toCharArray();
       int [] arr = new int[256];
       char res = ' ';
       for(int i=0;i<m1.length;i++)
       {
    	   arr[(m1[i])]++;
       }
       
       int max =0;int indexPos =0;
       for(int j =0;j<arr.length;j++)
       {
    	   if(arr[j]>max)
    	   {
    		   max = arr[j];
    		   indexPos= j;
    	   }
       }
       System.out.println(" max occuuring character in a given string is : " + (res =(char)indexPos));
       
	}
             
}
