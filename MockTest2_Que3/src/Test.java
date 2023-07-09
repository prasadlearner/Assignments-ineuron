class Person
{
	private String name;
	private int age;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
public class Test {

	public static void main(String[] args) {
	
		Person person = new Person();
		
		person.setName("vihaan");
		person.setAge(24);
		person.setAddress("brindavan");
		
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getAddress());
	}

}
