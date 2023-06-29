import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Oludare Busari
 *
 */
//Class implements Search Algorithms
public class Lab2SearchAlgorithm {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
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
		int linearSearchOutput = linearSearch(arr, key);
		long linearSearchEndTime = System.nanoTime();

		if (linearSearchOutput != -1) {
			System.out.print("Search key FOUND at index: " + linearSearchOutput);
		} else {
			System.out.println("Search key NOT FOUND.");
		}

		System.out.println("\n\nUsing Interpolation Search");

		long interpolationSearchStartTime = System.nanoTime();
		int interpolationSearchOutput = interpolationSearch(arr, key);
		long interpolationSearchEndTime = System.nanoTime();

		if (interpolationSearchOutput != -1) {
			System.out.print("Search key FOUND at index: " + interpolationSearchOutput);
		} else {
			System.out.println("Search key NOT FOUND.");
		}
		System.out.println();

		System.out.println("\n\nUsing Improved Linear Search");

		long improveLinearSearchStartTime = System.nanoTime();
		int improvedLinearSearchOutput = improveLinearSearch(arr, key);
		long improveLinearSearchEndTime = System.nanoTime();

		if (improvedLinearSearchOutput != -1) {
			System.out.print("Search key FOUND at index: " + improvedLinearSearchOutput);
		} else {
			System.out.println("Search key NOT FOUND.");
		}
		System.out.println();

		System.out.println("\nLinear Search running time: " + (linearSearchEndTime - linearSearchStartTime));
		System.out.println(
				"Interpolation Search running time: " + (interpolationSearchEndTime - interpolationSearchStartTime));
		System.out.println(
				"Improved Linear Search running time: " + (improveLinearSearchEndTime - improveLinearSearchStartTime));

	}


	// Class method responsible for Linear Search
	public static int linearSearch(int[] array, int key) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] == key)
				return i; // key FOUND and index returned
		}
		return -1; // key NOT FOUND and -1 returned
	}

	//class method used for interpolation search
	public static int interpolationSearch(int[] arr, int target) {
		Arrays.sort(arr);
		int lowInter = 0;
		int highInter = arr.length - 1;

		while (lowInter <= highInter && target >= arr[lowInter] && target <= arr[highInter]) {
			if (lowInter == highInter) {
				if (arr[lowInter] == target)
					return lowInter;
				return -1;
			}

			int pos = lowInter + (((highInter - lowInter) / (arr[highInter] - arr[lowInter])) * (target - arr[lowInter]));

			if (arr[pos] == target)
				return pos;

			if (arr[pos] < target)
				lowInter = pos + 1;
			else
				highInter = pos - 1;
		}
		return -1;
	}

	// class method that uses Sentinel Linear Search to improve the linear search
	public static int improveLinearSearch(int[] array, int key) {
		int length = array.length;
		int lastElementItem = array[length - 1]; // Store the last element

		// Replace the last element item with the key (sentinel value)
		array[length - 1] = key;

		int y = 0;
		while (array[y] != key) {
			y++;
		}

		// Restore the original last element item
		array[length - 1] = lastElementItem;

		if (y < length - 1 || array[length - 1] == key) {
			return y; // Key found at index i
		} else {
			return -1; // Key not found
		}

	}
}
