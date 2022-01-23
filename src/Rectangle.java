public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle() {
        width = height = 1;

    }

    public Rectangle(double width, double height, double x, double y, String color) {
        super(x, y, color);
        this.height = height;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {
        return "Rectangle";
    }
}