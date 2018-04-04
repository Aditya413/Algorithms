package algo.Search;

import java.util.Scanner;

public class BinarySearch {
	
	public static void main(String args[]){
		BinarySearch bs = new BinarySearch();
		Scanner reader = new Scanner(System.in);
		int[] arr = new int[]{2,3,5,9,12,18,20};
		int length = arr.length;
		System.out.println("Enter the value you want to search");
		int searchValue = reader.nextInt();
		reader.close();
		int result = bs.useBinarySearch(arr, 0, length-1, searchValue);
		if(result != -1){
			System.out.println("Element present at index: "+result);
		}else{
			System.out.println("Element not found");
		}
	}
	
	int useBinarySearch(int arr[], int startIndex, int endIndex, int searchValue){
		if(endIndex >= startIndex){
			int mid = startIndex + (endIndex-1)/2;
			
			 // If the element is present at the 
            // middle itself
            if (arr[mid] == searchValue)
               return mid;
 
            // If element is smaller than mid, then 
            // it can only be present in left subarray
            if (arr[mid] > searchValue)
               return useBinarySearch(arr, startIndex, mid-1, searchValue);
 
            // Else the element can only be present
            // in right subarray
            return useBinarySearch(arr, mid+1, endIndex, searchValue);
		}
		
		return -1;
	}
}
