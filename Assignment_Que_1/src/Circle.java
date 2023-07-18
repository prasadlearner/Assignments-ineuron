
public class Circle implements Shape {
	 
	float radius = 2.5f;
	final float pie = 3.1415f;

	@Override
	public void calArea() {
	
		float area = pie*radius*radius;
		System.out.println("Circle Area is :: " + area);

	}

	@Override
	public void calPerimeter() {
		
		float perimeter = 2*pie*radius;
		System.out.println("Circle Perimeter is :: " + perimeter);
		

	}

}
