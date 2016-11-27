package ru.ruru.st.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dospeh on 22.11.2016.
 */
public class Collections {
    public static void main(String[] args) {
        String[] lengs = {"Java","C#","Python","PHP"};

        List<String> lenguages = Arrays.asList("Java","C#","Python","PHP");

        for (String l : lenguages) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}

