package ru.stqa.geometry.figures;

public class Triangle {

    private double a;
    private double b;
    private double c;
    private double p = semiPerimeter();

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public static void printTriangleArea(Triangle s) {
        var text = String.format("Площадь треугольника со сторонами %.2f, %.2f и %.2f = %.2f", s.a, s.b, s.c, s.area());
        System.out.println(text);
    }

    public static void printTrianglePerimeter(Triangle s) {
        var text = String.format("Периметр треугольника со сторонами сторонами %.2f, %.2f и %.2f = %.2f", s.a, s.b, s.c, s.trianglePerimeter());
        System.out.println(text);
    }


    public double area() {
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }

    public double trianglePerimeter() {
        return this.a + this.b + this.c;
    }

    private double semiPerimeter() {
        return trianglePerimeter() / 2;
    }
}
