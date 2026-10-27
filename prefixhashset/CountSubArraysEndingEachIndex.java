```java
// Defines the package to which this Java class belongs.
package com.kodnest.prefixhashset;

// Imports HashMap to store prefix sums and their frequencies.
import java.util.HashMap;

// Imports Scanner to read input from the user.
import java.util.Scanner;

// Declares a class to count subarrays ending at each index
// whose sum is equal to the given target value k.
public class CountSubArraysEndingEachIndex {

    // Main method: execution of the Java program starts here.
    public static void main(String[] args) {

        // Creates a Scanner object to read input from the keyboard.
        Scanner sc = new Scanner(System.in);

        // Reads the number of elements in the array.
        int n = sc.nextInt();

        // Creates an integer array of size n.
        int[] arr = new int[n];

        // Iterates through the array to read its elements.
        for (int i = 0; i < n; i++) {

            // Reads an integer and stores it at index i.
            arr[i] = sc.nextInt();
        }

        // Reads the target sum k.
        int k = sc.nextInt();

        // Calls checkingSubArrays() to count valid subarrays
        // ending at every index and stores the result.
        int[] result = checkingSubArrays(n, arr, k);

        // Iterates through the result array.
        for (int val : result) {

            // Prints each count followed by a space.
            System.out.print(val + " ");
        }

        // Closes the Scanner to release the input resource.
        sc.close();
    }

    /**
     * Counts the number of subarrays ending at each index
     * whose sum is equal to the target value k.
     *
     * @param n   the number of elements in the array
     * @param arr the input integer array
     * @param k   the target sum of each subarray
     * @return an integer array where res[i] contains the
     *         number of valid subarrays ending at index i
     */
    public static int[] checkingSubArrays(int n, int[] arr, int k) {

        // Creates a HashMap to store:
        // key   = prefix sum encountered so far
        // value = number of times that prefix sum has occurred.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initializes the running prefix sum to zero.
        int pref = 0;

        // Stores the initial prefix sum 0 with frequency 1.
        // This allows subarrays starting at index 0 to be counted
        // when their sum is equal to k.
        map.put(0, 1);

        // Creates an array to store the count of valid subarrays
        // ending at each index of the input array.
        int[] res = new int[n];

        // Traverses the input array from index 0 to n - 1.
        for (int i = 0; i < n; i++) {

            // Adds the current array element to the running
            // prefix sum, representing the sum from index 0 to i.
            pref += arr[i];

            // Calculates the prefix sum needed before the current
            // subarray so that the subarray sum becomes k.
            // Required prefix sum = current prefix sum - target sum.
            int need = pref - k;

            // Checks whether the required prefix sum has appeared
            // previously in the HashMap.
            if (map.containsKey(need)) {

                // If it exists, its frequency gives the number
                // of valid subarrays ending at the current index i.
                res[i] = map.get(need);

            } else {

                // If the required prefix sum does not exist,
                // no valid subarray ending at index i is found.
                res[i] = 0;
            }

            // Updates the frequency of the current prefix sum.
            // If pref already exists, increments its frequency by 1.
            // Otherwise, inserts pref into the map with frequency 1.
            map.put(pref, map.getOrDefault(pref, 0) + 1);
        }

        // Returns the array containing the count for each index.
        return res;
    }
}
```
