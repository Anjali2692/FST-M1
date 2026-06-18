package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity12 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Random indexGen = new Random();

        System.out.println("Enter integer values (type any non-integer to stop):");

        while (scan.hasNextInt()) {
            int num = scan.nextInt();
            list.add(num);
        }

        Integer nums[] = list.toArray(new Integer[0]);

         if (nums.length > 0) {
        	 int randomIndex = indexGen.nextInt(nums.length);
        	 System.out.println("\nGenerated Index: " + randomIndex);
            System.out.println("Value at that index: " + nums[randomIndex]);

        } else {
            System.out.println("No integers were entered.");
        }

        scan.close();
    }
}
