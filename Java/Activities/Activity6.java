package activities;
import java.time.LocalDateTime;
import java.util.ArrayList;

class Plane {

    
    private int maxPassengers;
    private ArrayList<String> passengers;
    private LocalDateTime lastTimeLanded;

    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    public void onboard(String passenger) {
        if (passengers.size() < maxPassengers) {
            passengers.add(passenger);
        } else {
            System.out.println("Plane is full. Cannot onboard " + passenger);
        }
    }

    
    public LocalDateTime takeOff() {
        return LocalDateTime.now();
    }

    public void land() {
        lastTimeLanded = LocalDateTime.now();
        passengers.clear();
    }


    public LocalDateTime getLastTimeLanded() {
        return lastTimeLanded;
    }

    public ArrayList<String> getPassengers() {
        return passengers;
    }
}

public class Activity6 {

    public static void main(String[] args) {

        
        Plane plane = new Plane(10);

        plane.onboard("Avinash");
        plane.onboard("Rahul");
        plane.onboard("Priya");
        plane.onboard("Kiran");

        System.out.println("Take-off Time: " + plane.takeOff());

        System.out.println("Passengers: " + plane.getPassengers());

        try {
            
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        plane.land();

    
        System.out.println("Landing Time: " + plane.getLastTimeLanded());

        System.out.println("Passengers after landing: " + plane.getPassengers());
    }
}