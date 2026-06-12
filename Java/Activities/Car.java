package activities;

public class Car{
	String color,transmission;
	int make,tyres= 4,doors = 4;

public Car(String color,String transmission, int make) {
	this.color = color;
	this.transmission = transmission;
	this.make = make;
}

public void displayCharacteristics() {
	System.out.println("The color of the car is:"+color);
	System.out.println("The transmission of the car is:"+transmission);
	System.out.println("The model of the car is:"+make);
	System.out.println("The tyres of the car are:"+tyres);
	System.out.println("The doors of the car are:"+doors);
}

public void accelerate() {
	System.out.println("Car is moving forward.");
}

public void brake() {
	System.out.println("Car has stopped.");
}



}

