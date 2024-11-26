public class ex4_test {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0); // Radius = 5.0
        Shape rectangle = new Rectangle(4.0, 6.0); // Length = 4.0, Width = 6.0
        Shape triangle = new Triangle(3.0, 4.0); // Base = 3.0, Height = 4.0

        // Create ShapeCollection
        ShapeCollection shapeCollection = new ShapeCollection();

        // Add shapes to collection
        shapeCollection.addShape(circle);
        shapeCollection.addShape(rectangle);
        shapeCollection.addShape(triangle);
        shapeCollection.addShape(circle);

        // Print total area and perimeter of all shapes
        System.out.println("Total Area of Shapes: " + shapeCollection.getTotalArea());
        System.out.println("Total Perimeter of Shapes: " + shapeCollection.getTotalPerimeter());
    }
}
/*You are tasked with creating a system that models different geometric shapes and can calculate their area and perimeter. This system will demonstrate the use of interfaces and inheritance.

Create an interface Shape that contains the following methods:

public double calculateArea()
public double calculatePerimeter()
Implement the Shape interface with three classes:

Circle class with an attribute radius and methods to calculate the area (π * radius^2) and perimeter (2 * π * radius).
Rectangle class with attributes length and width and methods to calculate the area (length * width) and perimeter (2 * (length + width)).
Triangle class with attributes base and height and methods to calculate the area (0.5 * base * height) and perimeter (using the Pythagorean theorem or provided side lengths).
Create a class ShapeCollection that:

Contains an ArrayList shapes of type Shape.
Provides a method public void addShape(Shape shape) to add a shape to the collection.
Provides a method public double getTotalArea() to calculate and return the total area of all shapes in the collection.
Provides a method public double getTotalPerimeter() to calculate and return the total perimeter of all shapes in the collection.

 */

interface Shape {
    public double calculateArea();
    public double calculatePerimeter();
}
class Circle implements Shape {
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 3.14 * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2*3.14 * radius;
    }
    public String getContent(){
        return radius+" ";
    }
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Circle)
        {
            Circle other= (Circle) o;
            return other.getContent().equals(this.getContent());
        }
        return false;
    }
}
class Rectangle implements Shape {
    double length;
    double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public String getContent(){
        return length+" "+width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return (2*(length + width));
    }
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Rectangle)
        {
            Rectangle other= (Rectangle) o;
            return other.getContent().equals(this.getContent());
        }
        return false;
    }
}
class Triangle implements Shape {
    double base;
    double height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5*base*height;
    }

    @Override
    public double calculatePerimeter() {
        double sideA=base;
        double sideB=height;
        double sideC=Math.sqrt(base * base + height * height);//ipotenuza
        return sideC+ sideB+ sideA;
    }
    public String getContent(){
        return base+" "+height;
    }
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Triangle)
        {
            Triangle other= (Triangle) o;
            return other.getContent().equals(this.getContent());
        }
        return false;
    }
}
/*Contains an ArrayList shapes of type Shape.
Provides a method public void addShape(Shape shape) to add a shape to the collection.
Provides a method public double getTotalArea() to calculate and return the total area of all shapes in the collection.
Provides a method public double getTotalPerimeter() to calculate and return the total perimeter of all shapes in the collection.

 */
class ShapeCollection {
    Shape[] shapes;
    int no_of_shapes = 0;
    public ShapeCollection() {
        shapes = new Shape[no_of_shapes];
    }
    public void addShape(Shape shape) {
        if(shape == null)
            return;
        for(Shape s: shapes)
        {
            if(s.equals(shape))
            {
                System.out.println("shape already exists");
                return;
            }
        }
        Shape[] temp= new Shape[shapes.length+1];
        for(int i=0;i<no_of_shapes;i++)
        {
            temp[i]= shapes[i];
        }
        temp[no_of_shapes] = shape;
        shapes=temp;
        no_of_shapes++;
    }
    public double getTotalArea() {
        double sum_of_area = 0;
        for(Shape s: shapes)
        {
            sum_of_area+=s.calculateArea();
        }
        return sum_of_area;
    }
    public double getTotalPerimeter() {
        double sum_of_perimeter = 0;
        for(Shape s:shapes)
        {
            sum_of_perimeter+=s.calculatePerimeter();
        }
        return sum_of_perimeter;
    }
}
