package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity10 {
    public static void main(String[] args) {

         Map<Integer, String> colours = new HashMap<>();

        colours.put(1, "Red");
        colours.put(2, "Blue");
        colours.put(3, "Green");
        colours.put(4, "Yellow");
        colours.put(5, "Black");

        System.out.println("Colours Map:");
        System.out.println(colours);

        colours.remove(4);

        System.out.println("\nAfter removing key 4:");
        System.out.println(colours);

        if (colours.containsValue("Green")) {
            System.out.println("\nGreen exists in the Map.");
        } else {
            System.out.println("\nGreen does not exist in the Map.");
        }

        System.out.println("\nSize of the Map: " + colours.size());
    }
}