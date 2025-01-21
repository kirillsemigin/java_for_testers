package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void calculatePerimeter() {
        double result = Triangle.trianglePerimeter(10, 10,20);
        Assertions.assertEquals(40, result);
    }

    @Test
    void calculatePerimeter_negative() {
        double result = Triangle.trianglePerimeter(-10, 10,20);
        Assertions.assertEquals(40, result);
    }

    @Test
    void calculatePerimeter_negative2() {
        double result = Triangle.trianglePerimeter(20, 20,30);
        Assertions.assertEquals(40, result);
    }

    @Test
    void calculateArea() {
        double result = Triangle.triangleArea(10, 20,20);
        Assertions.assertEquals();
    }

}
