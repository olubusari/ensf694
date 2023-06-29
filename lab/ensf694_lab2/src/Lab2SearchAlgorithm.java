import java.util.Arrays;
import java.util.Scanner;

public class Lab2SearchAlgorithm {

	static Scanner scanner = new Scanner(System.in);

	public static int linearSearch(int[] array, int key) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] == key)
				return i; // key FOUND and index returned
		}
		return -1; // key NOT FOUND and -1 returned
	}

	public static int interpolationSearch(int[] arr, int target) {
		Arrays.sort(arr);
		int low = 0;
		int high = arr.length-1;

		while (low <= high && target >= arr[low] && target <= arr[high]) {
			if (low == high) {
				if (arr[low] == target)
					return low;
				return -1;
			}

			int pos = low + (((high - low) / (arr[high] - arr[low])) * (target - arr[low]));

			if (arr[pos] == target)
				return pos;

			if (arr[pos] < target)
				low = pos + 1;
			else
				high = pos - 1;
		}
		return -1;
	}
	
	public static int improveLinearSearch(int[] array, int key) {
		int length = array.length;
	    int i = 0;

	    while (i < length - 1) {
	        if (array[i] == key)
	            return i; // key FOUND and index returned

	        if (array[i + 1] == key)
	            return i + 1; // key FOUND and index returned

	        i += 2;
	    }

	    // Check the last element if the array length is odd
	    if (i == length - 1 && array[i] == key)
	        return i; // key FOUND and index returned

	    return -1; // key NOT FOUND and -1 returned
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(System.in);
		int arraySize;
		int arr[];
		int element;
		System.out.print("Enter the number of elements in the array: ");
		arraySize = scanner.nextInt();
		arr = new int[arraySize];
		System.out.println("Enter the elements in the array:");
		for (int i = 0; i < arraySize; i++) {
			element = scanner.nextInt();
			arr[i] = element;
		}

		System.out.print("Enter the search key: ");

		int key = scanner.nextInt();

		System.out.println("\nUsing Linear Search");
		
		long linearSearchStartTime = System.nanoTime();
		int linearSearchOutput =  linearSearch(arr, key);
		long linearSearchEndTime = System.nanoTime();
		
		System.out.print("Search key FOUND at index: " + linearSearchOutput);

		System.out.println("\n\nUsing Interpolation Search");
		
		long interpolationSearchStartTime = System.nanoTime();
		int interpolationSearchOutput = interpolationSearch(arr, key);
		long interpolationSearchEndTime = System.nanoTime();

		System.out.print("Search key FOUND at index: " + interpolationSearchOutput);
		System.out.println();
		
		System.out.println("\n\nUsing Improved Linear Search");
		
		long improveLinearSearchStartTime = System.nanoTime();
		int improvedLinearSearchOutput = improveLinearSearch(arr, key);
		long improveLinearSearchEndTime = System.nanoTime();
		
		System.out.print("Search key FOUND at index: " + improvedLinearSearchOutput);
		System.out.println();
		
		System.out.println("\nLinear Search running time: " + (linearSearchEndTime - linearSearchStartTime));
		System.out.println("Interpolation Search running time: " + (interpolationSearchEndTime - interpolationSearchStartTime));
		System.out.println("Improved Linear Search running time: " + (improveLinearSearchEndTime - improveLinearSearchStartTime));
		
	}

}
