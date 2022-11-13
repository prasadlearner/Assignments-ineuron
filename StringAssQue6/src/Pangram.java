public class Pangram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        boolean flag =false;
		String s1 = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
		s1 = s1.replace(" ", "");
		char[] arr = s1.toCharArray();
		int[] num = new int[26];
		for(int i=0;i<arr.length;i++)
		{
		      num[(arr[i]-65)]++;
		}
		for(int i=0;i<num.length;i++)
		{
			if(num[i]>0)
			{
				continue;
			}
			else 
			{
				System.out.println("not a pangram");
				flag = true;
				break;
			}
			
		}
		if(flag == false)
		System.out.println("it is a pangram ");
		
		
		
 }

}

