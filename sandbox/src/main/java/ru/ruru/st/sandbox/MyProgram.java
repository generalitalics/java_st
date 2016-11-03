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
        System.out.println("Расстояние между точками = " + distance(p1, p2));
    }

    public static void hello(String somebody) {
        System.out.println("Hello-Hello, "+ somebody +"!");
    }
    /*Задание2*/
    public static double distance(Point p1,Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

}
