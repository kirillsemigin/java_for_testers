package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void calculatePerimeter() {
        Assertions.assertEquals(40, new Triangle(10, 10, 20).trianglePerimeter());
    }

    @Test
    void calculatePerimeter_negative() {
        Assertions.assertEquals(40, new Triangle(-10, 10,20).trianglePerimeter());
    }

    @Test
    void calculatePerimeter_negative2() {
        Assertions.assertEquals(40, new Triangle(20, 20,30).trianglePerimeter());
    }

    @Test
    void calculateArea() {
        var s = new Triangle(10, 20, 20);
        double result = s.area();
        Assertions.assertEquals(96.82458365518542, result);
    }

    @Test
    void calculateArea_negative() {
        var s = new Triangle(10, 20, 20);
        double result = s.area();
        Assertions.assertEquals(7, result);
    }

}
