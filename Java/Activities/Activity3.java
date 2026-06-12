package activities;

public class Activity3 {
  
	
	public static String adjustDevice(String device,int value) {
		String status=null;
		switch(device){
			case "THERMOSTAT":
				if(value>=40) {
					System.out.println("[Thermostat] Warning: Temperature high.");
				}else {
					System.out.println("[Thermostat] Temperature is set to:" +value);
				}
				break;
			case "LIGHT":
				System.out.println("[Light] Adjusting brightness to :"+value);
				break;
			 case null:
	                status = "Device cannot be null.";
	                break;
			 default:
	                status = "Unknown device.";
	                break;
		}
		return status;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  	System.out.println(adjustDevice("THERMOSTAT", 45));
	        System.out.println(adjustDevice("THERMOSTAT", 25));
	        System.out.println(adjustDevice("LIGHT", 80));
	        System.out.println(adjustDevice(null, 50));
	}
	

}
