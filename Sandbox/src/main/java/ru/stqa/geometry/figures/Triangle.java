package ru.stqa.geometry.figures;

public class Triangle {

    private double a;
    private double b;
    private double c;


    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Triangle side can not be negative or equals to zero");
      }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new ArithmeticException("It is not a triangle. One side is bigger than the sum of the other two sides");
        }
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
        double p = trianglePerimeter() / 2;
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }

    public double trianglePerimeter() {
        return this.a + this.b + this.c;
    }

}
