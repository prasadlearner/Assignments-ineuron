
public class Program5 {
	
	int age; 
	String name;
    double weight;
    
    public Program5(int age, String name, double weight) {
    	super();
    	this.age = age;
    	this.name = name;
    	this.weight = weight;
    }
	public static void main(String[] args) {
		Program5 obj = new Program5(24,"prasad",45.0);
		System.out.println(obj);

	}
	@Override
	public String toString() {
		return "Program5 [age=" + age + ", name=" + name + ", weight=" + weight + "]";
	}


}
