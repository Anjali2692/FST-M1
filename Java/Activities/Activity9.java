package activities;

import java.util.HashSet;

public class Activity9 {
    public static void main(String[] args) {

        HashSet<String> hs = new HashSet<>();

       hs.add("Apple");
        hs.add("Banana");
        hs.add("Mango");
        hs.add("Orange");
        hs.add("Grapes");
        hs.add("Pineapple");

        System.out.println("Size of HashSet: " + hs.size());

         hs.remove("Orange");
        System.out.println("Orange removed from the HashSet.");

        boolean removed = hs.remove("Watermelon");

        if (removed) {
            System.out.println("Watermelon removed.");
        } else {
            System.out.println("Watermelon is not present in the HashSet.");
        }

        if (hs.contains("Mango")) {
            System.out.println("Mango is present in the HashSet.");
        } else {
            System.out.println("Mango is not present in the HashSet.");
        }

        System.out.println("\nUpdated HashSet:");
        for (String item : hs) {
            System.out.println(item);
        }
    }
}