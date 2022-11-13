
public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    String s1 = "STATE";
    String s2 ="taste";
    String s3 ="";
    
    boolean flag =false;
//    Convert lower  or uppercase
     
    for(int i=0;i<s1.length();i++)
    {
    	s3=s3+(char)(s1.charAt(i)+32);
   
    }
    
    char[] arr1 =s3.toCharArray();
    char[] arr2 =s2.toCharArray();
//   sorting arr1 
    for(int i=0;i<arr1.length;i++)

	{
		for(int j=1;j<arr1.length-i;j++)
		{
			if(arr1[j]< arr1[j-1])
			{
				char var = arr1[j];
				arr1[j]=arr1[j-1];
				arr1[j-1]=var;
			}
		}
	}
    
    
//   sorting arr2
    for(int i=0;i<arr2.length;i++)

	{
		for(int j=1;j<arr2.length-i;j++)
		{
			if(arr2[j]< arr2[j-1])
			{
				char var = arr2[j];
				arr2[j]=arr2[j-1];
				arr2[j-1]=var;
			}
		}
	}
  
    
    for(int k=0;k<arr1.length;k++)
    {
    	if(arr1[k]==arr2[k])
    	{
    		continue;
    	}
    	else
    	{
    		System.out.println("Not An Anagram  ");
    		flag = true;
    		break;
    	}
    }
    if(flag == false)
    System.out.println("It's An Anagram ");
    
	}

}
