package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(7.0));
        Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));


        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(7.0, 9.0);

        Triangle.printTriangleArea(10.0, 10.0, 10.0);
        Triangle.printTriangleArea(10, 15, 20);
        Triangle.printTriangleArea(7.0, 5.0, 3.0);


        Triangle.printTrianglePerimeter(10.0, 10.0, 20.0);
        Triangle.printTrianglePerimeter(20, 20, 30);

    }

}
