package algo.Sorting;

public class SelectionSort {
	public static void main(String args[]){
		int[] arr = new int[]{8,7,6,9,1,7,32,5,45,96,74,12};
		SelectionSort ss = new SelectionSort();
		ss.selectionSort(arr);
		ss.printMyArray(arr);
	}
	
	private void selectionSort(int[] arr){
		int length = arr.length;
		for(int i=0; i<length; i++){
			int min_idk = i;
			for(int j=i+1; j<length; j++){
				if(arr[j] < arr[min_idk]){
					min_idk = j;
				}
			}
			int temp = arr[min_idk];
			arr[min_idk] = arr[i];
			arr[i] = temp;
		}
	}
	
	private void printMyArray(int[] arr){
		int length = arr.length;
		for(int i=0; i<length; i++){
			System.out.println(arr[i]);
		}
	}
}
