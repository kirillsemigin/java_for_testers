package ru.stqa.geometry.figures;

public class Triangle {

    public static void printTriangleArea(double a, double b, double c) {
        var text = String.format("Площадь треугольника со сторонами %f, %f, и %f = %f"
                , a, b, c, triangleArea(a, b, c, semiPerimeter(a, b, c)));
        System.out.println(text);
    }

    private static double semiPerimeter(double a, double b, double c) {
        double p = a + b + c;
        return p;
    }

    private static double triangleArea(double a, double b, double c, double p) {
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
