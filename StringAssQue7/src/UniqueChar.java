import java.util.*;
public class UniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
String s1 = "yuks%7*@ gj";
boolean flag = false;
char[] arr =s1.toCharArray();
int[] num = new int[256];
for(int i =0;i< s1.length();i++)
{
	num[arr[i]]++;
}
for(int ele:num)
{
	if(ele > 1)
	{
		System.out.println("not unique ");
		flag =true;
		break;
	}
	
}
if(flag == false)
System.out.println("String contains unique characters ");
}
}