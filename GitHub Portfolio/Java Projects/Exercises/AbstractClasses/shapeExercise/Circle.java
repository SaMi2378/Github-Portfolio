package shapeExercise;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, double radius) {
        super();
        setColor(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
