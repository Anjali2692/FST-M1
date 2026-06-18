package activities;

import java.util.ArrayList;

public class Activity8 {
    public static void main(String[] args) {

         ArrayList<String> myList = new ArrayList<>();

        myList.add("Alice");
        myList.add("Bob");
        myList.add("Charlie");
        myList.add("David");
        myList.add("Emma");

        System.out.println("Names in the ArrayList:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        System.out.println("\n3rd name in the list: " + myList.get(2));

       String searchName = "David";

        if (myList.contains(searchName)) {
            System.out.println(searchName + " exists in the ArrayList.");
        } else {
            System.out.println(searchName + " does not exist in the ArrayList.");
        }

        System.out.println("\nNumber of names in the list: " + myList.size());
        myList.remove("Bob");

        System.out.println("After removing Bob:");
        System.out.println("Updated size of the list: " + myList.size());

        System.out.println("\nUpdated ArrayList:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
}
