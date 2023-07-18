
public class Triangle implements Shape {
	
	int base = 3;
	float height = 5;	
	int side1 = 9;
	int side2 =7;

	@Override
	public void calArea() {
	
		float area = (base*height/2);
		System.out.println("Area of triangle is :: " + area);

	}

	@Override
	public void calPerimeter() {
		float perimeter  = side1+base+side2;
		System.out.println("Perimeter of triangle is :: " + perimeter);
	}

}
