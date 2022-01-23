public class Shape {
    private String color;
    private double x, y;

    public Shape() {
        color = "white";
        x = y = 0;
    }

    public Shape(double x, double y, String color) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Shape";
    }

}
