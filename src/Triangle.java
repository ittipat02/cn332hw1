public class Triangle extends Shape {

    private final double p1_x;
    private final double p1_y;
    private final double p2_x;
    private final double p2_y;
    private final double p3_x;
    private final double p3_y;

    public Triangle() {
        p1_x = 100;
        p1_y = 300;
        p2_x = 150;
        p2_y = 200;
        p3_x = 200;
        p3_y = 300;
    }

    public Triangle(String param1, String param2, String param3, double x, double y, String color) {
        super(x, y, color);

        String target = "(";
        String replacement = "";
        String processed = (param1 + "," + param2 + "," + param3).replace(target, replacement);
        target = ")";
        processed = processed.replace(target, replacement);
        String[] point = processed.split(",");
        p1_x = Double.parseDouble(point[0]);
        p1_y = Double.parseDouble(point[1]);
        p2_x = Double.parseDouble(point[2]);
        p2_y = Double.parseDouble(point[3]);
        p3_x = Double.parseDouble(point[4]);
        p3_y = Double.parseDouble(point[5]);
    }

    public double getp1_x() {
        return p1_x;
    }

    public double getp2_x() {
        return p2_x;
    }

    public double getp3_x() {
        return p3_x;
    }

    public double getp1_y() {
        return p1_y;
    }

    public double getp2_y() {
        return p2_y;
    }

    public double getp3_y() {
        return p3_y;
    }

    public String toString() {
        return "Triangle";
    }
}
