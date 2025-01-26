package ru.stqa.geometry.figures;

import java.util.Objects;

public record Triangle(double a, double b, double c) {

    public Triangle {

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return (Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.c) == 0)
                || (Double.compare(a, triangle.b) == 0 && Double.compare(b, triangle.c) == 0 && Double.compare(c, triangle.a) == 0)
                || (Double.compare(a, triangle.c) == 0 && Double.compare(b, triangle.a) == 0 && Double.compare(c, triangle.b) == 0)
                || (Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.c) == 0 && Double.compare(c, triangle.b) == 0)
                || (Double.compare(a, triangle.b) == 0 && Double.compare(b, triangle.a) == 0 && Double.compare(c, triangle.c) == 0)
                || (Double.compare(a, triangle.c) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.a) == 0);

    }

    @Override
    public int hashCode() {
        return 1;
    }
}
