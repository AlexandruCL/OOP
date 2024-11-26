public class Problem3 {
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

interface Shape{
    public double calculateArea();
    public double calculatePerimeter();
}

class Circle implements Shape{
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    public String getContent() {
        return radius + " ";
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Circle){
            Circle circle = (Circle)o;
            return circle.getContent().equals(this.getContent());
        }
        return false;
    }
}

class Rectangle implements Shape{
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double calculateArea() {
        return width * height;
    }
    public double calculatePerimeter() {
        return 2 * width * height;
    }
    public String getContent() {
        return width + " x " + height;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Rectangle){
            Rectangle rectangle = (Rectangle)o;
            return rectangle.getContent().equals(this.getContent());
        }
        return false;
    }
}

class Triangle implements Shape{
    private double base;
    private double height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    public double calculateArea() {
        return base * height * 0.5;
    }
    public double calculatePerimeter() {
        double sideA = base;
        double sideB = height;
        double sideC = Math.sqrt(base * base + height * height);
        return sideA + sideB + sideC;
    }
    public String getContent() {
        return base + " " + height + " ";
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Rectangle){
            Rectangle rectangle = (Rectangle)o;
            return rectangle.getContent().equals(this.getContent());
        }
        return false;
    }
}

class ShapeCollection{
    Shape[] shapes;
    private int nrofShapes = 0;
    public ShapeCollection() {
        shapes = new Shape[nrofShapes];
    }
    public void addShape(Shape shape) {
        if (shape == null)
            return;
        for(Shape s : shapes){
            if(s.equals(shape)){
                System.out.println("Shape already added");
                return;
            }
        }
        Shape[] temp = new Shape[nrofShapes + 1];
        System.arraycopy(shapes, 0, temp, 0, nrofShapes);
        temp[nrofShapes] = shape;
        shapes = temp;
        nrofShapes++;
    }
    public double getTotalArea() {
        double totalArea = 0;
        for(Shape s : shapes){
            totalArea = s.calculateArea();
        }
        return totalArea;
    }
    public double getTotalPerimeter() {
        double totalPerimeter = 0;
        for(Shape s : shapes){
            totalPerimeter = s.calculatePerimeter();
        }
        return totalPerimeter;
    }
}
























