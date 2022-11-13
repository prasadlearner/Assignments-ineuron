import java.util.Arrays;

public class CountVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String s1 ="Intel #Core ^";
s1=s1.toLowerCase();

int vowels=0;int consonants =0;int specialChar =0;

for(int i =0; i<s1.length();i++)
{
	char alpha = s1.charAt(i);
	
	if(alpha>='a' && alpha<='z')
	{
	 if(alpha == 'a' || alpha == 'e' || alpha =='i' || alpha =='o' || alpha == 'u')
	{
		vowels++;
	}
	 else consonants++;
	}
	else 
	{
		specialChar++;
	}
}
System.out.println("vowels --> " + vowels);
System.out.println("consonants --> " + consonants);
System.out.println("special characters --> " + specialChar);
}

}
