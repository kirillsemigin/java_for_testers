package ru.stqa.geometry.figures;

import java.util.Objects;

public record Triangle(double a, double b, double c) {

    public Triangle {

        if (a <= 0 || b <= 0 || c <= 0) { // Логика проверки размера стороны треугольника. Сторона не может равняться 0 или быть отрицательной
            throw new IllegalArgumentException("Triangle side can not be negative or equals to zero");
      }
        if (a + b <= c || a + c <= b || b + c <= a) { // Логика проверки существования треугольника. Сумма длинн 2-х сторон не может быть меньше третьей стороны.
            throw new ArithmeticException("It is not a triangle. One side is bigger than the sum of the other two sides");
        }
    }


    public static void printTriangleArea(Triangle s) { // выводим на экран сообщение о площади треугольника
        var text = String.format("Площадь треугольника со сторонами %.2f, %.2f и %.2f = %.2f", s.a, s.b, s.c, s.area());
        System.out.println(text);
    }

    public static void printTrianglePerimeter(Triangle s) {  // выводим на экран сообщение о периметре треугольника
        var text = String.format("Периметр треугольника со сторонами сторонами %.2f, %.2f и %.2f = %.2f", s.a, s.b, s.c, s.trianglePerimeter());
        System.out.println(text);
    }


    public double area() {  // Расчет площади треугольника
        double p = trianglePerimeter() / 2; // получаем значение полупериметра треугольника и кладем его в переменную
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }

    public double trianglePerimeter() { // Расчет периметра треугольника
        return this.a + this.b + this.c;
    }

    @Override
    public boolean equals(Object o) {   // условие сравнения треугольников
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
