
class Demo
{
	public int findIndex(String str)
	{
		 for(char i :str.toCharArray()){
		        if ( str.indexOf(i) == str.lastIndexOf(i)) {
		           // System.out.println("First non-repeating character is: "+i);
		            return str.indexOf(i);   
		        }
		        
			}
		 return -1;
		
}
public class Test {

	public static void main(String[] args) {
		 
		     
		        String s ="loveleetcode";
		        
		        Demo d = new Demo();
		        
		        System.out.println(d.findIndex(s));

		       
		    }

	}
}