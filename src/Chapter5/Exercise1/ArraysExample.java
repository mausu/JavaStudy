package Chapter5.Exercise1;

import java.util.Arrays;
import java.util.Random;

class ArraysExample {
	public static void main(String[] args) {
		double[] nums = new double[10];
		Random random = new Random();
		for(int i=0;i<nums.length;i++){
			nums[i] = random.nextFloat();
		}
		myPrintln(nums);
		System.out.println("\n");
		Arrays.sort(nums);
		myPrintln(nums);
		System.out.println("\n");
		int result = Arrays.binarySearch(nums, 0.13);
		System.out.println(result + "\n");
		Arrays.fill(nums, 1);
		myPrintln(nums);
	}
	
	static void myPrintln(double[] array){
		for(int i=0;i<array.length;i++){
			System.out.println("[" + i + "] = " + array[i]);
		}
	}
}
