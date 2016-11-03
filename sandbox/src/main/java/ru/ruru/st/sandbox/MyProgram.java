package ru.ruru.st.sandbox;

public class MyProgram {
    public static void main(String[] args) {
        hello("Max");

        Square s = new Square(5);
        System.out.println("Площадь " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника " + r.area());

        double a = 1.0;
        double sum = a + a;
        System.out.println("Вот сумма " + a + " + " + a + " = " + sum);

        Point p1 = new Point(1, 3);
        Point p2 = new Point(5, 7);
        System.out.println("Расстояние между точками = " + p1.distance(p2));
    }

    public static void hello(String somebody) {
        System.out.println("Hello-Hello, "+ somebody +"!");
    }

}
