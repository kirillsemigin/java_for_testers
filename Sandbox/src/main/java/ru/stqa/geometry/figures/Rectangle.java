package ru.stqa.geometry.figures;

public record Rectangle(double a, double b) {

    
    public static void printRectangleArea(double a, double b) { // выводим информацию о площади квадарата
       var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", a, b, rectangleArea(a, b));
        System.out.println(text);
    }

    private static double rectangleArea(double a, double b) { // производим расчет площади квадрата
        return a * b;
    }
}
