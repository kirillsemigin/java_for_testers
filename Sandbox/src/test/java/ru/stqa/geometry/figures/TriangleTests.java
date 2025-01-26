package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {


   @Test
   void checkTriangle() {
       try {
           new Triangle(100, 20, 20);
           Assertions.fail("It is a triangle");
       } catch (ArithmeticException exception) {
           //Ok
       }
   }

    @Test
    void calculatePerimeter() {
       double result = new Triangle(10, 15, 20).trianglePerimeter();
        Assertions.assertEquals(45, result);
    }

    @Test
    void cannotCalculatePerimeter() {
        try {
            new Triangle(-10, 20, 20);
            Assertions.fail("There are no negative sides in a Triangle");
        } catch (IllegalArgumentException exception) {
            //Ok
        }
    }

    @Test
    void cannotCalculatePerimeter_2() {
        try {
            new Triangle(10, -20, 20);
            Assertions.fail("There are no negative sides in a Triangle");
        } catch (IllegalArgumentException exception) {
            //Ok
        }
    }

    @Test
    void cannotCalculatePerimeter_3() {
        try {
            new Triangle(10, 20, -20);
            Assertions.fail("There are no negative sides in a Triangle");
        } catch (IllegalArgumentException exception) {
            //Ok
        }
    }


    @Test
    void calculateArea() {
       double result = new Triangle(10, 20, 20).area();
        Assertions.assertEquals(96.82458365518542, result);
    }

    @Test
    void cannotCalculateArea() {
        try {
            new Triangle(-10, 20, 20);
            Assertions.fail("There are no negative sides in a Triangle");
        } catch (IllegalArgumentException exception) {
            //Ok
        }

    }

    @Test
    void cannotCalculateArea_2() {
        try {
            new Triangle(10, -20, 20);
            Assertions.fail("There are no negative sides in a Triangle");
        } catch (IllegalArgumentException exception) {
            //Ok
        }
    }

    @Test
    void cannotCalculateArea_3() {
        try {
            new Triangle(10, 20, -20);
            Assertions.fail("There are no negative sides in a Triangle");
        } catch (IllegalArgumentException exception) {
            //Ok
        }
    }
}



