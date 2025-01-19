package ru.stqa.geometry.figures;

public class Square {
    public static void printSquareArea(double side) { // выводим информацию о площади треугольника
        System.out.println("Площадь квадрата со стороной " + side + " = " + squareArea(side));
    }

    private static double squareArea(double a) { // производим расчет площади треугольника
        return a * a;
    }
}
