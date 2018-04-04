package algo.Sorting;

/**
 * We are going to implement Optimized bubble sort*/
public class BubbleSort {
	public static void main(String args[]){
		BubbleSort bs = new BubbleSort();
		int[] arr = new int[]{3,2,4,6,7,1,9,11,20,17};
		int length = arr.length;
		bs.optimizedBubbleSort(arr, length);
		bs.printMyArray(arr, length);
	}
	
	private void optimizedBubbleSort(int arr[], int length){
		int i, j, temp;
		boolean isSwapped;
		
		for(i = 0; i < length-1; i++){
			isSwapped = false;
			for(j = 0; j < length-i-1; j++){
				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					isSwapped = true;
				}
			}
			
			if(!isSwapped){
				break;
			}
		}
	}
	
	private void printMyArray(int arr[], int length){
		for(int i=0; i<length; i++){
			System.out.println(arr[i]);
		}
	}
}
