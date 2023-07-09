class Animal
{
	public void makeSound()
	{
		System.out.println("The animal make sound");
	}
}
class Dog extends Animal
{
	@Override
	public void makeSound()
	{
		System.out.println("bow...bow");
	}
}
class Cat extends Animal
{
	@Override
	public void makeSound()
	{
		System.out.println("meow...meow");
	}
}
class Cow extends Animal
{
	@Override
	public void makeSound()
	{
		System.out.println("ambaa...ambaa");
	}
}
public class Test {

	public static void main(String[] args) {
		
      Animal dog = new Dog();
      Animal cat = new Cat();
      Animal cow = new Cow();
      
      dog.makeSound();
      cat.makeSound();
      cow.makeSound();
	}

}
