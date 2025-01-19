package ru.stqa.geometry.figures;

public class Square {
    public static void printSquareArea(double side) { // выводим информацию о площади треугольника
        String text = String.format("Площадь квадрата со стороной %f = %f", side, squareArea(side));
        System.out.println(text);
    }

    private static double squareArea(double a) { // производим расчет площади треугольника
        return a * a;
    }
}
