
package com.kodnest.prefixhashset;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Problem: Find the Length of the Longest Subarray With Sum Equal to Target
 *
 * Description:
 * This program finds the maximum length of a contiguous subarray
 * whose sum is equal to a given target value.
 *
 * Approach:
 * Uses the Prefix Sum technique and HashMap to store prefix sums
 * and their earliest indices, allowing efficient calculation
 * of the longest valid subarray.
 *
 * Time Complexity: O(n) average case
 * Space Complexity: O(n)
 */
public class LongestSubArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Read the size of the array
        int n = sc.nextInt();

        // Create an array of size n
        int [] arr = new int[n];

        // Read the array elements
        for(int i = 0; i <  n; i++) {
            arr[i] = sc.nextInt();
        }

        // Read the target sum
        int k = sc.nextInt();

        // Call the method and print the length of the longest valid subarray
        System.out.println(checkingLongestSubArraySumEqualsSum(n, arr, k));

        // Close the Scanner
        sc.close();
    }

    /**
     * Finds the length of the longest contiguous subarray whose sum
     * is equal to the given target.
     *
     * Logic:
     * 1. Calculate the running prefix sum.
     * 2. Find the required previous prefix sum using pref - target.
     * 3. If the required prefix sum exists, calculate the subarray
     *    length using the current index and the stored index.
     * 4. Update maxLength if a longer valid subarray is found.
     * 5. Store the current prefix sum in the HashMap.
     *
     * @param n      Number of elements in the array
     * @param arr    Input array
     * @param target Required subarray sum
     * @return Length of the longest contiguous subarray with the target sum
     */
    public static int checkingLongestSubArraySumEqualsSum(int n, int [] arr, int target) {

        // Store prefix sums and their associated values in a HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        // Running prefix sum
        int pref = 0;

        // Stores the maximum length of a valid subarray
        int maxLength = 0;

        // Store prefix sum 0 at index -1.
        // This allows subarrays starting at index 0 to be considered.
        map.put(0, -1);

        // Traverse the array using its indices
        for(int i = 0; i < n;  i++) {

            // Update the running prefix sum
            pref += arr[i];

            // Calculate the previous prefix sum needed to obtain target
            int need = pref - target;

            // Check whether the required prefix sum has been encountered
            if(map.containsKey(need)) {

                // Calculate the length of the subarray between
                // the stored prefix sum index and the current index
                int curLength = i - map.get(need);

                // Update the maximum length if the current subarray is longer
                maxLength = Math.max(maxLength, curLength);
            }

            // Store the current prefix sum or update its frequency
            map.put(pref, map.getOrDefault(pref, 0)+1);
        }

        // Return the maximum length found
        return maxLength;
    }

}
