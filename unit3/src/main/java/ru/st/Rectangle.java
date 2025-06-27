package ru.st;

import java.util.List;

public class Rectangle extends Figure{

    public Rectangle(Point topLeft, Point bottomRight) {
        super(List.of(topLeft, bottomRight));
    }

    @Override
    public double area() {
        double width = Math.abs(points.get(1).getX() - points.get(0).getX());
        double height = Math.abs(points.get(1).getY() - points.get(0).getY());
        return width * height;
    }

    @Override
    public double perimeter() {
        double width = Math.abs(points.get(1).getX() - points.get(0).getX());
        double height = Math.abs(points.get(1).getY() - points.get(0).getY());
        return 2 * (width + height);
    }

    @Override
    public void draw(Color color) {
        System.out.printf("Нарисован %s прямоугольник с углами в точках %s и %s%n",
                color, points.get(0), points.get(1));
    }
}
