package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = {10, 77, 10, 54, -11, 10};

        int sum = 0;

        for (int num : numbers) {
            if (num == 10) {
                sum += num;
            }
        }

        // Check if sum is exactly 30
        boolean result = (sum == 30);

        System.out.println(result);
    }
}