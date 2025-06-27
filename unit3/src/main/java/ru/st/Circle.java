package ru.st;

import java.util.List;

public class Circle extends Figure{
    private double radius;

    public Circle(Point center, double radius) {
        super(List.of(center));
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw(Color color) {
        System.out.printf("Нарисован %s круг с центром в точке %s и радиусом %.2f%n",
                color, points.get(0), radius);
    }
}
