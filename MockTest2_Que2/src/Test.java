abstract class Shape
{
	public abstract float calculateArea();
}
class Rectangle extends Shape
{

	int l = 10;
	int b = 20;
	@Override
	public float calculateArea() {
		
		return l*b;
	}
	
}
class Circle extends Shape
{
  
	float r = 9.60f;
	
	@Override
	public float calculateArea() {
		
		return (float) (3.1415*r*r);
	}
	
}
class Triangle extends Shape
{
	int b = 10; int h = 5;

	@Override
	public float calculateArea() {
		
		return (float) (0.5*b*h);
	}
	
}
class ShapeCalculator
{
	public void printArea(Shape shape)
	{
		System.out.println(shape.calculateArea());
	}
}
public class Test {

	public static void main(String[] args) {
	
		Shape rectangle = new Rectangle();
		Shape circle = new Circle();
		Shape trianglle = new Triangle();
		
		ShapeCalculator shapeCalculator = new ShapeCalculator();
		
		shapeCalculator.printArea(rectangle);
		shapeCalculator.printArea(circle);
		shapeCalculator.printArea(trianglle);

	}

}
