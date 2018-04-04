package algo.Sorting;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		int[] arr = new int[]{12, 11, 13, 5, 6};
		int length = arr.length;
		is.insertionSort(arr, length);
		is.printMyArray(arr, length);
	}
	
	private void insertionSort(int arr[], int length){
		for(int i=1; i<length; i++){
			int key = arr[i];
			int j = i-1;
			/* Move elements of arr[0..i-1], that are
            greater than key, to one position*/
			while(j>=0 && arr[j] > key){
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
	}
	
	private void printMyArray(int arr[], int length){
		for(int i=0; i<length; i++){
			System.out.println(arr[i]);
		}
	}
}
