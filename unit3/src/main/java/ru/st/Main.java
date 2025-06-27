package ru.st;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(new Point(5, 5), 3);
        Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(4, 3));
        Square square = new Square(new Point(2, 2), 5);
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));

        System.out.println("Площадь круга: " + FigureUtil.area(circle));
        System.out.println("Периметр прямоугольника: " + FigureUtil.perimeter(rectangle));
        System.out.println("Площадь квадрата: " + FigureUtil.area(square));
        System.out.println("Периметр треугольника: " + FigureUtil.perimeter(triangle));

        System.out.println("Отрисовка фигур:");
        FigureUtil.draw(circle);
        FigureUtil.draw(rectangle, Color.RED);
        FigureUtil.draw(square, Color.GRAY);
        FigureUtil.draw(triangle, Color.PINK);

    }
}