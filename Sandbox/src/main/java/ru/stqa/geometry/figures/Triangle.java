package ru.stqa.geometry.figures;

public class Triangle {

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public static void printTriangleArea(Triangle s) {
        var text = String.format("Площадь треугольника = %f", s.area());
        System.out.println(text);
    }

    public static void printTrianglePerimeter(Triangle s) {
        var text = String.format("Периметр треугольника = %f", s.trianglePerimeter());
        System.out.println(text);
    }


    public double area() {
        return Math.sqrt(((this.a + this.b + this.c)/2) * (((this.a + this.b + this.c)/2) - this.a) * (((this.a + this.b + this.c)/2) - this.b) * (((this.a + this.b + this.c)/2) - this.c));
    }

    public double trianglePerimeter() {
        return this.a + this.b + this.c;
    }
}
