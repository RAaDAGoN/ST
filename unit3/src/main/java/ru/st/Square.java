package ru.st;

public class Square extends Rectangle{
    public Square(Point topLeft, double side) {
        super(topLeft, new Point(topLeft.getX() + side, topLeft.getY() + side));
    }

    @Override
    public void draw(Color color) {
        System.out.printf("Нарисован %s квадрат с углом в точке %s и стороной %.2f%n",
                color, points.get(0),
                Math.abs(points.get(1).getX() - points.get(0).getX()));
    }
}
