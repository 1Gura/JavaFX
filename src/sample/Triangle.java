package sample;

import java.awt.*;
import java.util.Scanner;
class Triangle {
    //стороны
    int side1;
    int side2;
    int side3;

    boolean valid;

    Triangle(int side1, int side2, int side3) {
        //стороны
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        valid = side1 + side2 > side3
                && side2 + side3 > side1
                && side3 + side1 > side2;
    }

    void out() {
        if(this.valid) {
            System.out.println("Это треугольник");
            System.out.print("Первая сторона:");
            System.out.println(side1);
            System.out.print("Вторая сторона:");
            System.out.println(side2);
            System.out.print("Третья сторона:");
            System.out.println(side3);
        } else {
            System.out.println("Это не треугольник");
        }
    }

    double area() {
        double S = 0;
        if(this.valid) {
            int p = (side1 + side2 + side3)/2;
            S = Math.sqrt(p * (p-side1) * (p - side2) * (p - side3));
            return S;
        }
        else {
            return -1;
        }
    }
}
