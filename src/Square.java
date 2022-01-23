public class Square extends Shape {

    private double width;

    public Square() {
        width = 1;
    }

    public Square(double width) {
        this.width = width;
    }

    public Square(double width, double x, double y, String color) {
        super(x, y, color);
        this.width = width;

    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String toString() {
        return "Square" + width + super.getX() + super.getY() + super.getColor();
    }
}