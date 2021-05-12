package test;
import java.util.Arrays;

public class Solution {

	// Function to merge the arrays.
	public static void merge(long arr1[], long arr2[], int n, int m) {
		int i = 0;
		int j = 0;
		while (i < n) {
			if (arr2[j] < arr1[i]) {
				// swap numbers to put them on right position
				long temp = arr1[i];
				arr1[i] = arr2[j];
				arr2[j] = temp;
				Arrays.sort(arr2);				
			}
			i++;
		}
		
		for(long item : arr1) {
			System.out.print( item + " ");
		}
		System.out.println();
		
		for(long item : arr2) {
			System.out.print( item + " ");
		}
	}

	 static int maximizeMoney(int N , int K) {
	        int i = 0;
	        int maxMoney = 0;
	        while(i< N){
	            maxMoney += K;
	            i = i+2;
	        }
	        return maxMoney;
	    }
	

 //MaxMoney problem
	public static void main(String[] args) {
		
//		merge(new long[] {3,9,11}, new long[] {4,6}, 3,2);
		System.out.println(maximizeMoney(2, 12));

	}

}
