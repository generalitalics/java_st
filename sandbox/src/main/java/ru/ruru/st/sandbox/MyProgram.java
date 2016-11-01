package ru.ruru.st.sandbox;

public class MyProgram {
    public static void main(String[] args) {
        hello("Max");
        System.out.println("Площадь " + area(4));
        System.out.println("Площадь прямоугольника " + area(4, 6));
        double a = 1.0;
        double s = a + a;
        System.out.println("Вот сумма " + a + " + " + a + " = " + s);
    }

    public static void hello(String somebody) {
        System.out.println("Hello-Hello, "+ somebody +"!");
    }

    public static double area(double a) {
        return a*a;
    }

    public static double area(double a, double b) {
        return a*b;
    }
}
