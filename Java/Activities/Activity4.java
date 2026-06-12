package activities;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num= {4,3,2,10,12,1,5,6};
		int swape=0;
		for(int i=0; i<num.length-1; i++) {
		for(int j=i+1;j<num.length;j++) {
			if(num[i]>num[j]) {
				
				swape =num[i];
				num[i]=num[j];
				num[j]=swape;
				
			}
			
		}
		
			
		}
		 System.out.print("Sorted array is: ");
		   for (int n : num) {
	         System.out.print(n + " ");
	        }
		
	}

	
}
