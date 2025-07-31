package main.java;

import java.util.ArrayList;
import java.util.List;

public class WorkingWithLists {
    public static void main(String[] args) {
        List<String> colorUnmodifiable = List.of(
                "blue",
                "yellow"
        );
//        colorUnmodifiable.add("purple");; // It isn't possible

        List<String> colors = new ArrayList<>();
        colors.add("blue");
        colors.add("purple");
        colors.add("yellow");
        System.out.println(colors.size());
        System.out.println(colors.contains("yellow"));
        System.out.println(colors.contains("pink"));
        System.out.println(colors);

        // Loops through lists
        // #1
        for (String color : colors) {
            System.out.println(color);
        }
        // #2
        colors.forEach(System.out::println);
        // #3
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }
    }
}
