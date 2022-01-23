public class Circle extends Shape {

    private double radius;

    public Circle() {
        radius = 1;
    }

    public Circle(double radius, double x, double y, String color) {
        super(x, y, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return "Circle";
    }
}