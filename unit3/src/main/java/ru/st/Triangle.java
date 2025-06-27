package ru.st;

import java.util.List;

public class Triangle extends Figure{

    public Triangle(Point p1, Point p2, Point p3) {
        super(List.of(p1, p2, p3));
    }

    @Override
    public double area() {
        Point a = points.get(0);
        Point b = points.get(1);
        Point c = points.get(2);
        return Math.abs((a.getX()*(b.getY()-c.getY()) +
                b.getX()*(c.getY()-a.getY()) +
                c.getX()*(a.getY()-b.getY())) / 2);
    }

    @Override
    public double perimeter() {
        Point a = points.get(0);
        Point b = points.get(1);
        Point c = points.get(2);
        return distance(a, b) + distance(b, c) + distance(c, a);
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) +
                Math.pow(p2.getY() - p1.getY(), 2));
    }

    @Override
    public void draw(Color color) {
        System.out.printf("Нарисован %s треугольник с вершинами в точках %s, %s, %s%n",
                color, points.get(0), points.get(1), points.get(2));
    }
}
