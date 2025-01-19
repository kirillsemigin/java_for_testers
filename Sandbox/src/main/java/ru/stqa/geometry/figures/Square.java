package ru.stqa.geometry.figures;

public class Square {
    public static void printSquareArea(double side) { // выводим информацию о площади треугольника
        String text = String.format("Площадь квадрата со стороной %f = %f", side, Area(side));
        System.out.println(text);
    }

    public static double Area(double a) { // производим расчет площади треугольника
        return a * a;
    }

    public static double perimeter(double a) {
        return 4 * a;
    }
}
