package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {
    public static void main(String[] args) {
        var squares = List.of(new Square(7.0), new Square(5.0), new Square(3.0));
 //      for (Square square : squares) {
 //          Square.printSquareArea(square);
 //      }
       squares.forEach(Square::printSquareArea);





        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(7.0, 9.0);

        Triangle.printTriangleArea(new Triangle(10.0, 20.0, 20.0));
        Triangle.printTriangleArea(new Triangle(10.0, 15.0, 20.0));
        Triangle.printTriangleArea(new Triangle(7.0, 5.0, 3.0));


        Triangle.printTrianglePerimeter(new Triangle(10, 11, 20));
        Triangle.printTrianglePerimeter(new Triangle(20, 20, 30));

    }

}
