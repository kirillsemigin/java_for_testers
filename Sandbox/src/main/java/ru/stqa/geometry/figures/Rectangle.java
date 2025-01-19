package ru.stqa.geometry.figures;

public class Rectangle {
    public static void printRectangleArea(double a, double b) { // выводим информацию о площади квадарата
        System.out.println("Площадь прямоугольника со стронами " + a + " и " + b + " = " + rectangleArea(a, b));
    }

    private static double rectangleArea(double a, double b) { // производим расчет площади квадрата
        return a * b;
    }
}
