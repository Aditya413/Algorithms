package algo.Search;

import java.util.Scanner;
/*
 * Time complexity of linear search is O(N)
 * */
public class LinearSearch {
	public static void main(String args[]){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the number you want to search");
		int searchNum = reader.nextInt();
		reader.close();
		int arr[] = new int[]{10,20,30,40,50};
		int length = arr.length;
		int index = linearSearch(arr,length,searchNum);
		System.out.println("The index of your value is: "+index);
	}
	
	public static int linearSearch(int arr[], int length, int searchNum){
		for(int i=0; i < length; i++){
			if(arr[i] == searchNum){
				return i;
			}
		}
		
		return -1;
	}
}
