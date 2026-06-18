package activities;

//Functional Interface
interface Addable {
 int add(int num1, int num2);
}

public class Activity11 {

 public static void main(String[] args) {

     Addable ad1 = (num1, num2) -> num1 + num2;

     Addable ad2 = (num1, num2) -> {
         return num1 + num2;
     };

     int result1 = ad1.add(10, 20);
     int result2 = ad2.add(30, 40);

     System.out.println("Result using ad1: " + result1);
     System.out.println("Result using ad2: " + result2);
 }
}