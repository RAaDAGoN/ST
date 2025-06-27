package ru.st;

import java.util.List;

public abstract class Figure implements Drawable{
    protected List<Point> points;

    public Figure(List<Point> points) {
        this.points = points;
    }

    public abstract double area();
    public abstract double perimeter();

    @Override
    public void draw(){
        draw(Color.BLACK);
    }
}
