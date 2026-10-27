```java
package com.kodnest.prefixhashset;

import java.util.HashMap;
import java.util.Scanner;

public class SmallestSubArray {

    // Main method: execution of the program starts here.
    public static void main(String[] args) {

        // Creates a Scanner object to read input from the user.
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

        // Reads the target sum that a subarray must equal.
        int k = sc.nextInt();

        // Calls the method to find the length of the smallest
        // subarray whose sum equals k and prints the result.
        System.out.println(smallestCSubArraySumEquals(n, arr, k));

        // Closes the Scanner to release the input resource.
        sc.close();
    }

    /**
     * Finds the length of the smallest contiguous subarray
     * whose sum is equal to the specified target.
     *
     * @param n      the number of elements in the array
     * @param arr    the input integer array
     * @param target the required subarray sum
     * @return the minimum length of a matching subarray,
     *         or -1 if no matching subarray exists
     */
    public static int smallestCSubArraySumEquals(
            int n, int[] arr, int target) {

        // Creates a HashMap to store:
        // key   = prefix sum
        // value = index where that prefix sum was encountered.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initializes the running prefix sum to zero.
        int pref = 0;

        // Initializes the minimum length to the largest
        // possible integer value, indicating no match found yet.
        int minLength = Integer.MAX_VALUE;

        // Stores prefix sum 0 at index -1.
        // This helps identify subarrays that start at index 0.
        map.put(0, -1);

        // Traverses the array from index 0 to n - 1.
        for (int i = 0; i < n; i++) {

            // Adds the current element to the running prefix sum.
            pref += arr[i];

            // Calculates the prefix sum required before the
            // current subarray so that its sum equals target.
            int need = pref - target;

            // Checks whether the required prefix sum exists
            // in the HashMap.
            if (map.containsKey(need)) {

                // Calculates the length of the subarray
                // using the current index and the stored
                // index of the required prefix sum.
                int curLength = i - map.get(need);

                // Updates minLength if the current subarray
                // is shorter than the previously found subarray.
                minLength = Math.min(minLength, curLength);
            }

            // Stores the current prefix sum and its index.
            // If the prefix sum already exists, its index
            // is overwritten with the current index.
            map.put(pref, i);
        }

        // Returns -1 if no matching subarray was found.
        // Otherwise, returns the smallest subarray length.
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }
}
```
