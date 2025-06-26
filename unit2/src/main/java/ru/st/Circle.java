package ru.st;

public class Circle {
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double area(){
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double perimeter(){
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "Круг{" +
                "радиус=" + radius +
                ", цвет='" + color +
                ", площадь=" + area() +
                ", периметр=" + perimeter() +'\'' +
                '}';
    }
}

class testingCircle{
    public void testCircle(){
        Circle circle1 = new Circle(5, "Синий");
        Circle circle2 = new Circle(2, "Красный");

        System.out.println(circle1.toString());
        System.out.println(circle2.toString());
    }
}