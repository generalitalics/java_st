package ru.ruru.st.sandbox;

/**
 * Created by Dospeh on 02.11.2016.
 */
public class Square {
    public double l;

    public Square(double l) {
        this.l = l;
    }

    public double area() {
        return this.l * this.l;
    }
}