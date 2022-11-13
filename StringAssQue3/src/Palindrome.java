
public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1= "2552";
		String s2 ="";
		for(int i=s1.length()-1;i>=0;i--)
		{
			s2=s2+s1.charAt(i);
		}
		if(s1.contentEquals(s2))
		{
			System.out.println("It is Palindrome"); 
		}
		else
		{
			System.out.println("Not a Palindromr");
		}

	}

}
