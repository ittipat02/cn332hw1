import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

//import org.beryx.awt.color.*;

public class Main {

    public static void main(String[] args) {
        List<List<String>> data = readCSV();
        System.out.println("data =");
        System.out.println(data);
        System.out.println("filtered");
        List<Shape> result = filterAndCreateListShapes(data);
        System.out.println("result =" + result);
        System.out.println(result.get(0).getColor());
        drawShape(result);
    }
    public static List<List<String>> readCSV() {
        String fileName= "shapeData.csv";
        File file= new File(fileName);

        // this gives you a 2-dimensional array of strings
        List<List<String>> lines = new ArrayList<>();
        Scanner inputStream;

        try{
            inputStream = new Scanner(file);

            while(inputStream.hasNext()){
                String line= inputStream.next();
                String[] values = line.split(",");
                // this adds the currently parsed line to the 2-dimensional string array
                lines.add(Arrays.asList(values));
            }

            inputStream.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // the following code lets you iterate through the 2-dimensional array
        int lineNo = 1;
        for(List<String> line: lines) {
            int columnNo = 1;
            for (String value: line) {
                System.out.println("Line " + lineNo + " Column " + columnNo + ": " + value);
                columnNo++;
            }
            lineNo++;
        }
        
        return lines;
    }
    public static List<Shape> filterAndCreateListShapes(List<List<String>> data) {
        data.remove(0); //remove header
        List<Shape> result = new ArrayList<>();

        for (List<String> i: data){
            Shape shape;

            Double x = Double.parseDouble(i.get(1));
            Double y = Double.parseDouble(i.get(2));
            String shapeType = i.get(3);
            String param1 = i.get(4);
            String param2 = i.get(5);
            String color = i.get(i.size()-1);
            //System.out.println(shapeType);
            //System.out.println(i.get(i.size()-1));
            switch(shapeType) {
                case "square":
                    if (param1 == "NULL"){
                        shape = new Square();
                    }else{
                        shape = new Square(Double.parseDouble(param1), x, y, color);
                    }
                    result.add(shape);
                    break;
                case "circle":
                    if (param1 == "NULL"){
                        shape = new Circle();
                    }else{
                        shape = new Circle(Double.parseDouble(param1), x, y, color);
                    }
                    result.add(shape);
                    break;
                case "rectangle":
                    if ((param1 == "NULL") || (param2 == "NULL")){
                        shape = new Rectangle();
                    }else{
                        shape = new Rectangle(Double.parseDouble(param1),Double.parseDouble(param2), x, y, color);
                    }
                    result.add(shape);

                    break;
                case "triangle":
                    String param3 = i.get(6);
                    String param4 = i.get(7);
                    String param5 = i.get(8);
                    String param6 = i.get(9);
                    if (param1 == "NULL" || param2 == "NULL" || param3 == "NULL" || param4 == "NULL" || param5 == "NULL" || param6 == "NULL"){
                        shape = new Triangle();
                    }else{
                        
                        String pos1 = param1 + "," + param2;
                        String pos2 = param3 + "," + param4;
                        String pos3 = param5 + "," + param6;
                        shape = new Triangle(pos1, pos2, pos3, x, y,color);
                    }
                    result.add(shape);
                    break;
              }
        }
        return result;
    }

    public static void drawShape(List<Shape> data) {
        JFrame f = new JFrame();
        f.setSize(500, 150);
        f.setTitle("CANVAS");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        
        JPanel pn = new JPanel() {
            @Override
            public void paint(Graphics g){
                Graphics2D g2D = (Graphics2D) g;
                g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                for (Shape i: data){
                    if(i.getClass() == Square.class){
                        Color c = MyColor.getColor(i.getColor());
                        g2D.setColor(c);
                        g2D.fillRect((int) i.getX(), (int) i.getY(), (int) ((Square) i).getWidth(), (int) ((Square) i).getWidth());
                    }else if(i.getClass() == Circle.class){
                        Color c = MyColor.getColor(i.getColor());
                        g2D.setColor(c);
                        g2D.fillOval((int)i.getX(),(int) i.getY(),(int) ((Circle) i).getRadius(),(int) ((Circle) i).getRadius());
                    }else if(i.getClass() == Rectangle.class){
                        Color c = MyColor.getColor(i.getColor());
                        g2D.setColor(c);
                        g2D.fillRect((int)i.getX(),(int) i.getY(),(int) ((Rectangle) i).getWidth(),(int) ((Rectangle) i).getHeight());
                    }else if(i.getClass() == Triangle.class){
                        Color c = MyColor.getColor(i.getColor());
                        g2D.setColor(c);
                        Triangle tri = (Triangle) i;
                        int p1x = (int) (tri.getp1_x() + tri.getX());
                        int p1y = (int) (tri.getp1_y() + tri.getY());
                        int p2x = (int) (tri.getp2_x() + tri.getX());
                        int p2y = (int) (tri.getp2_y() + tri.getY());
                        int p3x = (int) (tri.getp3_x() + tri.getX());
                        int p3y = (int) (tri.getp3_y() + tri.getY());
                        g2D.fill(new Polygon(new int[]{p1x, p2x, p3x} ,new int[]{p1y, p2y, p3y}, 3));
                    }
                    
                    
                    
                }
                
                }
            
        };
        
        f.add(pn);
    }
}


